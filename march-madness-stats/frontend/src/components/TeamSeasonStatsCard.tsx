import React from 'react';
import { Card, CardContent, Typography, Grid } from '@mui/material';
import { TeamSeasonUnitStats } from '../types/api';

interface TeamSeasonStatsCardProps {
  stats: TeamSeasonUnitStats;
}

const TeamSeasonStatsCard: React.FC<TeamSeasonStatsCardProps> = ({ stats }) => {
  if (!stats) {
    return null;
  }
  const teamStats = stats;

  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h6" gutterBottom>Season Stats</Typography>
        <Grid container spacing={2}>
          <Grid>
            <Typography variant="subtitle1">Offense</Typography>
            <Typography variant="body2">Points: {teamStats.points.total ?? 'N/A'}</Typography>
            <Typography variant="body2">Assists: {teamStats.assists ?? 'N/A'}</Typography>
            <Typography variant="body2">FG%: {teamStats.fieldGoals.pct ? `${teamStats.fieldGoals.pct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">3P%: {teamStats.threePointFieldGoals.pct ? `${teamStats.threePointFieldGoals.pct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">FT%: {teamStats.freeThrows.pct ? `${teamStats.freeThrows.pct.toFixed(1)}%` : 'N/A'}</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Team</Typography>
            <Typography variant="body2">Rebounds: {teamStats.rebounds.total ?? 'N/A'}</Typography>
            <Typography variant="body2">Steals: {teamStats.steals ?? 'N/A'}</Typography>
            <Typography variant="body2">Blocks: {teamStats.blocks ?? 'N/A'}</Typography>
            <Typography variant="body2">Turnovers: {teamStats.turnovers.total ?? 'N/A'}</Typography>
            <Typography variant="body2">Fouls: {teamStats.fouls.total ?? 'N/A'}</Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default TeamSeasonStatsCard;
