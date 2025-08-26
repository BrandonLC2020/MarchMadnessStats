import React, { useEffect, useState } from 'react';
import { Typography, Box, Grid, CircularProgress, Alert, TextField, MenuItem, Button } from '@mui/material';
import GameCard from '../components/GameCard';
import { useGames } from '../hooks/useGames';
import { GameInfo } from '../types/api';
import { CURRENT_SEASON, SEASON_SEARCH_OPTIONS } from '../types/currentData';

const GamesView: React.FC = () => {
    const [games, setGames] = useState<GameInfo[]>([]);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);
    const [season, setSeason] = useState<number>(CURRENT_SEASON);
    const { getGames } = useGames();

    const fetchGames = async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await getGames({ season });
            setGames(data);
        } catch (err: any) {
            setError(err.message || 'An unexpected error occurred');
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchGames();
    }, []); // Fetch games initially when component mounts

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Games
            </Typography>
            <Box sx={{ display: 'flex', alignItems: 'center', mb: 3, gap: 2 }}>
                <TextField
                    select
                    label="Season"
                    value={season}
                    onChange={(e) => setSeason(Number(e.target.value))}
                    size="small"
                >
                    {SEASON_SEARCH_OPTIONS.map((option) => (
                        <MenuItem key={option.value} value={option.value}>
                            {option.label}
                        </MenuItem>
                    ))}
                </TextField>
                <Button variant="contained" onClick={fetchGames} disabled={loading}>
                    Search Games
                </Button>
            </Box>

            {loading ? (                
                <Box sx={{ display: 'flex', justifyContent: 'center', p: 3 }}>
                    <CircularProgress />
                </Box>
            ) : error ? (
                <Alert severity="error" sx={{ m: 3 }}>{error}</Alert>
            ) : games.length > 0 ? (
                <Grid container spacing={2}>
                    {games.map((game: GameInfo) => (
                        <Grid key={game.id}>
                            <GameCard game={game} />
                        </Grid>
                    ))}
                </Grid>
            ) : (
                <Typography>No games found for the selected season.</Typography>
            )}
        </Box>
    );
};

export default GamesView;
