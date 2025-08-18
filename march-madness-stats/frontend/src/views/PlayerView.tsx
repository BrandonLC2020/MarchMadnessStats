import React from 'react';
import { Typography, Paper } from '@mui/material';
import { TeamRosterPlayer } from '../types/api';

interface PlayerViewProps {
    player: TeamRosterPlayer
}

const PlayerView: React.FC<PlayerViewProps> = ({ player }) => {
    return (
        <Paper>
            <Typography variant="h4" component="h1" gutterBottom>
                {player.name} - #{player.jersey}
            </Typography>
            <Typography variant="body1" gutterBottom>
                Position: {player.position}
            </Typography>
            <Typography variant="body1" gutterBottom>
                Height: {player.height}
            </Typography>
            <Typography variant="body1" gutterBottom>
                Weight: {player.weight}
            </Typography>
            <Typography variant="body1" gutterBottom>
                Start Season: {player.startSeason}
            </Typography>
            <Typography variant="body1" gutterBottom>
                End Season: {player.endSeason}
            </Typography>
            <Typography variant="body1" gutterBottom>
                Hometown: {player.hometown.city}, {player.hometown.state}
            </Typography>
        </Paper>
    );
};

export default PlayerView;