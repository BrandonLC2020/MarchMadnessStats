import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';
import { ConferenceHistoryTeamsInner } from '../types/api';

interface ConferenceTeamCardProps {
  team: ConferenceHistoryTeamsInner;
}

const ConferenceTeamCard: React.FC<ConferenceTeamCardProps> = ({ team }) => {
    return (
        <Card sx={{ minWidth: 200, mb: 2 }}>
            <CardContent>
                <Typography variant="h6" component="div">
                    {team.school}
                </Typography>
                <Typography sx={{ mb: 1.5 }} color="text.secondary">
                    {team.mascot}
                </Typography>
            </CardContent>
        </Card>
    );
};

export default ConferenceTeamCard;
