import React from 'react';
import { Box, BoxProps, Paper, useTheme } from '@mui/material';
import { motion } from 'framer-motion';

interface GlassCardProps extends BoxProps {
  children: React.ReactNode;
  delay?: number;
  teamColor?: string | null;
}

const GlassCard: React.FC<GlassCardProps> = ({ children, delay = 0, teamColor, sx, ...props }) => {
  const theme = useTheme();
  const isDark = theme.palette.mode === 'dark';

  // Theme-aware shadow - blue glow in dark mode, subtle shadow in light mode
  const getBoxShadow = () => {
    if (teamColor) {
      return `0 8px 32px 0 ${teamColor}22`;
    }
    return isDark
      ? '0 8px 32px 0 rgba(0, 0, 0, 0.3), 0 0 20px rgba(100, 149, 237, 0.15)'
      : '0 4px 20px 0 rgba(0, 0, 0, 0.08)';
  };

  return (
    <Box
      component={motion.div}
      initial={{ opacity: 0, y: 20 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.5, delay, type: 'spring', stiffness: 100 }}
      whileHover={{ scale: 1.02, y: -5 }}
      sx={{
        position: 'relative',
        height: '100%',
        ...sx,
      }}
      {...props}
    >
      <Paper
        elevation={0}
        sx={{
          height: '100%',
          p: 3,
          background: isDark
            ? 'rgba(30, 30, 30, 0.6)'
            : 'rgba(255, 255, 255, 0.85)',
          backdropFilter: 'blur(16px)',
          border: '1px solid',
          borderColor: teamColor
            ? teamColor
            : isDark
              ? 'rgba(255, 255, 255, 0.1)'
              : 'rgba(0, 0, 0, 0.08)',
          boxShadow: getBoxShadow(),
          borderRadius: 4,
          overflow: 'hidden',
          transition: 'border-color 0.3s ease, box-shadow 0.3s ease, background 0.3s ease',
        }}
      >
        {children}
      </Paper>
    </Box>
  );
};

export default GlassCard;
