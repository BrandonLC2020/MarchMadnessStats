import React from 'react';
import { Typography, Paper } from '@mui/material';
import { useLocation } from 'react-router-dom';
import { TeamRosterPlayer } from '../types/api';

const PlayerView: React.FC = () => {
    const location = useLocation();
    const player = location.state?.player as TeamRosterPlayer;

    if (!player) {
        return <Typography>Player data not available.</Typography>;
    }

    return (
        <Paper sx={{ p: 3, mt: 3 }}>
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
            {player.hometown && (
                <Typography variant="body1" gutterBottom>
                    Hometown: {player.hometown.city}, {player.hometown.state}
                </Typography>
            )}
        </Paper>
    );
};

export default PlayerView;