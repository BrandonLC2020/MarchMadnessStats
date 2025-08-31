// frontend/src/components/ConferenceTeamCard.tsx
import React from 'react';
import { Card, CardActionArea, CardContent, Typography } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import { ConferenceHistoryTeamsInner } from '../types/api';

interface ConferenceTeamCardProps {
  team: ConferenceHistoryTeamsInner;
}

const ConferenceTeamCard: React.FC<ConferenceTeamCardProps> = ({ team }) => {
    return (
        <Card sx={{ minWidth: 275, mb: 2 }}>
            <CardActionArea component={RouterLink} to={`/team/${team.id}`} state={{ team }}>
                <CardContent>
                    <Typography variant="h6" component="div">
                        {team.school}
                    </Typography>
                    <Typography sx={{ mb: 1.5 }} color="text.secondary">
                        {team.mascot}
                    </Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    );
};

export default ConferenceTeamCard;