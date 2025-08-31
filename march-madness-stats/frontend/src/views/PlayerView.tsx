import React from 'react';
import { Typography, Paper, Grid } from '@mui/material';
import { useLocation } from 'react-router-dom';
import { PlayerSeasonShootingStats, PlayerSeasonStats, TeamRosterPlayer } from '../types/api';
import PlayerSeasonStatsCard from '../components/PlayerSeasonStatsCard';
import PlayerSeasonShootingStatsCard from '../components/PlayerSeasonShootingStatsCard';

const PlayerView: React.FC = () => {
    const location = useLocation();
    const player = location.state?.player as TeamRosterPlayer;
    const playerSeasonStatsData = location.state?.playerSeasonStatsData as PlayerSeasonStats[];
    const playerSeasonShootingStatsData = location.state?.playerSeasonShootingStatsData as PlayerSeasonShootingStats[];

    if (!player) {
        return <Typography>Player data not available.</Typography>;
    }

    return (
        <div>
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
            <Grid container spacing={2} sx={{ mt: 2 }}>
                {playerSeasonStatsData && playerSeasonStatsData.map((stats) => (
                    <Grid key={stats.season}>
                        <PlayerSeasonStatsCard stats={stats} />
                    </Grid>
                ))}
            </Grid>
            <Grid container spacing={2} sx={{ mt: 2 }}>
                {playerSeasonShootingStatsData && playerSeasonShootingStatsData.map((stats) => (
                    <Grid key={stats.season}>
                        <PlayerSeasonShootingStatsCard stats={stats} />
                    </Grid>
                ))}
            </Grid>
        </div>
    );
};

export default PlayerView;