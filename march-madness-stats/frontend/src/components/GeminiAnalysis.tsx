import React from 'react';
import { Button, Card, CardContent, Typography, CircularProgress, Alert } from '@mui/material';
import useGemini from '../hooks/useGemini';
import ReactMarkdown from 'react-markdown';

interface GeminiAnalysisProps {
  data: any;
}

const GeminiAnalysis: React.FC<GeminiAnalysisProps> = ({ data }) => {
  const { analysis, loading, error, getAnalysis } = useGemini();

  return (
    <div>
      <Button variant="contained" color="primary" onClick={() => getAnalysis(data)} disabled={loading}>
        Analyze with Gemini
      </Button>
      {loading && <CircularProgress />}
      {error && <Alert severity="error">{error}</Alert>}
      {analysis && (
        <Card sx={{ mt: 2 }}>
          <CardContent>
            <Typography variant="h6">Gemini Analysis</Typography>
            <ReactMarkdown>{analysis}</ReactMarkdown>
          </CardContent>
        </Card>
      )}
    </div>
  );
};

export default GeminiAnalysis;