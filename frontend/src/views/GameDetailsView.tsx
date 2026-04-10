// frontend/src/views/GameDetailsView.tsx
import React from 'react';
import { useLocation } from 'react-router-dom';
import { Typography, Box, Paper, TableContainer, Table, TableHead, TableRow, TableCell, TableBody } from '@mui/material';
import { GameInfo, GameBoxScoreTeam, GameBoxScorePlayers } from '../types/api';

const GameDetailsView: React.FC = () => {
    const location = useLocation();
    const { game, boxScoreTeam, boxScorePlayers } = location.state as {
        game: GameInfo;
        boxScoreTeam: GameBoxScoreTeam;
        boxScorePlayers: GameBoxScorePlayers;
    };

    if (!game) {
        return <Typography>Game data not available.</Typography>;
    }

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Game Details
            </Typography>
            <Paper sx={{ p: 3, mb: 3 }}>
                <Typography variant="h5" component="h2" gutterBottom>
                    {game.awayTeam} vs. {game.homeTeam}
                </Typography>
                <Typography variant="body1">
                    Date: {new Date(game.startDate).toLocaleDateString()}
                </Typography>
                <Typography variant="body1">
                    Venue: {game.venue}
                </Typography>
                <Typography variant="body1">
                    Score: {game.awayPoints} - {game.homePoints}
                </Typography>
            </Paper>

            {boxScoreTeam && (
                <Paper sx={{ p: 3, mb: 3 }}>
                    <Typography variant="h5" component="h2" gutterBottom>
                        Team Box Score
                    </Typography>
                    <TableContainer>
                        <Table size="small">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Team</TableCell>
                                    <TableCell align="right">Points</TableCell>
                                    <TableCell align="right">Assists</TableCell>
                                    <TableCell align="right">Rebounds</TableCell>
                                    <TableCell align="right">Turnovers</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                <TableRow>
                                    <TableCell>{boxScoreTeam.team}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.teamStats.points.total}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.teamStats.assists}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.teamStats.rebounds.total}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.teamStats.turnovers.total}</TableCell>
                                </TableRow>
                                <TableRow>
                                    <TableCell>{boxScoreTeam.opponent}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.opponentStats.points.total}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.opponentStats.assists}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.opponentStats.rebounds.total}</TableCell>
                                    <TableCell align="right">{boxScoreTeam.opponentStats.turnovers.total}</TableCell>
                                </TableRow>
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Paper>
            )}

            {boxScorePlayers && (
                <Paper sx={{ p: 3 }}>
                    <Typography variant="h5" component="h2" gutterBottom>
                        Player Box Score
                    </Typography>
                    <TableContainer>
                        <Table size="small">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Player</TableCell>
                                    <TableCell align="right">Points</TableCell>
                                    <TableCell align="right">Rebounds</TableCell>
                                    <TableCell align="right">Assists</TableCell>
                                    <TableCell align="right">Steals</TableCell>
                                    <TableCell align="right">Blocks</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {boxScorePlayers.players.map((player) => (
                                <TableRow key={player.athleteId}>
                                    <TableCell>{player.name}</TableCell>
                                    <TableCell align="right">{player.points}</TableCell>
                                    <TableCell align="right">{player.rebounds.total}</TableCell>
                                    <TableCell align="right">{player.assists}</TableCell>
                                    <TableCell align="right">{player.steals}</TableCell>
                                    <TableCell align="right">{player.blocks}</TableCell>
                                </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Paper>
            )}
        </Box>
    );
};

export default GameDetailsView;