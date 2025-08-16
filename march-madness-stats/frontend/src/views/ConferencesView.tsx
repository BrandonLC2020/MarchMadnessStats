import React, { useEffect, useState } from 'react';
import { Typography, Box, Grid, CircularProgress, Alert } from '@mui/material';
import ConferenceCard from '../components/ConferenceCard'; // This line is not part of the diff, but it's in the original file.
import { useConferences } from '../hooks/useConferences';
import { Conference } from '../types/api';

const ConferencesView: React.FC = () => {
    const [conferences, setConferences] = useState<Conference[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
    const { getConferences } = useConferences();

    useEffect(() => {
        const fetchConferences = async () => {
            try {
                // setLoading(true); // Redundant, handled by initial state
                const data = await getConferences();
                setConferences(data);
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred');
            } finally {
                setLoading(false);
            }
        };

        fetchConferences();
    }, [getConferences]);

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
                {conferences.map((conference: Conference) => (
                    <Grid key={conference.id}>
                        <ConferenceCard conference={conference} />
                    </Grid>
                ))}
            </Grid>
        </Box>
    );
};

export default ConferencesView;