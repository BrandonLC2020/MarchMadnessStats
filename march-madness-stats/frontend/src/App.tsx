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
  Toolbar,
  Typography,
} from '@mui/material';
import RankingsView from './views/RankingsView';
import ConferencesView from './views/ConferencesView';
import ConferenceTeamsView from './views/ConferenceTeamsView';
import PlayerView from './views/PlayerView';
import TeamView from './views/TeamView';
import GameDetailsView from './views/GameDetailsView';
import './App.css';
import GamesView from './views/GamesView';
import logo from './logo.svg';

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
    </Grid>
  </Box>
);

function App() {
  return (
    <Router>
      <AppBar position="static">
        <Toolbar>
          <img src={logo} className="App-logo" alt="logo" style={{ height: '40px', marginRight: '10px' }} />
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            <RouterLink to="/" style={{ textDecoration: 'none', color: 'inherit' }}>
              Men's College Basketball Stats
            </RouterLink>
          </Typography>
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
        </Routes>
      </Container>
    </Router>
  );
}

export default App;