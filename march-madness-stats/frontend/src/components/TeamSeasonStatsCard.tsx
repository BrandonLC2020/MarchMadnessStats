import React from 'react';
import { Card, CardContent, Typography, Grid } from '@mui/material';
import { TeamSeasonUnitStats } from '../types/api';

interface TeamSeasonStatsCardProps {
  stats: TeamSeasonUnitStats;
  team: string;
}

const TeamSeasonStatsCard: React.FC<TeamSeasonStatsCardProps> = ({ stats, team }) => {
  if (!stats) {
    return null;
  }
  const teamStats = stats;

  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h6" gutterBottom> {team}{team === 'Opponent' ? 's\'' : '\'s'} Stats</Typography>
        <Grid container spacing={2}>
          <Grid>
            <Typography variant="subtitle1">Offense</Typography>
            <Typography variant="body2">Points: {teamStats.points.total ?? 'N/A'}</Typography>
            <Typography variant="body2">Assists: {teamStats.assists ?? 'N/A'}</Typography>
            <Typography variant="body2">FG%: {teamStats.fieldGoals.pct ? `${teamStats.fieldGoals.pct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">2P%: {teamStats.twoPointFieldGoals.pct ? `${teamStats.twoPointFieldGoals.pct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">3P%: {teamStats.threePointFieldGoals.pct ? `${teamStats.threePointFieldGoals.pct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">FT%: {teamStats.freeThrows.pct ? `${teamStats.freeThrows.pct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">True Shooting: {teamStats.trueShooting ? `${teamStats.trueShooting.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">Offensive Rating: {teamStats.rating ?? 'N/A'}</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Defense & Team</Typography>
            <Typography variant="body2">Rebounds: {teamStats.rebounds.total ?? 'N/A'}</Typography>
            <Typography variant="body2">Offensive Rebounds: {teamStats.rebounds.offensive ?? 'N/A'}</Typography>
            <Typography variant="body2">Defensive Rebounds: {teamStats.rebounds.defensive ?? 'N/A'}</Typography>
            <Typography variant="body2">Steals: {teamStats.steals ?? 'N/A'}</Typography>
            <Typography variant="body2">Blocks: {teamStats.blocks ?? 'N/A'}</Typography>
            <Typography variant="body2">Turnovers: {teamStats.turnovers.total ?? 'N/A'}</Typography>
            <Typography variant="body2">Team Turnovers: {teamStats.turnovers.teamTotal ?? 'N/A'}</Typography>
            <Typography variant="body2">Fouls: {teamStats.fouls.total ?? 'N/A'}</Typography>
            <Typography variant="body2">Technical Fouls: {teamStats.fouls.technical ?? 'N/A'}</Typography>
            <Typography variant="body2">Flagrant Fouls: {teamStats.fouls.flagrant ?? 'N/A'}</Typography>
            <Typography variant="body2">Possessions: {teamStats.possessions ?? 'N/A'}</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Points Breakdown</Typography>
            <Typography variant="body2">Points In Paint: {teamStats.points.inPaint ?? 'N/A'}</Typography>
            <Typography variant="body2">Points Off Turnovers: {teamStats.points.offTurnovers ?? 'N/A'}</Typography>
            <Typography variant="body2">Fast Break Points: {teamStats.points.fastBreak ?? 'N/A'}</Typography>
          </Grid>
          <Grid>
            <Typography variant="subtitle1">Four Factors</Typography>
            <Typography variant="body2">Effective FG%: {teamStats.fourFactors.effectiveFieldGoalPct ? `${teamStats.fourFactors.effectiveFieldGoalPct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">Turnover Ratio: {teamStats.fourFactors.turnoverRatio ?? 'N/A'}</Typography>
            <Typography variant="body2">Offensive Rebound %: {teamStats.fourFactors.offensiveReboundPct ? `${teamStats.fourFactors.offensiveReboundPct.toFixed(1)}%` : 'N/A'}</Typography>
            <Typography variant="body2">Free Throw Rate: {teamStats.fourFactors.freeThrowRate ?? 'N/A'}</Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default TeamSeasonStatsCard;