---
name: skill-cbb-analyst
description: Expert guidance on College Basketball (CBB) statistical analysis, metrics (eFG%, Pace, Efficiency), and visualization using React and Plotly.js. Use when calculating basketball stats or building data-driven dashboards.
---

# College Basketball Analyst Skill

This skill provides domain expertise for analyzing NCAA basketball data and visualizing it effectively within the March Madness Stats application.

## Core Metrics

When analyzing or displaying statistics, prioritize these key efficiency metrics:

- **eFG% (Effective Field Goal Percentage)**: `(FGM + 0.5 * 3PM) / FGA`. Accounts for the extra value of 3-point shots.
- **TO% (Turnover Percentage)**: `TO / (FGA + 0.475 * FTA + TO)`. Measures possession security.
- **Pace (Possessions per Game)**: `40 * (Possessions / Minutes)`. Normalizes stats across different playing styles.
- **Adjusted Efficiency**: Calculated using points scored/allowed per 100 possessions, ideally adjusted for opponent strength.

## Visualization Patterns

### Plotly.js Integration
Use Plotly.js for complex charts. Ensure charts are responsive and follow the project's aesthetic.

- **Shot Distribution**: Use `ShotDistributionPieChart.tsx` pattern.
- **Shot Type Comparison**: Use `ShotTypeBarChart.tsx` pattern.
- **Theme Matching**: Always use colors from `src/theme.ts` (primary, secondary, background.paper).

### UI Components
- **GlassCard**: All statistical visualizations should be wrapped in the `GlassCard` component for a consistent "glassmorphism" look.
- **Formatting**: Use `Intl.NumberFormat` for percentages (1 decimal) and efficiency ratings (2 decimals).

## Implementation Example (eFG% calculation)

```typescript
const calculateEFG = (stats: PlayerSeasonStats) => {
  const { fieldGoalsMade, threePointFieldGoalsMade, fieldGoalsAttempted } = stats;
  if (fieldGoalsAttempted === 0) return 0;
  return ((fieldGoalsMade + 0.5 * threePointFieldGoalsMade) / fieldGoalsAttempted) * 100;
};
```
