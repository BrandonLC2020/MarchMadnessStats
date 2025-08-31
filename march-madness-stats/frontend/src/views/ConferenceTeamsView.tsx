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
        <Box>
            <Typography variant="h4">{conference.name} Teams</Typography>
            {conference.teams.map((team) => (
                <ConferenceTeamCard key={team.id} team={team} />
            ))}
        </Box>
    );
};

export default ConferenceTeamsView;