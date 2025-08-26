import React from 'react';
import { Card, CardContent, Typography, Box } from '@mui/material';
import { GameInfo } from '../types/api';

interface GameCardProps {
  game: GameInfo;
}

const GameCard: React.FC<GameCardProps> = ({ game }) => {
  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h5" component="div">
          {game.awayTeam} vs. {game.homeTeam}
        </Typography>
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
          {game.startDate}
        </Typography>
        <Box sx={{ display: 'flex', justifyContent: 'space-between', mt: 2 }}>
          <Typography variant="body1">
            <strong>{game.awayTeam}:</strong> {game.awayPoints}
          </Typography>
          <Typography variant="body1">
            <strong>{game.homeTeam}:</strong> {game.homePoints}
          </Typography>
        </Box>
        <Typography variant="body2" sx={{ mt: 1 }}>
          Venue: {game.venue}
        </Typography>
      </CardContent>
    </Card>
  );
};

export default GameCard;