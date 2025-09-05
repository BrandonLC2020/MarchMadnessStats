// frontend/src/components/PlayerCard.tsx
import React from 'react';
import { Card, CardActionArea, CardContent, Typography } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import { TeamRosterPlayer } from '../types/api';

interface PlayerCardProps {
  player: TeamRosterPlayer;
}

const PlayerCard: React.FC<PlayerCardProps> = ({ player }) => {
    return (
        <Card sx={{ minWidth: 275, mb: 2, height: '100%' }}>
            <CardActionArea component={RouterLink} to={`/player/${player.id}`} state={{ player }} sx={{ height: '100%' }}>
                <CardContent>
                    <Typography variant="h6" component="div">
                        {player.name}
                    </Typography>
                    <Typography sx={{ mb: 1.5 }} color="text.secondary">
                        {player.position}
                    </Typography>
                </CardContent>
            </CardActionArea>
        </Card>
    );
};

export default PlayerCard;