// frontend/src/views/ConferenceTeamsView.tsx
import { Box, CircularProgress, Typography } from '@mui/material';
import React, { useEffect, useState } from 'react';
import { useLocation, useParams } from 'react-router-dom';
import { ConferenceHistory } from '../types/api';
import ConferenceTeamCard from '../components/ConferenceTeamCard';
import { useConferences } from '../hooks/useConferences';

const ConferenceTeamsView: React.FC = () => {
    const location = useLocation();
    const { conferenceAbbreviation } = useParams<{ conferenceAbbreviation: string }>();
    const [conference, setConference] = useState<ConferenceHistory | null>(location.state?.conference);
    const [loading, setLoading] = useState<boolean>(!conference);
    const { getConferenceHistory } = useConferences();

    useEffect(() => {
        const fetchConference = async () => {
            if (conference && 'teams' in conference) return;

            setLoading(true);
            try {
                if (conferenceAbbreviation) {
                    const data = await getConferenceHistory(conferenceAbbreviation);
                    if (data && data.length > 0) {
                        setConference(data[0]);
                    }
                }
            } catch (error) {
                console.error("Failed to fetch conference data:", error);
            } finally {
                setLoading(false);
            }
        };

        fetchConference();
    }, [conferenceAbbreviation, getConferenceHistory, conference]);

    if (loading) {
        return <CircularProgress />;
    }

    if (!conference || !conference.teams) {
        return <Typography>Conference data not available.</Typography>;
    }

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                {conference.name} Teams
            </Typography>
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                {conference.teams.map((team) => (
                    <Box key={team.id} sx={{ width: { xs: '100%', sm: 'calc(50% - 8px)', md: 'calc(33.333% - 11px)' } }}>
                        <ConferenceTeamCard team={team} />
                    </Box>
                ))}
            </Box>
        </Box>
    );
};

export default ConferenceTeamsView;