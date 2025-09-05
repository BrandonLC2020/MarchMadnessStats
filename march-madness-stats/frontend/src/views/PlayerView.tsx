// frontend/src/views/PlayerView.tsx
import React, { useEffect, useState } from 'react';
import { Typography, Paper, Box, Button, CircularProgress } from '@mui/material';
import { useLocation } from 'react-router-dom';
import { PlayerSeasonShootingStats, PlayerSeasonStats, TeamRosterPlayer } from '../types/api';
import PlayerSeasonStatsCard from '../components/PlayerSeasonStatsCard';
import { SEASON_SEARCH_OPTIONS } from '../types/currentData';
import ShootingPieChart from '../components/ShootingPieChart';
import ReboundsPieChart from '../components/ReboundsPieChart';
import ShotDistributionPieChart from '../components/ShotDistributionPieChart';
import ShotTypeBarChart from '../components/ShotTypeBarChart';
import GeminiAnalysis from '../components/GeminiAnalysis';
import { doc, setDoc, getDoc, deleteDoc } from 'firebase/firestore';
import { db } from '../firebase';
import { useStats } from '../hooks/useStats';

const PlayerView: React.FC = () => {
    const location = useLocation();
    const player = location.state?.player as TeamRosterPlayer;
    const [playerSeasonStatsData, setPlayerSeasonStatsData] = useState<PlayerSeasonStats[]>(location.state?.playerSeasonStatsData || []);
    const [playerSeasonShootingStatsData, setPlayerSeasonShootingStatsData] = useState<PlayerSeasonShootingStats[]>(location.state?.playerSeasonShootingStatsData || []);
    const [isFavorite, setIsFavorite] = useState<boolean>(false);
    const [loading, setLoading] = useState<boolean>(false);
    const { getPlayerSeasonStats, getPlayerSeasonShootingStats } = useStats();

    useEffect(() => {
        const checkIfFavorite = async () => {
            if (player) {
                const docRef = doc(db, "favoritePlayers", player.id.toString());
                const docSnap = await getDoc(docRef);
                setIsFavorite(docSnap.exists());
            }
        };

        const fetchMissingStats = async () => {
            if (player && playerSeasonStatsData.length === 0) {
                setLoading(true);
                try {
                    const seasons = Array.from({ length: player.endSeason - player.startSeason + 1 }, (_, i) => player.startSeason + i);

                    const statsPromises = seasons.map(season => getPlayerSeasonStats({ season, team: undefined }));
                    const allStatsResponses = await Promise.all(statsPromises);
                    const allPlayerStats = allStatsResponses.flat().filter(stat => stat.athleteId === player.id);
                    setPlayerSeasonStatsData(allPlayerStats);

                    if (allPlayerStats.length > 0) {
                        const shootingStatsPromises = allPlayerStats.map(playerStat =>
                            getPlayerSeasonShootingStats({ season: playerStat.season, team: playerStat.team, conference: playerStat.conference || undefined })
                        );

                        const allShootingStatsResponses = await Promise.all(shootingStatsPromises);
                        const allPlayerShootingStats = allShootingStatsResponses.flat().filter(stat => stat.athleteId === player.id);
                        setPlayerSeasonShootingStatsData(allPlayerShootingStats);
                    }
                } catch (error) {
                    console.error("Failed to fetch player stats:", error);
                } finally {
                    setLoading(false);
                }
            }
        };

        checkIfFavorite();
        fetchMissingStats();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [player]);

    const toggleFavorite = async () => {
        if (!player) return;
        const docRef = doc(db, "favoritePlayers", player.id.toString());
        if (isFavorite) {
            await deleteDoc(docRef);
        } else {
            await setDoc(docRef, player);
        }
        setIsFavorite(!isFavorite);
    };


    if (!player) {
        return <Typography>Player data not available.</Typography>;
    }

    if (loading) {
        return (
            <Box sx={{ display: 'flex', justifyContent: 'center', p: 3 }}>
                <CircularProgress />
            </Box>
        );
    }

    const formatHeight = (inches: number | null) => {
        if (inches === null || inches === undefined) {
            return 'N/A';
        }
        const feet = Math.floor(inches / 12);
        const remainingInches = inches % 12;
        return `${feet}' ${remainingInches}"`;
    };

    return (
        <Box sx={{ pb: 4 }}>
            <Paper sx={{ p: 3, mt: 3 }}>
                <Typography variant="h4" component="h1" gutterBottom>
                    {player.name} - #{player.jersey}
                </Typography>
                <Button variant="contained" onClick={toggleFavorite}>
                    {isFavorite ? 'Remove from Favorites' : 'Add to Favorites'}
                </Button>
                <Typography variant="body1" gutterBottom>
                    Position: {player.position}
                </Typography>
                <Typography variant="body1" gutterBottom>
                    Height: {formatHeight(player.height)}
                </Typography>
                <Typography variant="body1" gutterBottom>
                    Weight: {player.weight ? `${player.weight} lbs` : 'N/A'}
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
                        <Box sx={{ my: 2 }}>
                            <GeminiAnalysis data={{ player, playerSeasonStats: stats, playerSeasonShootingStats: shootingStats }} />
                        </Box>
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