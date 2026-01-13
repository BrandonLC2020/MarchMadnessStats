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
          background: isDark ? 'rgba(30, 30, 30, 0.6)' : 'rgba(255, 255, 255, 0.7)',
          backdropFilter: 'blur(16px)',
          border: '1px solid',
          borderColor: teamColor
            ? teamColor
            : isDark
              ? 'rgba(255, 255, 255, 0.1)'
              : 'rgba(255, 255, 255, 0.4)',
          boxShadow: isDark ? '0 8px 32px 0 rgba(0, 0, 0, 0.3)' : '0 8px 32px 0 rgba(31, 38, 135, 0.1)',
          borderRadius: 4,
          overflow: 'hidden',
          transition: 'border-color 0.3s ease',
          ...(teamColor && {
            boxShadow: `0 8px 32px 0 ${teamColor}22`,
          }),
        }}
      >
        {children}
      </Paper>
    </Box>
  );
};

export default GlassCard;
