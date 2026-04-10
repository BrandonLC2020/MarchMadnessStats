// frontend/src/App.tsx
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link as RouterLink,
} from 'react-router-dom';
import {
  AppBar,
  Box,
  Card,
  CardActionArea,
  CardContent,
  Container,
  Grid,
  IconButton,
  Toolbar,
  Typography,
} from '@mui/material';
import Brightness4Icon from '@mui/icons-material/Brightness4';
import Brightness7Icon from '@mui/icons-material/Brightness7';
import RankingsView from './views/RankingsView';
import ConferencesView from './views/ConferencesView';
import ConferenceTeamsView from './views/ConferenceTeamsView';
import PlayerView from './views/PlayerView';
import TeamView from './views/TeamView';
import GameDetailsView from './views/GameDetailsView';
import SettingsView from './views/SettingsView';
import SettingsIcon from '@mui/icons-material/Settings';
import './App.css';
import GamesView from './views/GamesView';
import FavoritesView from './views/FavoritesView';
import { useColorMode } from './ThemeContext';

const ThemeToggle = () => {
  const { toggleColorMode, mode } = useColorMode();
  return (
    <IconButton sx={{ ml: 1 }} onClick={toggleColorMode} color="inherit">
      {mode === 'dark' ? <Brightness7Icon /> : <Brightness4Icon />}
    </IconButton>
  );
};

const Home = () => (
  <Box sx={{ my: 4 }}>
    <Typography variant="h4" component="h1" gutterBottom>
      Home Dashboard
    </Typography>
    <Grid container spacing={4} sx={{ mt: 2 }}>
      <Grid {...{ xs: 12, sm: 6, md: 4 } as any}>
        <Card sx={{ minWidth: 275, mb: 2 }}>
          <CardActionArea component={RouterLink} to="/games">
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Games
              </Typography>
              <Typography variant="body2" color="text.secondary">
                View all games.
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </Grid>
      <Grid {...{ xs: 12, sm: 6, md: 4 } as any}>
        <Card sx={{ minWidth: 275, mb: 2 }}>
          <CardActionArea component={RouterLink} to="/conferences">
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Conferences
              </Typography>
              <Typography variant="body2" color="text.secondary">
                View historical data for NCAA basketball conferences.
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </Grid>
      <Grid {...{ xs: 12, sm: 6, md: 4 } as any}>
        <Card sx={{ minWidth: 275, mb: 2 }}>
          <CardActionArea component={RouterLink} to="/rankings">
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Rankings
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Explore various team rankings and statistics.
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </Grid>
      <Grid {...{ xs: 12, sm: 6, md: 4 } as any}>
        <Card sx={{ minWidth: 275, mb: 2 }}>
          <CardActionArea component={RouterLink} to="/favorites">
            <CardContent>
              <Typography gutterBottom variant="h5" component="div">
                Favorites
              </Typography>
              <Typography variant="body2" color="text.secondary">
                View your favorite teams.
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </Grid>
    </Grid>
  </Box>
);

function App() {
  return (
    <Router>
      <AppBar
        position="static"
        color="transparent"
        elevation={0}
        sx={{
          backdropFilter: 'blur(10px)',
          borderBottom: '1px solid rgba(255,255,255,0.1)',
        }}
      >
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1, fontWeight: 'bold', letterSpacing: '1px' }}>
            <RouterLink to="/" style={{ textDecoration: 'none', color: 'inherit' }}>
              CBB STATS
            </RouterLink>
          </Typography>
            <ThemeToggle />
            <IconButton sx={{ ml: 1 }} component={RouterLink} to="/settings" color="inherit">
              <SettingsIcon />
            </IconButton>
          </Toolbar>
      </AppBar>
      <Container maxWidth="lg">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/rankings" element={<RankingsView />} />
          <Route path="/conferences" element={<ConferencesView />} />
          <Route path="/games" element={<GamesView />} />
          <Route path="/conferences/:conferenceAbbreviation" element={<ConferenceTeamsView />} />
          <Route path="/player/:playerId" element={<PlayerView />} />
          <Route path="/team/:teamId" element={<TeamView />} />
          <Route path="/game/:gameId" element={<GameDetailsView />} />
          <Route path="/favorites" element={<FavoritesView />} />
          <Route path="/settings" element={<SettingsView />} />
        </Routes>
      </Container>
    </Router>
  );
}

export default App;
