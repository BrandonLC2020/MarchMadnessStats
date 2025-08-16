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
import './App.css';

const Home = () => (
  <Box sx={{ my: 4 }}>
    <Typography variant="h4" component="h1" gutterBottom>
      March Madness Stats Dashboard
    </Typography>
    <Grid container spacing={4} sx={{ mt: 2 }}>
      <Grid>
        <Card>
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
      <Grid>
        <Card>
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
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            <RouterLink to="/" style={{ textDecoration: 'none', color: 'inherit' }}>
              March Madness Stats
            </RouterLink>
          </Typography>
        </Toolbar>
      </AppBar>
      <Container maxWidth="lg">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/rankings" element={<RankingsView />} />
          <Route path="/conferences" element={<ConferencesView />} />
        </Routes>
      </Container>
    </Router>
  );
}

export default App;
