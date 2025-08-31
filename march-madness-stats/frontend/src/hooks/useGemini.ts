import { GoogleGenerativeAI } from "@google/generative-ai";
import { useState } from "react";

const useGemini = () => {
  const [analysis, setAnalysis] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const getAnalysis = async (data: any) => {
    setLoading(true);
    setError(null);
    try {
      const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY || "");
      const model = genAI.getGenerativeModel({ model: "gemini-pro" });
      const prompt = `Analyze the following basketball data and provide a summary: ${JSON.stringify(data)}`;
      const result = await model.generateContent(prompt);
      const response = await result.response;
      setAnalysis(response.text());
    } catch (err: any) {
      setError(err.message || "An unexpected error occurred");
    } finally {
      setLoading(false);
    }
  };

  return { analysis, loading, error, getAnalysis };
};

export default useGemini;