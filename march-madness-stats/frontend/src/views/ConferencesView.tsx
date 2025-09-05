// frontend/src/views/ConferencesView.tsx
import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert } from '@mui/material';
import ConferenceCard from '../components/ConferenceCard';
import { useConferences } from '../hooks/useConferences';
import { ConferenceInfo } from '../types/api';

const ConferencesView: React.FC = () => {
    const [conferences, setConferences] = useState<ConferenceInfo[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
    const { getConferences } = useConferences();

    useEffect(() => {
        const fetchConferences = async () => {
            try {
                const data = await getConferences();
                setConferences(data);
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred');
            } finally {
                setLoading(false);
            }
        };
        fetchConferences();
    }, []);

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
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                {conferences.map((conference: ConferenceInfo) => (
                    <Box key={conference.id} sx={{ width: { xs: '100%', sm: 'calc(50% - 8px)', md: 'calc(33.333% - 11px)' } }}>
                        <ConferenceCard conference={conference} />
                    </Box>
                ))}
            </Box>
        </Box>
    );
};

export default ConferencesView;