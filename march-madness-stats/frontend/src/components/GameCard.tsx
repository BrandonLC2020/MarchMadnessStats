// frontend/src/components/GameCard.tsx
import React from 'react';
import { Card, CardActionArea, CardContent, Typography, Box } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import { GameInfo, GameBoxScoreTeam, GameBoxScorePlayers } from '../types/api';

interface GameCardProps {
  game: GameInfo;
  boxScoreTeam?: GameBoxScoreTeam;
  boxScorePlayers?: GameBoxScorePlayers;
}

const GameCard: React.FC<GameCardProps> = ({ game, boxScoreTeam, boxScorePlayers }) => {
  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardActionArea component={RouterLink} to={`/game/${game.id}`} state={{ game, boxScoreTeam, boxScorePlayers }}>
        <CardContent>
          <Typography variant="h5" component="div">
            {game.awayTeam} vs. {game.homeTeam}
          </Typography>
          <Typography sx={{ mb: 1.5 }} color="text.secondary">
            {new Date(game.startDate).toLocaleDateString()}
          </Typography>
          <Box sx={{ display: 'flex', justifyContent: 'space-between', mt: 2 }}>
            <Typography variant="body1">
              <strong>{game.awayTeam}:</strong> {game.awayPoints}
            </Typography>
            <Typography variant="body1">
              <strong>{game.homeTeam}:</strong> {game.homePoints}
            </Typography>
          </Box>
        </CardContent>
      </CardActionArea>
    </Card>
  );
};

export default GameCard;