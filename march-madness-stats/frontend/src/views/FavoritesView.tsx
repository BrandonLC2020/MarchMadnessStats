// frontend/src/views/FavoritesView.tsx
import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert } from '@mui/material';
import { collection, getDocs } from 'firebase/firestore';
import { db } from '../firebase';
import { TeamInfo } from '../types/api';
import ConferenceTeamCard from '../components/ConferenceTeamCard';

const FavoritesView: React.FC = () => {
    const [favorites, setFavorites] = useState<TeamInfo[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchFavorites = async () => {
            try {
                const favoritesCollection = collection(db, 'favoriteTeams');
                const favoritesSnapshot = await getDocs(favoritesCollection);
                const favoritesList = favoritesSnapshot.docs.map(doc => doc.data() as TeamInfo);
                setFavorites(favoritesList);
            } catch (err: any) {
                setError(err.message || 'An unexpected error occurred');
            } finally {
                setLoading(false);
            }
        };
        fetchFavorites();
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
                Favorite Teams
            </Typography>
            {favorites.length > 0 ? (
                <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                    {favorites.map((team: any) => (
                        <Box key={team.id} sx={{ width: { xs: '100%', sm: 'calc(50% - 8px)', md: 'calc(33.333% - 11px)' } }}>
                            <ConferenceTeamCard team={team} />
                        </Box>
                    ))}
                </Box>
            ) : (
                <Typography>You have no favorite teams yet.</Typography>
            )}
        </Box>
    );
};

export default FavoritesView;