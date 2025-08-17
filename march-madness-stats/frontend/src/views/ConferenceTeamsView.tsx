import { Box, Typography } from '@mui/material';
import React from 'react';
import { useLocation } from 'react-router-dom';
import { ConferenceHistory } from '../types/api';
import ConferenceTeamCard from '../components/ConferenceTeamCard';

const ConferenceTeamsView: React.FC = () => {
    const location = useLocation();
    const conference = location.state?.conference as ConferenceHistory;

    if (!conference) {
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