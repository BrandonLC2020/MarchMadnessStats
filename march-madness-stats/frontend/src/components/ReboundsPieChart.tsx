// frontend/src/components/ReboundsPieChart.tsx
import React from 'react';
import { Card, CardContent, Typography } from '@mui/material';
import Plot from 'react-plotly.js';
import { TeamSeasonUnitStatsRebounds } from '../types/api';

interface ReboundsPieChartProps {
  reboundsData: TeamSeasonUnitStatsRebounds;
}

const ReboundsPieChart: React.FC<ReboundsPieChartProps> = ({ reboundsData }) => {
  if (!reboundsData) {
    return null;
  }

  const { offensive, defensive } = reboundsData;
  const data = [
    {
      values: [offensive ?? 0, defensive ?? 0],
      labels: ['Offensive', 'Defensive'],
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
    <Card sx={{ minWidth: 275, mb: 2 }}>
      <CardContent>
        <Typography variant="h6" gutterBottom align="center">
          Rebound Breakdown
        </Typography>
        <Plot
          data={data as any}
          layout={{
            showlegend: true,
            height: 300,
            margin: { t: 10, b: 10, l: 10, r: 10 },
          }}
          config={{ displayModeBar: false }}
          style={{ width: '100%' }}
        />
      </CardContent>
    </Card>
  );
};

export default ReboundsPieChart;