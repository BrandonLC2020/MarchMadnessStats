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
            <Typography variant="body2">Dunks: {shootingStats.dunks.made}/{shootingStats.dunks.attempted} ({shootingStats.dunks.pct}%) - {shootingStats.dunks.assistedPct}% Assisted</Typography>
            <Typography variant="body2">Layups: {shootingStats.layups.made}/{shootingStats.layups.attempted} ({shootingStats.layups.pct}%) - {shootingStats.layups.assistedPct}% Assisted</Typography>
            <Typography variant="body2">Tip Ins: {shootingStats.tipIns.made}/{shootingStats.tipIns.attempted} ({shootingStats.tipIns.pct}%)</Typography>
            <Typography variant="body2">2-Point Jumpers: {shootingStats.twoPointJumpers.made}/{shootingStats.twoPointJumpers.attempted} ({shootingStats.twoPointJumpers.pct}%) - {shootingStats.twoPointJumpers.assistedPct}% Assisted</Typography>
            <Typography variant="body2">3-Point Jumpers: {shootingStats.threePointJumpers.made}/{shootingStats.threePointJumpers.attempted} ({shootingStats.threePointJumpers.pct}%) - {shootingStats.threePointJumpers.assistedPct}% Assisted</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Shot Distribution</Typography>
            <Typography variant="body2">Dunks: {shootingStats.attemptsBreakdown.dunks}%</Typography>
            <Typography variant="body2">Layups: {shootingStats.attemptsBreakdown.layups}%</Typography>
            <Typography variant="body2">Tip Ins: {shootingStats.attemptsBreakdown.tipIns}%</Typography>
            <Typography variant="body2">2-Point Jumpers: {shootingStats.attemptsBreakdown.twoPointJumpers}%</Typography>
            <Typography variant="body2">3-Point Jumpers: {shootingStats.attemptsBreakdown.threePointJumpers}%</Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default PlayerSeasonShootingStatsCard;