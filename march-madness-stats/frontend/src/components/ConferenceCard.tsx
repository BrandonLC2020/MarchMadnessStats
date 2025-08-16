import React from 'react';
import { Card, CardContent, Typography, Box } from '@mui/material';

interface ConferenceCardProps {
  conference: {
    id: number;
    sourceId: string;
    name: string;
    abbreviation: string;
    shortName: string;
    teams: {
        id: number;
        sourceId: string;
        school: string;
        mascot: string;
        startSeason: number;
        endSeason: number | null;
    }[];
  };
}

const ConferenceCard: React.FC<ConferenceCardProps> = ({ conference }) => {
  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h5" component="div">
          {conference.name} ({conference.abbreviation})
        </Typography>
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
          {conference.teams.length} teams
        </Typography>
      </CardContent>
    </Card>
  );
};

export default ConferenceCard;
