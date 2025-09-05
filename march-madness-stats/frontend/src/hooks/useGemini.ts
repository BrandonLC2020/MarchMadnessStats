import { GoogleGenerativeAI } from "@google/generative-ai";
import { useState } from "react";

const useGemini = () => {
  const [analysis, setAnalysis] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const getAnalysis = async (data: any) => {
    setLoading(true);
    setError(null);

    const maxRetries = 3;
    const initialDelay = 1000; // 1 second

    for (let attempt = 0; attempt < maxRetries; attempt++) {
      try {
        const genAI = new GoogleGenerativeAI(process.env.REACT_APP_GEMINI_API_KEY || "");
        const model = genAI.getGenerativeModel({ model: "gemini-1.5-flash" });
        const prompt = `Analyze the following basketball data and provide a summary: ${JSON.stringify(data)}`;
        const result = await model.generateContent(prompt);
        const response = await result.response;
        setAnalysis(response.text());
        setLoading(false);
        return; // Success, exit the function
      } catch (err: any) {
        // Check if it's a 503 error and not the last attempt
        if (err.message && err.message.includes('[503') && attempt < maxRetries - 1) {
          const delay = initialDelay * Math.pow(2, attempt); // Exponential backoff
          console.warn(`Model overloaded. Retrying in ${delay}ms...`);
          await new Promise(resolve => setTimeout(resolve, delay));
        } else {
          // If it's a different error or the last retry failed, set the error
          setError(err.message || "An unexpected error occurred");
          setLoading(false);
          return; // Failure, exit the function
        }
      }
    }
  };

  return { analysis, loading, error, getAnalysis };
};

export default useGemini;