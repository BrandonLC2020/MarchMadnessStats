import React, { useState } from 'react';
import { useParams } from 'react-router-dom';
import { Typography, Box, CircularProgress, Alert, Paper, TableContainer, Table, TableHead, TableRow, TableCell, TableBody } from '@mui/material';
import { GameInfo, GameBoxScoreTeam, GameBoxScorePlayers } from '../types/api';

interface GameDetailsProps {
    gameInfo: GameInfo | null;
    boxScoreTeam: GameBoxScoreTeam | null;
    boxScorePlayers: GameBoxScorePlayers | null;
}

const GameDetailsView: React.FC = () => {
    const { gameId } = useParams<{ gameId: string }>();
    const [gameInfo, setGameInfo] = useState<GameInfo | null>(null);
    const [gameBoxScoreTeam, setBoxScoreTeam] = useState<GameBoxScoreTeam | null>(null);
    const [gameBoxScorePlayers, setBoxScorePlayers] = useState<GameBoxScorePlayers | null>(null);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

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

    if (!gameInfo) {
        return <Typography>Game data not available.</Typography>;
    }

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Game Details
            </Typography>
            <Paper sx={{ p: 3, mb: 3 }}>
                <Typography variant="h5" component="h2" gutterBottom>
                    {gameInfo.awayTeam} vs. {gameInfo.homeTeam}
                </Typography>
                <Typography variant="body1">
                    Date: {gameInfo.startDate}
                </Typography>
                <Typography variant="body1">
                    Venue: {gameInfo.venue}
                </Typography>
                <Typography variant="body1">
                    Score: {gameInfo.awayPoints} - {gameInfo.homePoints}
                </Typography>
            </Paper>

            {gameBoxScoreTeam && (
                <Paper sx={{ p: 3 }}>
                    <Typography variant="h5" component="h2" gutterBottom>
                        Box Score
                    </Typography>
                    <TableContainer>
                        <Table size="small">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Team</TableCell>
                                    <TableCell align="right">1H</TableCell>
                                    <TableCell align="right">2H</TableCell>
                                    <TableCell align="right">Final</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                <TableRow>
                                    <TableCell>{gameBoxScoreTeam.opponent}</TableCell> 
                                    <TableCell align="right">{gameBoxScoreTeam.opponentStats.points.byPeriod?.[0]}</TableCell>
                                    <TableCell align="right">{gameBoxScoreTeam.opponentStats.points.byPeriod?.[1]}</TableCell>
                                    <TableCell align="right">{gameBoxScoreTeam.opponentStats.points.total}</TableCell>
                                </TableRow>
                                <TableRow>
                                    <TableCell>{gameBoxScoreTeam.team}</TableCell>
                                    <TableCell align="right">{gameBoxScoreTeam.teamStats.points.byPeriod?.[0]}</TableCell>
                                    <TableCell align="right">{gameBoxScoreTeam.teamStats.points.byPeriod?.[1]}</TableCell>
                                    <TableCell align="right">{gameBoxScoreTeam.teamStats.points.total}</TableCell>
                                </TableRow>
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Paper>
            )}
        </Box>
    );
};

export default GameDetailsView;