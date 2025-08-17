import React from 'react';
import { Card, CardActionArea, CardContent, Typography } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import { ConferenceHistory } from '../types/api';

interface ConferenceCardProps {
  conference: ConferenceHistory
}

const ConferenceCard: React.FC<ConferenceCardProps> = ({ conference }) => {
  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardActionArea component={RouterLink} to={`/conferences/${conference.abbreviation}`} state={{ conference }}>
        <CardContent>
          <Typography variant="h5" component="div">
            {conference.name} ({conference.abbreviation})
          </Typography>
          {!!conference.teams &&
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