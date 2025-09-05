// frontend/src/views/PlayerView.tsx
import React from 'react';
import { Typography, Paper, Box } from '@mui/material';
import { useLocation } from 'react-router-dom';
import { PlayerSeasonShootingStats, PlayerSeasonStats, TeamRosterPlayer } from '../types/api';
import PlayerSeasonStatsCard from '../components/PlayerSeasonStatsCard';
import { SEASON_SEARCH_OPTIONS } from '../types/currentData';
import ShootingPieChart from '../components/ShootingPieChart';
import ReboundsPieChart from '../components/ReboundsPieChart';
import ShotDistributionPieChart from '../components/ShotDistributionPieChart';
import ShotTypeBarChart from '../components/ShotTypeBarChart';

const PlayerView: React.FC = () => {
    const location = useLocation();
    const player = location.state?.player as TeamRosterPlayer;
    const playerSeasonStatsData = location.state?.playerSeasonStatsData as PlayerSeasonStats[];
    const playerSeasonShootingStatsData = location.state?.playerSeasonShootingStatsData as PlayerSeasonShootingStats[];

    if (!player) {
        return <Typography>Player data not available.</Typography>;
    }

    return (
        <Box sx={{ pb: 4 }}>
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
                    Start Season: {SEASON_SEARCH_OPTIONS.find(option => option.value === player.startSeason)?.label}
                </Typography>
                <Typography variant="body1" gutterBottom>
                    End Season: {SEASON_SEARCH_OPTIONS.find(option => option.value === player.endSeason)?.label}
                </Typography>
                {player.hometown && (
                    <Typography variant="body1" gutterBottom>
                        Hometown: {player.hometown.city}, {player.hometown.state}
                    </Typography>
                )}
            </Paper>
            {playerSeasonStatsData && playerSeasonStatsData.map(stats => {
                const shootingStats = playerSeasonShootingStatsData.find(ss => ss.season === stats.season);
                return (
                    <React.Fragment key={stats.season}>
                        <Typography variant="h5" sx={{ mt: 3, mb: 1 }}>
                            {`${SEASON_SEARCH_OPTIONS.find(s => s.value === stats.season)?.label}`} Stat Breakdown
                        </Typography>
                        <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                            <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                                <ShootingPieChart shootingData={stats} />
                            </Box>
                            <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                                <ReboundsPieChart reboundsData={stats.rebounds} />
                            </Box>
                        </Box>
                        {shootingStats && (
                            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2, mt: 2 }}>
                                <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                                    <ShotTypeBarChart shootingData={shootingStats} />
                                </Box>
                                <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                                    <ShotDistributionPieChart shootingData={shootingStats} />
                                </Box>
                            </Box>
                        )}
                        <Box sx={{ mt: 2 }}>
                            <PlayerSeasonStatsCard stats={stats} />
                        </Box>
                    </React.Fragment>
                )
            })}
        </Box>
    );
};

export default PlayerView;