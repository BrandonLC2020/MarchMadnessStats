import React, { useEffect, useState } from 'react';
import { Typography, Box, Grid, CircularProgress, Alert } from '@mui/material';
import ConferenceCard from '../components/ConferenceCard';
import { useConferences } from '../hooks/useConferences';
import { ConferenceHistory } from '../types/api';

const ConferencesView: React.FC = () => {
    const [conferences, setConferences] = useState<ConferenceHistory[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
    const { getConferenceHistory } = useConferences();

    useEffect(() => {
        const fetchConferences = async () => {
            try {
                const data = await getConferenceHistory();
                setConferences(data);
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred');
            } finally {
                setLoading(false);
            }
        };
        fetchConferences();
    }, [getConferenceHistory]);

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

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Conferences
            </Typography>
            <Grid container spacing={2}>
                {conferences.map((conference: ConferenceHistory) => (
                    <Grid key={conference.id}>
                        <ConferenceCard conference={conference} />
                    </Grid>
                ))}
            </Grid>
        </Box>
    );
};

export default ConferencesView;