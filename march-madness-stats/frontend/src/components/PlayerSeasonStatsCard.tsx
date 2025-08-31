// frontend/src/components/PlayerSeasonStatsCard.tsx
import React from 'react';
import { Card, CardContent, Typography, Grid } from '@mui/material';
import { PlayerSeasonStats } from '../types/api';

interface PlayerSeasonStatsCardProps {
  stats: PlayerSeasonStats;
}

const PlayerSeasonStatsCard: React.FC<PlayerSeasonStatsCardProps> = ({ stats }) => {
  if (!stats) {
    return null;
  }
  const playerStats = stats;

  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h6" gutterBottom>{playerStats.seasonLabel} Season Stats</Typography>
        <Grid container spacing={2}>
          <Grid>
            <Typography variant="subtitle1">Overall</Typography>
            <Typography variant="body2">Games Played: {playerStats.games}</Typography>
            <Typography variant="body2">Games Started: {playerStats.starts}</Typography>
            <Typography variant="body2">Minutes: {playerStats.minutes}</Typography>
            <Typography variant="body2">Points: {playerStats.points}</Typography>
            <Typography variant="body2">Assists: {playerStats.assists}</Typography>
            <Typography variant="body2">Rebounds: {playerStats.rebounds?.total ? playerStats.rebounds.total : 0}</Typography>
            <Typography variant="body2">Steals: {playerStats.steals}</Typography>
            <Typography variant="body2">Blocks: {playerStats.blocks}</Typography>
            <Typography variant="body2">Turnovers: {playerStats.turnovers}</Typography>
            <Typography variant="body2">Fouls: {playerStats.fouls}</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Advanced</Typography>
            <Typography variant="body2">Usage: {playerStats.usage?.toFixed(1)}%</Typography>
            <Typography variant="body2">Offensive Rating: {playerStats.offensiveRating?.toFixed(1)}</Typography>
            <Typography variant="body2">Defensive Rating: {playerStats.defensiveRating?.toFixed(1)}</Typography>
            <Typography variant="body2">Net Rating: {playerStats.netRating?.toFixed(1)}</Typography>
            <Typography variant="body2">PORPAG: {playerStats.PORPAG?.toFixed(1)}</Typography>
            <Typography variant="body2">Effective FG%: {playerStats.effectiveFieldGoalPct?.toFixed(1)}%</Typography>
            <Typography variant="body2">True Shooting %: {playerStats.trueShootingPct?.toFixed(1)}%</Typography>
            <Typography variant="body2">Assist/Turnover Ratio: {playerStats.assistsTurnoverRatio?.toFixed(1)}</Typography>
            <Typography variant="body2">Free Throw Rate: {playerStats.freeThrowRate?.toFixed(1)}</Typography>
            <Typography variant="body2">Offensive Rebound %: {playerStats.offensiveReboundPct?.toFixed(1)}%</Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default PlayerSeasonStatsCard;