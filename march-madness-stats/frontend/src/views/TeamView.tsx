import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert, Paper, TableContainer, Table, TableBody, TableCell, TableHead, TableRow, Grid, TextField, MenuItem, Link, Card, CardContent } from '@mui/material';
import { Link as RouterLink, useLocation, useParams } from 'react-router-dom';
import { useTeams } from '../hooks/useTeams';
import { useStats } from '../hooks/useStats';
import { SeasonShootingStats, TeamInfo, TeamRoster, PlayerSeasonStats, PlayerSeasonShootingStats } from '../types/api';
import { TeamSeasonStats } from '../types/api';
import { CURRENT_SEASON, SEASON_SEARCH_OPTIONS } from '../types/currentData';
import TeamSeasonStatsCard from '../components/TeamSeasonStatsCard';
import TeamSeasonShootingStatsCard from '../components/TeamSeasonShootingStatsCard';
import ShootingPieChart from '../components/ShootingPieChart';

const TeamView: React.FC = () => {
    const location = useLocation();
    const { teamId } = useParams<{ teamId: string }>();
    const [teamData, setTeamData] = useState<TeamInfo | null>(location.state?.team);
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
            if (!teamData) return;

            try {
                const data = await getTeamRoster(season, teamData.school);
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
            if (!teamData) return;

            try {
                const data = await getTeamSeasonStats({ season, team: teamData.school, conference: teamData.conference ? teamData.conference : undefined });
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
            if (!teamData) return;

            try {
                const data = await getTeamSeasonShootingStats({ season, team: teamData.school, conference: teamData.conference ? teamData.conference : undefined });
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
            if (!teamData) return;

            try {
                const data = await getPlayerSeasonStats({ season, team: teamData.school });
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
            if (!teamData) return;

            try {
                const data = await getPlayerSeasonShootingStats({ season, team: teamData.school });
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

    return (
        <Box>
            <Paper sx={{ p: 3, mt: 3 }}>
                <Typography variant="h4" component="h1" gutterBottom>
                    {teamData.school} {teamData.mascot}
                </Typography>
                <Grid container spacing={2}>
                    <Grid>
                        <Typography variant="h6" component="h2" gutterBottom>
                            Conference: {teamData.conference}
                        </Typography>
                        <Grid container alignItems="center" spacing={1}>
                            <Grid>
                                <Typography variant="body1">
                                    Season:
                                </Typography>
                            </Grid>
                            <Grid>
                                <TextField
                                    select
                                    value={season}
                                    onChange={(e) => setSeason(Number(e.target.value))}
                                    size="small"
                                >
                                    {SEASON_SEARCH_OPTIONS.map((option) => (
                                        <MenuItem key={option.value} value={option.value}>
                                            {option.label}
                                        </MenuItem>
                                    ))}
                                </TextField>
                            </Grid>
                        </Grid>
                    </Grid>
                    <Grid>
                        <Typography variant="body1" gutterBottom>
                            Venue: {teamData.currentVenue}
                        </Typography>
                        <Typography variant="body1">
                            Location: {teamData.currentCity}, {teamData.currentState}
                        </Typography>
                    </Grid>
                </Grid>
                <Box>
                    <Card sx={{ minWidth: 275, mb: 2 }}>
                        <CardContent>
                            <Box sx={{ display: 'flex', flexDirection: 'column', gap: 1 }}>
                                <Typography variant="body1">
                                Wins: {teamSeasonStatsData?.wins ?? 0}
                                </Typography>
                                <Typography variant="body1">
                                Losses: {teamSeasonStatsData?.losses ?? 0}
                                </Typography>
                                <Typography variant="body1">
                                Games: {teamSeasonStatsData?.games ?? 0}
                                </Typography>
                            </Box>
                        </CardContent>
                    </Card>
                </Box>
            </Paper>
            {teamSeasonStatsData && (
                <>
                    <Typography variant="h6" sx={{ mt: 2 }}>
                        {teamData.school}'s Shooting Percentages
                    </Typography>
                    <ShootingPieChart shootingData={teamSeasonStatsData.teamStats} />
                    <Typography variant="h6" sx={{ mt: 2 }}>
                        Opponent's Shooting Percentages
                    </Typography>
                    <ShootingPieChart shootingData={teamSeasonStatsData.opponentStats} />
                </>
            )}
            <Grid container spacing={2} sx={{ mt: 2 }}>
                <Grid>
                    {teamSeasonStatsData?.teamStats && <TeamSeasonStatsCard stats={teamSeasonStatsData.teamStats} team={teamData.school} />}
                </Grid>
                <Grid>
                    {teamSeasonStatsData?.opponentStats && <TeamSeasonStatsCard stats={teamSeasonStatsData.opponentStats} team={'Opponent'} />}
                </Grid>
            </Grid>
            <Grid>
                {teamSeasonShootingStatsData && <TeamSeasonShootingStatsCard stats={teamSeasonShootingStatsData} team={teamData.school} />}
            </Grid>
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
                                <TableCell>{player.height}</TableCell>
                                <TableCell>{player.weight}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    );
};

export default TeamView;