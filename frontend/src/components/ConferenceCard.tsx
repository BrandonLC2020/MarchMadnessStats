// frontend/src/components/ConferenceCard.tsx
import React from 'react';
import { Card, CardActionArea, CardContent, Typography } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import { ConferenceHistory, ConferenceInfo } from '../types/api';

interface ConferenceCardProps {
  conference: ConferenceHistory | ConferenceInfo;
}

const ConferenceCard: React.FC<ConferenceCardProps> = ({ conference }) => {
  return (
    <Card sx={{ minWidth: 275, mb: 2, height: '100%' }}>
      <CardActionArea component={RouterLink} to={`/conferences/${conference.abbreviation}`} state={{ conference }} sx={{ height: '100%' }}>
        <CardContent>
          <Typography variant="h5" component="div">
            {conference.name} ({conference.abbreviation})
          </Typography>
          {'teams' in conference && !!conference.teams &&
              <Typography sx={{ mb: 1.5 }} color="text.secondary">
              {conference.teams?.length} teams
              </Typography>
          }
        </CardContent>
      </CardActionArea>
    </Card>
  );
};

export default ConferenceCard;