import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert, Paper, TableContainer, Table, TableBody, TableCell, TableHead, TableRow, Grid, TextField, MenuItem } from '@mui/material';
import { useTeams } from '../hooks/useTeams';
import { TeamInfo } from '../types/api';
import { CURRENT_SEASON } from '../types/current';

interface TeamViewProps {
    teamId: number;
    teamName: string;
    conferenceName: string;
}

const seasonSearchOptions = [
    { value: 2025, label: '2024-25' },
    { value: 2024, label: '2023-24' },
    { value: 2023, label: '2022-23' },
    { value: 2022, label: '2021-22' },
    { value: 2021, label: '2020-21' },
    { value: 2020, label: '2019-20' },
    { value: 2019, label: '2018-19' },
    { value: 2018, label: '2017-18' },
    { value: 2017, label: '2016-17' },
    { value: 2016, label: '2015-16' },
    { value: 2015, label: '2014-15' },
    { value: 2014, label: '2013-14' },
    { value: 2013, label: '2012-13' },
    { value: 2012, label: '2011-12' },
    { value: 2011, label: '2010-11' },
    { value: 2010, label: '2009-10' },
    { value: 2009, label: '2008-09' },
    { value: 2008, label: '2007-08' },
    { value: 2007, label: '2006-07' },
    { value: 2006, label: '2005-06' },
    { value: 2005, label: '2004-05' },
    { value: 2004, label: '2003-04' },
    { value: 2003, label: '2002-03' }
];

const TeamView: React.FC<TeamViewProps> = ({ teamId, teamName, conferenceName }) => {
    const [teamData, setTeamData] = useState<TeamInfo | null>(null);
    const [teamRosterData, setTeamRosterData] = useState<any[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
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
            try { 
                const data = await getTeams({ season: season, conference: conferenceName });
                if (data.length === 0) {
                    setError("No team data found for the provided team ID.");
                    setLoading(false);
                    return;
                } else {
                    setTeamData(data.filter(team => team.id === teamId)[0]); // should only be one match
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching team data.');
            } finally {
                setLoading(false);
            }
        };
        const fetchTeamRosterData = async () => {
            if (!teamId) {
                setError("Team ID not provided.");
                setLoading(false);
                return;
            }

            try {
                const data = await getTeamRoster(season, teamName);
                if (!data) {
                    setError("No roster data found for the provided team ID.");
                    setLoading(false);
                    return;
                } else {
                    setTeamRosterData(data);
                }
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred while fetching team roster data.');
            } finally {
                setLoading(false);
            }
        };
        fetchTeamData();
        fetchTeamRosterData();
    }, [teamId, getTeams, getTeamRoster, season]);

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
            <Paper sx={{ p: 3 }}>
                <Typography variant="h4" component="h1" gutterBottom>
                    {teamData.school} {teamData.mascot}
                </Typography>
                <Grid container spacing={2} direction={'row'}>
                    <Grid container spacing={2} direction={'column'}>
                        <Typography variant="h6" component="h2" gutterBottom>
                            Conference: {teamData.conference}
                        </Typography>
                        <Grid direction={'row'}>
                            <Typography variant="body1" gutterBottom>
                                Season:
                            </Typography>
                            <TextField
                                select
                                value={season}
                                defaultValue={season}
                                onChange={(e) => setSeason(Number(e.target.value))}
                            >
                                {seasonSearchOptions.map((option) => (
                                    <MenuItem key={option.value} value={option.value}>
                                        {option.label}
                                    </MenuItem>
                                ))}
                            </TextField>
                        </Grid>
                    </Grid>
                    <Grid container spacing={2} direction={'column'}>
                        <Typography variant="body1" gutterBottom>
                            Team Venue: {teamData.currentVenue}
                        </Typography>
                        <Typography variant="body1">
                            Team Location: {teamData.currentCity}, {teamData.currentState}
                        </Typography>
                    </Grid>
                </Grid>
            </Paper>
            <TableContainer component={Paper}>
                <Typography variant="h6" component="h2" gutterBottom>
                    Team Roster
                </Typography>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>Jersey Number</TableCell>
                            <TableCell>Player</TableCell>
                            <TableCell>Position</TableCell>
                            <TableCell>Height</TableCell>
                            <TableCell>Weight</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {teamRosterData.map(player => (
                            <TableRow key={player.id}>
                                <TableCell>{player.jersey}</TableCell>
                                <TableCell>{player.name}</TableCell>
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