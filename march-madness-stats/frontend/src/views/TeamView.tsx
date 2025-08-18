import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert, Paper, TableContainer, Table, TableBody, TableCell, TableHead, TableRow, Grid, TextField, MenuItem, Link } from '@mui/material';
import { Link as RouterLink, useLocation, useParams } from 'react-router-dom';
import { useTeams } from '../hooks/useTeams';
import { TeamInfo, TeamRoster } from '../types/api';
import { CURRENT_SEASON, SEASON_SEARCH_OPTIONS } from '../types/currentData';

const TeamView: React.FC = () => {
    const location = useLocation();
    const { teamId } = useParams<{ teamId: string }>();
    const [teamData, setTeamData] = useState<TeamInfo | null>(location.state?.team);
    const [teamRosterData, setTeamRosterData] = useState<TeamRoster | null>(null);
    const [loading, setLoading] = useState<boolean>(!teamData);
    const [error, setError] = useState<string | null>(null);
    const { getTeams, getTeamRoster } = useTeams();
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

        fetchTeamData();
        fetchTeamRosterData();
    }, [teamId, getTeams, getTeamRoster, season, teamData]);

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
            </Paper>
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
                                    <Link component={RouterLink} to={`/player/${player.id}`} state={{ player }}>
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