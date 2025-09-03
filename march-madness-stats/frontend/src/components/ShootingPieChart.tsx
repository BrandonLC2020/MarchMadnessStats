// frontend/src/components/ShootingPieChart.tsx
import React from 'react';
import { Card, CardContent, Grid, Typography } from '@mui/material';
import Plot from 'react-plotly.js';
import { PlayerSeasonStats, TeamSeasonUnitStats } from '../types/api';

interface ShootingPieChartProps {
  shootingData: PlayerSeasonStats | TeamSeasonUnitStats;
}

const PieChart: React.FC<{ title: string; made: number; attempted: number }> = ({ title, made, attempted }) => {
  const missed = attempted - made;
  const data = [
    {
      values: [made, missed],
      labels: ['Made', 'Missed'],
      type: 'pie',
      hole: 0.4,
      marker: {
        colors: ['#E67E22', '#F2F2F2'],
      },
      textinfo: 'percent',
      hoverinfo: 'label+value',
    },
  ];

  return (
    <Grid>
      <Typography align="center" variant="subtitle1">
        {title}
      </Typography>
      <Plot
        data={data as any}
        layout={{
          showlegend: false,
          height: 200,
          margin: { t: 0, b: 0, l: 0, r: 0 },
        }}
        config={{ displayModeBar: false }}
        style={{ width: '100%' }}
      />
    </Grid>
  );
};

const ShootingPieChart: React.FC<ShootingPieChartProps> = ({ shootingData }) => {
  if (!shootingData) {
    return null;
  }

  const {
    fieldGoals,
    twoPointFieldGoals,
    threePointFieldGoals,
    freeThrows,
  } = shootingData;

  return (
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Grid container spacing={2} justifyContent="center" alignItems="center">
          {fieldGoals && (
            <PieChart
              title="Field Goals"
              made={fieldGoals.made ?? 0}
              attempted={fieldGoals.attempted ?? 0}
            />
          )}
          {twoPointFieldGoals && (
            <PieChart
              title="2-Pointers"
              made={twoPointFieldGoals.made ?? 0}
              attempted={twoPointFieldGoals.attempted ?? 0}
            />
          )}
          {threePointFieldGoals && (
            <PieChart
              title="3-Pointers"
              made={threePointFieldGoals.made ?? 0}
              attempted={threePointFieldGoals.attempted ?? 0}
            />
          )}
          {freeThrows && (
            <PieChart
              title="Free Throws"
              made={freeThrows.made ?? 0}
              attempted={freeThrows.attempted ?? 0}
            />
          )}
        </Grid>
      </CardContent>
    </Card>
  );
};

export default ShootingPieChart;