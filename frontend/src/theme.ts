import { createTheme, PaletteMode, ThemeOptions } from '@mui/material/styles';

// Helper to get design tokens based on mode
const getDesignTokens = (mode: PaletteMode): ThemeOptions => ({
  palette: {
    mode,
    primary: {
      main: '#1565C0', // Darker blue for better contrast (4.5:1+ with white)
      light: '#42A5F5',
      dark: '#0D47A1',
      contrastText: '#FFFFFF',
    },
    secondary: {
      main: '#F57C00', // Orange accent
      light: '#FFB74D',
      dark: '#E65100',
      contrastText: '#000000',
    },
    ...(mode === 'dark'
      ? {
        // Dark mode palette
        background: {
          default: '#0a0a0f',
          paper: '#1a1a24',
        },
        text: {
          primary: '#FFFFFF',
          secondary: 'rgba(255, 255, 255, 0.7)',
        },
        action: {
          disabled: 'rgba(255, 255, 255, 0.3)',
          disabledBackground: 'rgba(255, 255, 255, 0.12)',
        },
      }
      : {
        // Light mode palette
        background: {
          default: '#f5f5f7',
          paper: '#FFFFFF',
        },
        text: {
          primary: '#1a1a1a',
          secondary: 'rgba(0, 0, 0, 0.6)',
        },
        action: {
          disabled: 'rgba(0, 0, 0, 0.38)',
          disabledBackground: 'rgba(0, 0, 0, 0.12)',
        },
      }),
  },
  components: {
    MuiButton: {
      styleOverrides: {
        root: {
          textTransform: 'none',
          fontWeight: 600,
        },
        contained: ({ theme }) => ({
          '&.Mui-disabled': {
            backgroundColor: theme.palette.mode === 'dark'
              ? 'rgba(255, 255, 255, 0.15)'
              : 'rgba(0, 0, 0, 0.15)',
            color: theme.palette.mode === 'dark'
              ? 'rgba(255, 255, 255, 0.5)'
              : 'rgba(0, 0, 0, 0.4)',
          },
        }),
      },
    },
    MuiTableCell: {
      styleOverrides: {
        root: ({ theme }) => ({
          color: theme.palette.text.primary,
          borderBottomColor: theme.palette.mode === 'dark'
            ? 'rgba(255, 255, 255, 0.1)'
            : 'rgba(0, 0, 0, 0.1)',
        }),
        head: ({ theme }) => ({
          fontWeight: 700,
          backgroundColor: theme.palette.mode === 'dark'
            ? 'rgba(255, 255, 255, 0.05)'
            : 'rgba(0, 0, 0, 0.03)',
        }),
      },
    },
    MuiToggleButton: {
      styleOverrides: {
        root: ({ theme }) => ({
          '&.Mui-selected': {
            backgroundColor: theme.palette.primary.main,
            color: theme.palette.primary.contrastText,
            '&:hover': {
              backgroundColor: theme.palette.primary.dark,
            },
          },
        }),
      },
    },
    MuiChip: {
      styleOverrides: {
        root: ({ theme }) => ({
          fontWeight: 500,
        }),
      },
    },
  },
});

// Create theme function that can be used with color mode context
export const createAppTheme = (mode: PaletteMode) => createTheme(getDesignTokens(mode));

// Default theme (dark mode)
const theme = createAppTheme('dark');

export default theme;