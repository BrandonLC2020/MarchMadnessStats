import React from 'react';
import { Card, CardContent, Typography, Grid } from '@mui/material';
import { PlayerSeasonShootingStats } from '../types/api';

interface PlayerSeasonShootingStatsCardProps {
  stats: PlayerSeasonShootingStats;
}

const PlayerSeasonShootingStatsCard: React.FC<PlayerSeasonShootingStatsCardProps> = ({ stats }) => {
  if (!stats) {
    return null;
  }
  const shootingStats = stats;

  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h6" gutterBottom>{shootingStats.season} Shooting Stats</Typography>
        <Grid container spacing={2}>
          <Grid>
            <Typography variant="body2">Tracked Shots: {shootingStats.trackedShots}</Typography>
            <Typography variant="body2">Assisted Pct: {shootingStats.assistedPct}%</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Shot Types</Typography>
            <Typography variant="body2">Dunks: {shootingStats.dunks?.made ?? 0}/{shootingStats.dunks?.attempted ?? 0} ({shootingStats.dunks?.pct}%) - {shootingStats.dunks?.assistedPct}% Assisted</Typography>
            <Typography variant="body2">Layups: {shootingStats.layups?.made ?? 0}/{shootingStats.layups?.attempted ?? 0} ({shootingStats.layups?.pct}%) - {shootingStats.layups?.assistedPct}% Assisted</Typography>
            <Typography variant="body2">Tip Ins: {shootingStats.tipIns?.made ?? 0}/{shootingStats.tipIns?.attempted ?? 0} ({shootingStats.tipIns?.pct}%)</Typography>
            <Typography variant="body2">2-Point Jumpers: {shootingStats.twoPointJumpers?.made ?? 0}/{shootingStats.twoPointJumpers?.attempted ?? 0} ({shootingStats.twoPointJumpers?.pct}%) - {shootingStats.twoPointJumpers?.assistedPct}% Assisted</Typography>
            <Typography variant="body2">3-Point Jumpers: {shootingStats.threePointJumpers?.made ?? 0}/{shootingStats.threePointJumpers?.attempted ?? 0} ({shootingStats.threePointJumpers?.pct}%) - {shootingStats.threePointJumpers?.assistedPct}% Assisted</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Shot Distribution</Typography>
            <Typography variant="body2">Dunks: {shootingStats.attemptsBreakdown?.dunks ?? 0}%</Typography>
            <Typography variant="body2">Layups: {shootingStats.attemptsBreakdown?.layups ?? 0}%</Typography>
            <Typography variant="body2">Tip Ins: {shootingStats.attemptsBreakdown?.tipIns ?? 0}%</Typography>
            <Typography variant="body2">2-Point Jumpers: {shootingStats.attemptsBreakdown?.twoPointJumpers ?? 0}%</Typography>
            <Typography variant="body2">3-Point Jumpers: {shootingStats.attemptsBreakdown?.threePointJumpers ?? 0}%</Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default PlayerSeasonShootingStatsCard;