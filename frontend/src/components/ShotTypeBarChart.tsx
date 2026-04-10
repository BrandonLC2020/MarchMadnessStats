// frontend/src/components/ShotTypeBarChart.tsx
import React from 'react';
import { Card, CardContent, Typography, useTheme } from '@mui/material';
import Plot from 'react-plotly.js';
import { PlayerSeasonShootingStats, SeasonShootingStats } from '../types/api';

interface ShotTypeBarChartProps {
  shootingData: SeasonShootingStats | PlayerSeasonShootingStats;
}

const ShotTypeBarChart: React.FC<ShotTypeBarChartProps> = ({ shootingData }) => {
  const theme = useTheme();

  if (!shootingData) {
    return null;
  }

  const { dunks, layups, tipIns, twoPointJumpers, threePointJumpers } = shootingData;

  const shotTypes = ['Dunks', 'Layups', 'Tip Ins', '2-Point Jumpers', '3-Point Jumpers'];
  const makes = [dunks.made, layups.made, tipIns.made, twoPointJumpers.made, threePointJumpers.made];
  const attempts = [dunks.attempted, layups.attempted, tipIns.attempted, twoPointJumpers.attempted, threePointJumpers.attempted];
  const misses = attempts.map((attempt, i) => attempt - makes[i]);

  const hoverTextMakes = makes.map((made, i) => {
    const percentage = attempts[i] > 0 ? ((made / attempts[i]) * 100).toFixed(1) : 0;
    return `${shotTypes[i]}<br>${made} / ${attempts[i]} Made (${percentage}%)`;
  });

  const hoverTextMisses = misses.map((miss, i) => {
    return `${shotTypes[i]}<br>${miss} / ${attempts[i]} Missed`;
  });

  const trace1 = {
    x: shotTypes,
    y: makes,
    name: 'Made',
    type: 'bar',
    marker: {
      color: theme.palette.primary.main,
    },
    text: hoverTextMakes,
    hoverinfo: 'text',
    textposition: 'none',
  };

  const trace2 = {
    x: shotTypes,
    y: misses,
    name: 'Missed',
    type: 'bar',
    marker: {
      color: theme.palette.mode === 'dark' ? '#333333' : '#F2F2F2',
    },
    text: hoverTextMisses,
    hoverinfo: 'text',
    textposition: 'none',
  };

  const data = [trace1, trace2];

  return (
    <Card sx={{ minWidth: 275, mb: 2, height: '100%' }}>
      <CardContent>
        <Typography variant="h6" gutterBottom align="center">
          Shot Type Breakdown
        </Typography>
        <Plot
          data={data as any}
          layout={{
            barmode: 'stack',
            showlegend: true,
            height: 450,
            margin: { t: 10, b: 100, l: 40, r: 10 },
            paper_bgcolor: 'rgba(0,0,0,0)',
            plot_bgcolor: 'rgba(0,0,0,0)',
            font: {
              color: theme.palette.text.primary,
            },
            xaxis: {
              tickangle: -45,
              tickfont: {
                color: theme.palette.text.primary,
              },
              // gridcolor: theme.palette.divider, 
            },
            yaxis: {
              title: {
                text: 'Shots',
                font: {
                  color: theme.palette.text.primary,
                },
              },
              tickfont: {
                color: theme.palette.text.primary,
              },
              gridcolor: theme.palette.divider,
              zerolinecolor: theme.palette.divider,
            },
          }}
          config={{ displayModeBar: false }}
          style={{ width: '100%' }}
        />
      </CardContent>
    </Card>
  );
};

export default ShotTypeBarChart;