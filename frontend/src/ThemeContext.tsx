import React, { createContext, useContext, useMemo, useState } from 'react';
import { createTheme, CssBaseline, Theme, ThemeProvider as MuiThemeProvider } from '@mui/material';

interface ColorModeContextType {
  toggleColorMode: () => void;
  mode: 'light' | 'dark';
}

const ColorModeContext = createContext<ColorModeContextType>({
  toggleColorMode: () => {},
  mode: 'light',
});

export const useColorMode = () => useContext(ColorModeContext);

export const ThemeProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [mode, setMode] = useState<'light' | 'dark'>('dark');

  const colorMode = useMemo(
    () => ({
      toggleColorMode: () => {
        setMode((prevMode) => (prevMode === 'light' ? 'dark' : 'light'));
      },
      mode,
    }),
    [mode]
  );

  const theme: Theme = useMemo(
    () =>
      createTheme({
        palette: {
          mode,
          primary: { main: '#E67E22' },
          background: {
            default: mode === 'dark' ? '#121212' : '#f0f2f5',
            paper: mode === 'dark' ? '#1e1e1e' : '#ffffff',
          },
        },
        typography: {
          fontFamily: '"Inter", "Roboto", "Helvetica", "Arial", sans-serif',
          h4: { fontWeight: 700 },
          h6: { fontWeight: 600 },
        },
        shape: { borderRadius: 16 },
        components: {
          MuiCssBaseline: {
            styleOverrides: {
              body: {
                transition: 'background-color 0.3s ease',
                backgroundImage:
                  mode === 'dark'
                    ? 'radial-gradient(circle at 50% 50%, #2a1b12 0%, #121212 100%)'
                    : 'radial-gradient(circle at 50% 50%, #fff8f0 0%, #f0f2f5 100%)',
              },
            },
          },
        },
      }),
    [mode]
  );

  return (
    <ColorModeContext.Provider value={colorMode}>
      <MuiThemeProvider theme={theme}>
        <CssBaseline />
        {children}
      </MuiThemeProvider>
    </ColorModeContext.Provider>
  );
};
