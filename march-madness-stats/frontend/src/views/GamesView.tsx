import React, { useEffect, useState } from 'react';
import { Typography, Box, Grid, CircularProgress, Alert, TextField, Button, MenuItem, ToggleButtonGroup, ToggleButton } from '@mui/material';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import GameCard from '../components/GameCard';
import { useGames } from '../hooks/useGames';
import { GameInfo, SeasonType } from '../types/api';

const GamesView: React.FC = () => {
    const [games, setGames] = useState<GameInfo[]>([]);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);
    const [searchDateType, setSearchDateType] = useState<'single' | 'range'>('single');
    const [gameDate, setGameDate] = useState<string | null>(new Date().toISOString().split('T')[0]);
    const [gameDateBound, setGameDateBound] = useState<string | null>(new Date(new Date().setDate(new Date().getDate() + 1)).toISOString().split('T')[0]);
    const [gameStartDate, setGameStartDate] = useState<string | null>(new Date().toISOString().split('T')[0]);
    const [gameEndDate, setGameEndDate] = useState<string | null>(new Date(new Date().setDate(new Date().getDate() + 1)).toISOString().split('T')[0]);
    const [seasonType, setSeasonType] = useState<SeasonType>('regular');
    const { getGames } = useGames();

    const fetchGames = async () => {
        setLoading(true);
        setError(null); // Clear previous errors
        try {
            if (searchDateType === 'range') {
                const data = await getGames({ startDateRange: gameStartDate || undefined, endDateRange: gameEndDate || undefined, seasonType});
                setGames(data);
            } else {
                const data = await getGames({ startDateRange: gameDate || undefined, endDateRange: gameDateBound ? gameDateBound : undefined, seasonType });
                setGames(data);
            }
        } catch (err: any) {
            setError(err.message || 'An unexpected error occurred');
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchGames(); // Initial fetch
    }, []); // Fetch games initially when component mounts

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Games
            </Typography>
            <Box sx={{ mb: 2 }}>
                <TextField
                    select
                    label="Season Type"
                    value={seasonType}
                    onChange={(e) => setSeasonType(e.target.value as SeasonType)}
                >
                    <MenuItem value='preseason'>Preseason</MenuItem>
                    <MenuItem value='regular'>Regular</MenuItem>
                    <MenuItem value="postseason">Postseason</MenuItem>
                </TextField>
                <ToggleButtonGroup exclusive value={searchDateType} onChange={(event, newValue) => setSearchDateType(newValue)}>
                    <ToggleButton value='single'>
                        <Typography variant="body2">Single Date</Typography>
                    </ToggleButton>
                    <ToggleButton value='range'>
                        <Typography variant="body2">Date Range</Typography>
                    </ToggleButton>
                </ToggleButtonGroup>

            </Box>
            <Box sx={{ display: 'flex', alignItems: 'center', mb: 3, gap: 2 }}>
                {searchDateType === 'range' ? (
                    <>
                        <DatePicker
                            label="Start Date"
                            value={gameStartDate ? new Date(gameStartDate) : null}
                            onChange={(newValue) => setGameStartDate(newValue ? newValue.toISOString().split('T')[0] : null)}
                            slotProps={{ textField: { variant: 'outlined' } }}
                        />
                        <DatePicker
                            label="End Date"
                            value={gameEndDate ? new Date(gameEndDate) : null}
                            onChange={(newValue) => setGameEndDate(newValue ? newValue.toISOString().split('T')[0] : null)}
                            slotProps={{ textField: { variant: 'outlined' } }}
                        />
                    </>
                ) : (
                    <DatePicker
                        label="Game Date" // The type of `value` prop in DatePicker is `TDate | null` where `TDate` is the generic type parameter.
                        value={gameDate ? new Date(gameDate) : null}
                        onChange={(newValue) => {
                            setGameDate(newValue ? newValue.toISOString().split('T')[0] : null);
                            setGameDateBound(newValue ? (newValue.setDate(newValue.getDate() + 1), newValue.toISOString().split('T')[0]) : null);
                        }}
                        slotProps={{ textField: { variant: 'outlined' } }}
                    />
                )}
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
                <Grid container spacing={2} justifyContent="center">
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
