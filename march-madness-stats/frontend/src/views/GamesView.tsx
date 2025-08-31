// frontend/src/views/GamesView.tsx
import React, { useEffect, useState } from 'react';
import { Typography, Box, Grid, CircularProgress, Alert, TextField, Button, MenuItem, ToggleButtonGroup, ToggleButton } from '@mui/material';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import GameCard from '../components/GameCard';
import { useGames } from '../hooks/useGames';
import { GameBoxScorePlayers, GameBoxScoreTeam, GameInfo, SeasonType } from '../types/api';
import dayjs from 'dayjs';

const GamesView: React.FC = () => {
    const [games, setGames] = useState<GameInfo[]>([]);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);
    const [searchDateType, setSearchDateType] = useState<'single' | 'range'>('single');
    const [gameDate, setGameDate] = useState<string | null>(dayjs().toISOString());
    const [gameDateBound, setGameDateBound] = useState<string | null>(dayjs().add(1, 'day').toISOString());
    const [gameStartDate, setGameStartDate] = useState<string | null>(dayjs().toISOString());
    const [gameEndDate, setGameEndDate] = useState<string | null>(dayjs().add(1, 'day').toISOString());
    const [seasonType, setSeasonType] = useState<SeasonType>('regular');
    const [gamePlayers, setGamePlayers] = useState<GameBoxScorePlayers[]>([]);
    const [gameTeams, setGameTeams] = useState<GameBoxScoreTeam[]>([]);
    const { getGames, getGamePlayers, getGameTeams } = useGames();

    const fetchGames = async () => {
        setLoading(true);
        setError(null);
        try {
            const params = searchDateType === 'range'
                ? { startDateRange: gameStartDate || undefined, endDateRange: gameEndDate || undefined, seasonType }
                : { startDateRange: gameDate || undefined, endDateRange: gameDateBound || undefined, seasonType };

            const [gamesData, teamsData, playersData] = await Promise.all([
                getGames(params),
                getGameTeams(params),
                getGamePlayers(params)
            ]);

            setGames(gamesData);
            setGameTeams(teamsData);
            setGamePlayers(playersData);

        } catch (err: any) {
            setError(err.message || 'An unexpected error occurred');
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchGames();
    }, []);

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
                            value={gameStartDate ? dayjs(gameStartDate) : null}
                            onChange={(newValue) => setGameStartDate(newValue ? newValue.toISOString() : null)}
                            slotProps={{ textField: { variant: 'outlined' } }}
                        />
                        <DatePicker
                            label="End Date"
                            value={gameEndDate ? dayjs(gameEndDate) : null}
                            onChange={(newValue) => setGameEndDate(newValue ? newValue.add(1, 'day').toISOString() : null)}
                            slotProps={{ textField: { variant: 'outlined' } }}
                        />
                    </>
                ) : (
                    <DatePicker
                        label="Game Date"
                        value={gameDate ? dayjs(gameDate) : null}
                        onChange={(newValue) => {
                            setGameDate(newValue ? newValue.toISOString() : null);
                            setGameDateBound(newValue ? newValue.add(1, 'day').toISOString() : null);
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
                    {games.map((game: GameInfo) => {
                        const boxScoreTeam = gameTeams.find(team => team.gameId === game.id);
                        const boxScorePlayers = gamePlayers.find(players => players.gameId === game.id);
                        return (
                            <Grid key={game.id}>
                                <GameCard
                                    game={game}
                                    boxScoreTeam={boxScoreTeam}
                                    boxScorePlayers={boxScorePlayers}
                                />
                            </Grid>
                        );
                    })}
                </Grid>
            ) : (
                <Typography>No games found.</Typography>
            )}
        </Box>
    );
};

export default GamesView;