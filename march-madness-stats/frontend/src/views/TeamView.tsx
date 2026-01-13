// frontend/src/views/TeamView.tsx
import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert, TableContainer, Table, TableBody, TableCell, TableHead, TableRow, TextField, MenuItem, Link, Chip, Button, useTheme } from '@mui/material';
import { Link as RouterLink, useLocation, useParams } from 'react-router-dom';
import { useTeams } from '../hooks/useTeams';
import { useStats } from '../hooks/useStats';
import { SeasonShootingStats, TeamInfo, TeamRoster, PlayerSeasonStats, PlayerSeasonShootingStats } from '../types/api';
import { TeamSeasonStats } from '../types/api';
import { CURRENT_SEASON, SEASON_SEARCH_OPTIONS } from '../types/currentData';
import TeamSeasonStatsCard from '../components/TeamSeasonStatsCard';
import TeamSeasonShootingStatsCard from '../components/TeamSeasonShootingStatsCard';
import ShootingPieChart from '../components/ShootingPieChart';
import ReboundsPieChart from '../components/ReboundsPieChart';
import ShotDistributionPieChart from '../components/ShotDistributionPieChart';
import ShotTypeBarChart from '../components/ShotTypeBarChart';
import GeminiAnalysis from '../components/GeminiAnalysis';
import { doc, setDoc, getDoc, deleteDoc } from 'firebase/firestore';
import { db } from '../firebase';
import GlassCard from '../components/GlassCard';
import TeamLogo from '../components/TeamLogo';

const TeamView: React.FC = () => {
    const location = useLocation();
    const { teamId } = useParams<{ teamId: string }>();
    const [teamBasicData, setTeamBasicData] = useState<TeamInfo | null>(location.state?.team);
    const [teamData, setTeamData] = useState<TeamInfo | null>(null);
    const [teamRosterData, setTeamRosterData] = useState<TeamRoster | null>(null);
    const [loading, setLoading] = useState<boolean>(!teamData);
    const [error, setError] = useState<string | null>(null);
    const [teamSeasonStatsData, setTeamSeasonStatsData] = useState<TeamSeasonStats | null>(null);
    const [teamSeasonShootingStatsData, setTeamSeasonShootingStatsData] = useState<SeasonShootingStats | null>(null);
    const [playerSeasonStatsData, setPlayerSeasonStatsData] = useState<PlayerSeasonStats[]>([]);
    const [playerSeasonShootingStatsData, setPlayerSeasonShootingStatsData] = useState<PlayerSeasonShootingStats[]>([]);
    const { getTeams, getTeamRoster } = useTeams();
    const { getTeamSeasonStats, getTeamSeasonShootingStats, getPlayerSeasonStats, getPlayerSeasonShootingStats } = useStats();
    const [season, setSeason] = useState<number>(CURRENT_SEASON);
    const [isFavorite, setIsFavorite] = useState<boolean>(false);
    const theme = useTheme();

    useEffect(() => {
        const fetchTeamData = async () => {
            if (!teamId) {
                setError("Team ID not provided.");
                setLoading(false);
                return;
            }
            if (teamData) return; 

            try {
                const data = await getTeams({ season: season });
                const teamInfo = data.find(team => team.id === parseInt(teamId, 10));
                if (!teamInfo) {
                    setError("No team data found for the provided team ID.");
                } else {
                    setTeamData(teamInfo);
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching team data.');
            } finally {
                setLoading(false);
            }
        };

        const fetchTeamRosterData = async () => {
            if (!teamBasicData) return;

            try {
                const data = await getTeamRoster(season, teamBasicData.school);
                if (!data || data.length === 0) {
                    setError("No roster data found for the provided team.");
                } else {
                    setTeamRosterData(data[0]);
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching team roster data.');
            }
        };

        const fetchTeamSeasonStatsData = async () => {
            if (!teamBasicData) return;

            try {
                const data = await getTeamSeasonStats({ season, team: teamBasicData.school, conference: teamBasicData.conference ? teamBasicData.conference : undefined });
                if (!data) {
                    setError("No season stats found for the provided team.");
                } else {
                    setTeamSeasonStatsData(data[0]);
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching team season stats data.');
            }
        };

        const fetchTeamSeasonShootingStatsData = async () => {
            if (!teamBasicData) return;

            try {
                const data = await getTeamSeasonShootingStats({ season, team: teamBasicData.school, conference: teamBasicData.conference ? teamBasicData.conference : undefined });
                if (!data) {
                    setError("No season shooting stats found for the provided team.");
                } else {
                    setTeamSeasonShootingStatsData(data[0]);
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching team season shooting stats data.');
            }
        };

        const fetchPlayerSeasonStatsData = async () => {
            if (!teamBasicData) return;

            try {
                const data = await getPlayerSeasonStats({ season, team: teamBasicData.school });
                if (!data) {
                    setError("No player season stats found for the provided team.");
                } else {
                    setPlayerSeasonStatsData(data);
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching player season stats data.');
            }
        };

        const fetchPlayerSeasonShootingStatsData = async () => {
            if (!teamBasicData) return;

            try {
                const data = await getPlayerSeasonShootingStats({ season, team: teamBasicData.school });
                if (!data) {
                    setError("No player season shooting stats found for the provided team.");
                } else {
                    setPlayerSeasonShootingStatsData(data);
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching player season shooting stats data.');
            }
        };

        const checkIfFavorite = async () => {
            if (teamBasicData) {
                const docRef = doc(db, "favoriteTeams", teamBasicData.id.toString());
                const docSnap = await getDoc(docRef);
                setIsFavorite(docSnap.exists());
            }
        };
        checkIfFavorite();

        fetchTeamData();
        fetchTeamRosterData();
        fetchTeamSeasonStatsData();
        fetchTeamSeasonShootingStatsData();
        fetchPlayerSeasonStatsData();
        fetchPlayerSeasonShootingStatsData();
    }, [season]);

    useEffect(() => {
        const checkIfFavorite = async () => {
            if (teamData) {
                const docRef = doc(db, "favoriteTeams", teamData.id.toString());
                const docSnap = await getDoc(docRef);
                setIsFavorite(docSnap.exists());
            }
        };
        checkIfFavorite();
    }, [teamData]);

    const toggleFavorite = async () => {
        if (!teamData) return;
        const docRef = doc(db, "favoriteTeams", teamData.id.toString());
        if (isFavorite) {
            await deleteDoc(docRef);
        } else {
            await setDoc(docRef, teamData);
        }
        setIsFavorite(!isFavorite);
    };



    if (loading) {
        return (
            <Box sx={{ display: 'flex', justifyContent: 'center', p: 3 }}>
                <CircularProgress />
            </Box>
        );
    }

    if (error) {
        return <Alert severity="error" sx={{ m: 3 }}>{error}</Alert>;
    }

    if (!teamData) {
        return <Typography>Team data not available.</Typography>;
    }

    const locationString = [teamData.currentCity, teamData.currentState].filter(Boolean).join(', ');
    const normalizeColor = (color: string | null | undefined) => {
        if (!color) return null;
        return color.startsWith('#') ? color : `#${color}`;
    };
    const brandColor = normalizeColor(teamData.primaryColor) ?? theme.palette.primary.main;

    const formatHeight = (inches: number | null) => {
        if (inches === null || inches === undefined) {
            return 'N/A';
        }
        const feet = Math.floor(inches / 12);
        const remainingInches = inches % 12;
        return `${feet}' ${remainingInches}"`;
    };

    const chipStyles = {
        height: 'auto',
        padding: '8px 12px',
        fontSize: '1rem',
        fontWeight: 'bold'
    };

    return (
        <Box sx={{ pb: 4, position: 'relative' }}>
            <Box
                sx={{
                    position: 'fixed',
                    top: '20%',
                    left: '50%',
                    transform: 'translate(-50%, -50%)',
                    width: '600px',
                    height: '600px',
                    background: brandColor,
                    filter: 'blur(150px)',
                    opacity: 0.15,
                    zIndex: -1,
                    pointerEvents: 'none',
                }}
            />
            <GlassCard sx={{ mt: 3, mb: 4 }} teamColor={brandColor}>
                <Box sx={{ display: 'flex', alignItems: 'center', gap: 3, flexWrap: 'wrap' }}>
                    <Box sx={{ p: 1, background: 'rgba(255,255,255,0.1)', borderRadius: '50%' }}>
                        <TeamLogo school={teamData.school} size={100} />
                    </Box>
                    <Box sx={{ flexGrow: 1 }}>
                        <Typography
                            variant="h3"
                            component="h1"
                            fontWeight="800"
                            sx={{
                                background: `linear-gradient(45deg, ${brandColor}, ${theme.palette.text.primary})`,
                                backgroundClip: 'text',
                                color: 'transparent',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                            }}
                        >
                            {teamData.school}
                        </Typography>
                        <Typography variant="h5" color="text.secondary" fontWeight="500">
                            {teamData.mascot}
                        </Typography>
                    </Box>
                    <Button
                        variant="contained"
                        onClick={toggleFavorite}
                        sx={{
                            borderRadius: '20px',
                            bgcolor: brandColor,
                            '&:hover': { bgcolor: brandColor, filter: 'brightness(0.9)' },
                        }}
                    >
                        {isFavorite ? '♥ Favorited' : '♡ Add to Favorites'}
                    </Button>
                </Box>
                <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2, alignItems: 'flex-start', mt: 3 }}>
                    <Box sx={{ width: { xs: '100%', md: 'calc(33.333% - 11px)' }, display: 'flex', flexDirection: 'column', gap: 1 }}>
                        <Typography variant="h6" component="h2">
                            Conference: {teamData.conference ?? 'N/A'}
                        </Typography>
                        <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                            <Typography variant="body1">Season:</Typography>
                            <TextField
                                select
                                value={season}
                                onChange={(e) => setSeason(Number(e.target.value))}
                                size="small"
                                sx={{ maxWidth: '150px' }}
                            >
                                {SEASON_SEARCH_OPTIONS.map((option) => (
                                    <MenuItem key={option.value} value={option.value}>
                                        {option.label}
                                    </MenuItem>
                                ))}
                            </TextField>
                        </Box>
                    </Box>
                    <Box sx={{ width: { xs: '100%', md: 'calc(33.333% - 11px)' }, display: 'flex', flexDirection: 'column', gap: 1 }}>
                        <Typography variant="body1">
                            <strong>Venue:</strong> {teamData.currentVenue ?? 'N/A'}
                        </Typography>
                        <Typography variant="body1">
                            <strong>Location:</strong> {locationString || 'N/A'}
                        </Typography>
                    </Box>
                    <Box sx={{ width: { xs: '100%', md: 'calc(33.333% - 11px)' } }}>
                        <Box sx={{ display: 'flex', gap: 1, flexWrap: 'wrap' }}>
                            <Chip label={`Wins: ${teamSeasonStatsData?.wins ?? 0}`} color="success" sx={chipStyles} />
                            <Chip label={`Losses: ${teamSeasonStatsData?.losses ?? 0}`} color="error" sx={chipStyles} />
                            <Chip label={`Games: ${teamSeasonStatsData?.games ?? 0}`} sx={chipStyles} />
                        </Box>
                    </Box>
                </Box>
                <Box sx={{ display: 'flex', gap: 2, mt: 3, flexWrap: 'wrap' }}>
                    <Chip label={`${teamData.conference ?? 'N/A'}`} variant="outlined" sx={{ borderColor: brandColor, fontWeight: 'bold' }} />
                    <Chip label={`Wins: ${teamSeasonStatsData?.wins ?? 0}`} color="success" />
                    <Chip label={`Losses: ${teamSeasonStatsData?.losses ?? 0}`} color="error" />
                </Box>
            </GlassCard>
            {teamSeasonStatsData && (
                <Box sx={{ display: 'grid', gridTemplateColumns: { xs: '1fr', md: '1fr 1fr' }, gap: 3 }}>
                    <Box sx={{ gridColumn: '1 / -1' }}>
                        <GlassCard delay={0.1}>
                            <GeminiAnalysis data={{ teamData, teamSeasonStatsData, teamSeasonShootingStatsData }} />
                        </GlassCard>
                    </Box>
                    <GlassCard delay={0.2}>
                        <Typography variant="h6" gutterBottom>
                            Team Shot Distribution
                        </Typography>
                        <ShootingPieChart shootingData={teamSeasonStatsData.teamStats} />
                    </GlassCard>
                    <GlassCard delay={0.3}>
                        <Typography variant="h6" gutterBottom>
                            Team Rebounds
                        </Typography>
                        <ReboundsPieChart reboundsData={teamSeasonStatsData.teamStats.rebounds} />
                    </GlassCard>
                    <GlassCard delay={0.4}>
                        <Typography variant="h6" gutterBottom>
                            Opponent Shot Distribution
                        </Typography>
                        <ShootingPieChart shootingData={teamSeasonStatsData.opponentStats} />
                    </GlassCard>
                    <GlassCard delay={0.5}>
                        <Typography variant="h6" gutterBottom>
                            Opponent Rebounds
                        </Typography>
                        <ReboundsPieChart reboundsData={teamSeasonStatsData.opponentStats.rebounds} />
                    </GlassCard>
                </Box>
            )}
            {teamSeasonStatsData && (
                <Box sx={{ display: 'grid', gridTemplateColumns: { xs: '1fr', md: '1fr 1fr' }, gap: 3, mt: 3 }}>
                    <GlassCard delay={0.2}>
                        <TeamSeasonStatsCard stats={teamSeasonStatsData.teamStats} team={teamData.school} />
                    </GlassCard>
                    <GlassCard delay={0.3}>
                        <TeamSeasonStatsCard stats={teamSeasonStatsData.opponentStats} team={'Opponent'} />
                    </GlassCard>
                </Box>
            )}
            {teamSeasonShootingStatsData && (
                <>
                    <GlassCard sx={{ mt: 3 }} delay={0.4}>
                        <TeamSeasonShootingStatsCard stats={teamSeasonShootingStatsData} team={teamData.school} />
                    </GlassCard>
                    <Box sx={{ display: 'grid', gridTemplateColumns: { xs: '1fr', md: '1fr 1fr' }, gap: 3, mt: 3 }}>
                        <GlassCard delay={0.5}>
                            <ShotTypeBarChart shootingData={teamSeasonShootingStatsData} />
                        </GlassCard>
                        <GlassCard delay={0.6}>
                            <ShotDistributionPieChart shootingData={teamSeasonShootingStatsData} />
                        </GlassCard>
                    </Box>
                </>
            )}
            <GlassCard sx={{ mt: 4 }} delay={0.4}>
                <Typography
                    variant="h5"
                    fontWeight="bold"
                    gutterBottom
                    sx={{ borderBottom: `2px solid ${brandColor}`, display: 'inline-block', pb: 1 }}
                >
                    Team Roster
                </Typography>
                <TableContainer sx={{ background: 'transparent' }}>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>Jersey</TableCell>
                                <TableCell>Player</TableCell>
                                <TableCell>Position</TableCell>
                                <TableCell>Height</TableCell>
                                <TableCell>Weight</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {teamRosterData?.players.map(player => (
                                <TableRow key={player.id}>
                                    <TableCell>{player.jersey}</TableCell>
                                    <TableCell>
                                        <Link component={RouterLink} to={`/player/${player.id}`} state={{ player, playerSeasonStatsData: playerSeasonStatsData.filter((data) => data.athleteId === player.id), playerSeasonShootingStatsData: playerSeasonShootingStatsData.filter((data) => data.athleteId === player.id) }}>
                                            {player.name}
                                        </Link>
                                    </TableCell>
                                    <TableCell>{player.position}</TableCell>
                                    <TableCell>{formatHeight(player.height)}</TableCell>
                                    <TableCell>{player.weight ? `${player.weight} lbs` : 'N/A'}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </GlassCard>
        </Box>
    );
};

export default TeamView;
