import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert, Paper } from '@mui/material';
import { useTeams } from '../hooks/useTeams';
import { TeamInfo } from '../types/api';
import { CURRENT_SEASON } from '../types/mostRecent';

interface TeamViewProps {
    teamId: number;
    teamName: string;
    conferenceName: string;
}

const TeamView: React.FC<TeamViewProps> = ({ teamId, teamName, conferenceName }) => {
    const [teamData, setTeamData] = useState<TeamInfo | null>(null);
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
        fetchTeamData();
    }, [teamId, getTeams]);

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
        <Paper sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                {teamData.school} {teamData.mascot}
            </Typography>
            <Typography variant="h6" component="h2" gutterBottom>
                Conference: {teamData.conference}
            </Typography>
            <Typography variant="body1" gutterBottom>
                Team Venue: {teamData.currentVenue}
            </Typography>
            <Typography variant="body1">
                Team Location: {teamData.currentCity}, {teamData.currentState}
            </Typography>
        </Paper>
    );
};

export default TeamView;