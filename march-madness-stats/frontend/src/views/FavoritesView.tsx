// frontend/src/views/FavoritesView.tsx
import React, { useEffect, useState } from 'react';
import { Typography, Box, CircularProgress, Alert } from '@mui/material';
import { collection, getDocs } from 'firebase/firestore';
import { db } from '../firebase';
import { TeamInfo, TeamRosterPlayer } from '../types/api';
import ConferenceTeamCard from '../components/ConferenceTeamCard';
import PlayerCard from '../components/PlayerCard';

const FavoritesView: React.FC = () => {
    const [favoriteTeams, setFavoriteTeams] = useState<TeamInfo[]>([]);
    const [favoritePlayers, setFavoritePlayers] = useState<TeamRosterPlayer[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchFavorites = async () => {
            try {
                const teamsCollection = collection(db, 'favoriteTeams');
                const teamsSnapshot = await getDocs(teamsCollection);
                const teamsList = teamsSnapshot.docs.map(doc => doc.data() as TeamInfo);
                setFavoriteTeams(teamsList);

                const playersCollection = collection(db, 'favoritePlayers');
                const playersSnapshot = await getDocs(playersCollection);
                const playersList = playersSnapshot.docs.map(doc => doc.data() as TeamRosterPlayer);
                setFavoritePlayers(playersList);

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
                Favorites
            </Typography>

            <Typography variant="h5" component="h2" gutterBottom>
                Favorite Teams
            </Typography>
            {favoriteTeams.length > 0 ? (
                <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                    {favoriteTeams.map((team: any) => (
                        <Box key={team.id} sx={{ width: { xs: '100%', sm: 'calc(50% - 8px)', md: 'calc(33.333% - 11px)' } }}>
                            <ConferenceTeamCard team={team} />
                        </Box>
                    ))}
                </Box>
            ) : (
                <Typography>You have no favorite teams yet.</Typography>
            )}

            <Typography variant="h5" component="h2" gutterBottom sx={{ mt: 4 }}>
                Favorite Players
            </Typography>
            {favoritePlayers.length > 0 ? (
                <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 2 }}>
                    {favoritePlayers.map((player: any) => (
                        <Box key={player.id} sx={{ width: { xs: '100%', sm: 'calc(50% - 8px)', md: 'calc(33.333% - 11px)' } }}>
                            <PlayerCard player={player} />
                        </Box>
                    ))}
                </Box>
            ) : (
                <Typography>You have no favorite players yet.</Typography>
            )}
        </Box>
    );
};

export default FavoritesView;