// frontend/src/components/TeamSeasonShootingStatsCard.tsx
import React from 'react';
import { Card, CardContent, Typography, Grid } from '@mui/material';
import { SeasonShootingStats } from '../types/api';

interface TeamSeasonShootingStatsCardProps {
  stats: SeasonShootingStats;
  team: string;
}

const TeamSeasonShootingStatsCard: React.FC<TeamSeasonShootingStatsCardProps> = ({ stats, team }) => {
  if (!stats) {
    return null;
  }
  const teamStats = stats;

  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h6" gutterBottom>{team}'s Shooting Stats</Typography>
        <Grid container spacing={2}>
          <Grid>
            <Typography variant="body2">Tracked Shots: {teamStats.trackedShots}</Typography>
            <Typography variant="body2">Assisted Pct: {teamStats.assistedPct}%</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Shot Types</Typography>
            <Typography variant="body2">Dunks: {teamStats.dunks.made}/{teamStats.dunks.attempted} ({teamStats.dunks.pct}%) - {teamStats.dunks.assistedPct}% Assisted</Typography>
            <Typography variant="body2">Layups: {teamStats.layups.made}/{teamStats.layups.attempted} ({teamStats.layups.pct}%) - {teamStats.layups.assistedPct}% Assisted</Typography>
            <Typography variant="body2">Tip Ins: {teamStats.tipIns.made}/{teamStats.tipIns.attempted} ({teamStats.tipIns.pct}%)</Typography>
            <Typography variant="body2">2-Point Jumpers: {teamStats.twoPointJumpers.made}/{teamStats.twoPointJumpers.attempted} ({teamStats.twoPointJumpers.pct}%) - {teamStats.twoPointJumpers.assistedPct}% Assisted</Typography>
            <Typography variant="body2">3-Point Jumpers: {teamStats.threePointJumpers.made}/{teamStats.threePointJumpers.attempted} ({teamStats.threePointJumpers.pct}%) - {teamStats.threePointJumpers.assistedPct}% Assisted</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Shot Distribution</Typography>
            <Typography variant="body2">Dunks: {teamStats.attemptsBreakdown.dunks}%</Typography>
            <Typography variant="body2">Layups: {teamStats.attemptsBreakdown.layups}%</Typography>
            <Typography variant="body2">Tip Ins: {teamStats.attemptsBreakdown.tipIns}%</Typography>
            <Typography variant="body2">2-Point Jumpers: {teamStats.attemptsBreakdown.twoPointJumpers}%</Typography>
            <Typography variant="body2">3-Point Jumpers: {teamStats.attemptsBreakdown.threePointJumpers}%</Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default TeamSeasonShootingStatsCard;