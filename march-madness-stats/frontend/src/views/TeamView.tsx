// frontend/src/views/TeamView.tsx
import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert, Paper, TableContainer, Table, TableBody, TableCell, TableHead, TableRow, TextField, MenuItem, Link, Chip } from '@mui/material';
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

        fetchTeamData();
        fetchTeamRosterData();
        fetchTeamSeasonStatsData();
        fetchTeamSeasonShootingStatsData();
        fetchPlayerSeasonStatsData();
        fetchPlayerSeasonShootingStatsData();
    }, [season]);

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
        <Box sx={{ pb: 4 }}>
            <Paper sx={{ p: 3, mt: 3 }}>
                <Typography variant="h4" component="h1" gutterBottom>
                    {teamData.school} {teamData.mascot}
                </Typography>
                <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2, alignItems: 'flex-start' }}>
                    {/* Column 1: Conference & Season */}
                    <Box sx={{ width: { xs: '100%', md: 'calc(33.333% - 11px)' }, display: 'flex', flexDirection: 'column', gap: 1 }}>
                        <Typography variant="h6" component="h2">
                            Conference: {teamData.conference ?? 'N/A'}
                        </Typography>
                        <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                            <Typography variant="body1">
                                Season:
                            </Typography>
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

                    {/* Column 2: Venue & Location */}
                    <Box sx={{ width: { xs: '100%', md: 'calc(33.333% - 11px)' }, display: 'flex', flexDirection: 'column', gap: 1 }}>
                        <Typography variant="body1">
                            <strong>Venue:</strong> {teamData.currentVenue ?? 'N/A'}
                        </Typography>
                        <Typography variant="body1">
                            <strong>Location:</strong> {locationString || 'N/A'}
                        </Typography>
                    </Box>

                    {/* Column 3: Wins/Losses */}
                    <Box sx={{ width: { xs: '100%', md: 'calc(33.333% - 11px)' } }}>
                        <Box sx={{ display: 'flex', gap: 1, flexWrap: 'wrap' }}>
                            <Chip label={`Wins: ${teamSeasonStatsData?.wins ?? 0}`} color="success" sx={chipStyles} />
                            <Chip label={`Losses: ${teamSeasonStatsData?.losses ?? 0}`} color="error" sx={chipStyles} />
                            <Chip label={`Games: ${teamSeasonStatsData?.games ?? 0}`} sx={chipStyles} />
                        </Box>
                    </Box>
                </Box>
            </Paper>
            {teamSeasonStatsData && (
                <>
                    <Typography variant="h5" sx={{ mt: 3, mb: 1 }}>
                        {teamData.school}'s Stat Breakdown
                    </Typography>
                    <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                        <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                            <ShootingPieChart shootingData={teamSeasonStatsData.teamStats} />
                        </Box>
                        <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                            <ReboundsPieChart reboundsData={teamSeasonStatsData.teamStats.rebounds} />
                        </Box>
                    </Box>
                    
                    <Typography variant="h5" sx={{ mt: 3, mb: 1 }}>
                        Opponent's Stat Breakdown
                    </Typography>
                    <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                        <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                            <ShootingPieChart shootingData={teamSeasonStatsData.opponentStats} />
                        </Box>
                        <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                            <ReboundsPieChart reboundsData={teamSeasonStatsData.opponentStats.rebounds} />
                        </Box>
                    </Box>
                </>
            )}
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2, mt: 2 }}>
                <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                    {teamSeasonStatsData?.teamStats && <TeamSeasonStatsCard stats={teamSeasonStatsData.teamStats} team={teamData.school} />}
                </Box>
                <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                    {teamSeasonStatsData?.opponentStats && <TeamSeasonStatsCard stats={teamSeasonStatsData.opponentStats} team={'Opponent'} />}
                </Box>
            </Box>
            <Box sx={{ mt: 2 }}>
                {teamSeasonShootingStatsData && <TeamSeasonShootingStatsCard stats={teamSeasonShootingStatsData} team={teamData.school} />}
            </Box>
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2, mt: 2 }}>
                <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                    {teamSeasonShootingStatsData && <ShotTypeBarChart shootingData={teamSeasonShootingStatsData} />}
                </Box>
                <Box sx={{ width: { xs: '100%', md: 'calc(50% - 8px)' } }}>
                    {teamSeasonShootingStatsData && <ShotDistributionPieChart shootingData={teamSeasonShootingStatsData} />}
                </Box>
            </Box>
            <TableContainer component={Paper} sx={{ mt: 3 }}>
                <Typography variant="h6" component="h2" gutterBottom sx={{ p: 2 }}>
                    Team Roster
                </Typography>
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
        </Box>
    );
};

export default TeamView;