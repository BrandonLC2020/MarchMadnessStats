// frontend/src/components/ShotDistributionPieChart.tsx
import React from 'react';
import { Card, CardContent, Box, Typography, useTheme } from '@mui/material';
import Plot from 'react-plotly.js';
import { SeasonShootingStats, PlayerSeasonShootingStats } from '../types/api';

interface ShotDistributionPieChartProps {
  shootingData: SeasonShootingStats | PlayerSeasonShootingStats;
}

const ShotDistributionPieChart: React.FC<ShotDistributionPieChartProps> = ({ shootingData }) => {
  const theme = useTheme();

  if (!shootingData || !shootingData.attemptsBreakdown) {
    return null;
  }

  const { attemptsBreakdown } = shootingData;

  const bgColors = theme.palette.mode === 'dark'
    ? [theme.palette.primary.main, '#333333', '#555555', '#444444', '#666666']
    : ['#E67E22', '#F2F2F2', '#A9A9A9', '#D3D3D3', '#BDBDBD'];

  return (
    <Card sx={{ minWidth: 275, mb: 2, height: '100%' }}>
      <CardContent>
        <Typography variant="h6" gutterBottom align="center">
          Shot Distribution
        </Typography>
        <Plot
          data={[
            {
              values: [attemptsBreakdown.dunks, attemptsBreakdown.layups, attemptsBreakdown.tipIns, attemptsBreakdown.twoPointJumpers, attemptsBreakdown.threePointJumpers],
              labels: ['Dunks', 'Layups', 'Tip Ins', '2-Point Jumpers', '3-Point Jumpers'],
              type: 'pie',
              hole: 0.4,
              marker: {
                colors: bgColors,
              },
              textinfo: 'percent',
              hoverinfo: 'label+value',
            },
          ]}
          layout={{
            showlegend: true,
            height: 450,
            margin: { t: 10, b: 10, l: 10, r: 10 },
            paper_bgcolor: 'rgba(0,0,0,0)',
            plot_bgcolor: 'rgba(0,0,0,0)',
            font: {
              color: theme.palette.text.primary,
            },
          }}
          config={{ displayModeBar: false }}
          style={{ width: '100%' }}
        />
      </CardContent>
    </Card>
  );
};

export default ShotDistributionPieChart;