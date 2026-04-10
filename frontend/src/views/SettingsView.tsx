import { Box, Card, CardContent, CircularProgress, Grid, Typography, LinearProgress, Chip } from '@mui/material';
import { useSystemHealth } from '../hooks/useSystemHealth';

export default function SettingsView() {
  const { data, loading, error } = useSystemHealth();

  if (loading) {
    return (
      <Box sx={{ display: 'flex', justifyContent: 'center', mt: 4 }}>
        <CircularProgress />
      </Box>
    );
  }

  if (error) {
    return (
      <Box sx={{ mt: 4 }}>
        <Typography color="error">Error loading system health: {error}</Typography>
      </Box>
    );
  }

  const quotaPercent = 
    data?.quotaLimit && data?.quotaRemaining != null 
    ? (data.quotaRemaining / data.quotaLimit) * 100 
    : null;

  return (
    <Box sx={{ my: 4 }}>
      <Typography variant="h4" component="h1" gutterBottom sx={{ fontWeight: 'bold' }}>
        Settings & System Health
      </Typography>
      <Grid container spacing={4} sx={{ mt: 2 }}>
        {/* Backend Status */}
        <Grid {...{ xs: 12, sm: 6 } as any}>
          <Card elevation={2} sx={{ borderRadius: 2 }}>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Backend Server
              </Typography>
              <Box sx={{ display: 'flex', alignItems: 'center', gap: 2 }}>
                <Chip 
                  label={data?.backendStatus || 'UNKNOWN'} 
                  color={data?.backendStatus === 'UP' ? 'success' : 'error'} 
                  sx={{ fontWeight: 'bold' }}
                />
                <Typography variant="body2" color="text.secondary">
                  The local spring boot proxy.
                </Typography>
              </Box>
            </CardContent>
          </Card>
        </Grid>

        {/* API Connection & Quota */}
        <Grid {...{ xs: 12, sm: 6 } as any}>
          <Card elevation={2} sx={{ borderRadius: 2 }}>
            <CardContent>
              <Typography variant="h6" gutterBottom>
                College Basketball Data API
              </Typography>
              
              <Box sx={{ display: 'flex', alignItems: 'center', gap: 2, mb: 2 }}>
                <Chip 
                  label={data?.apiConnectionStatus || 'UNKNOWN'} 
                  color={data?.apiConnectionStatus === 'UP' ? 'success' : 'warning'} 
                  sx={{ fontWeight: 'bold' }}
                />
                <Typography variant="body2" color="text.secondary">
                  External Data Connection Status.
                </Typography>
              </Box>

              {data?.quotaLimit ? (
                <Box sx={{ mt: 3 }}>
                  <Typography variant="body2" sx={{ mb: 1, display: 'flex', justifyContent: 'space-between' }}>
                    <span>Rate Limit Quota</span>
                    <strong>{data.quotaRemaining} / {data.quotaLimit} remaining</strong>
                  </Typography>
                  <LinearProgress 
                    variant="determinate" 
                    value={quotaPercent ?? 0} 
                    color={quotaPercent && quotaPercent > 20 ? 'primary' : 'error'}
                    sx={{ height: 10, borderRadius: 5 }}
                  />
                  {data.quotaReset && (
                    <Typography variant="caption" color="text.secondary" sx={{ display: 'block', mt: 1 }}>
                      Resets at: {new Date(data.quotaReset * 1000).toLocaleString()}
                    </Typography>
                  )}
                </Box>
              ) : (
                <Typography variant="body2" color="text.secondary" sx={{ mt: 1 }}>
                  Quota information not yet available. Make an API request (e.g. view Games) to populate.
                </Typography>
              )}
            </CardContent>
          </Card>
        </Grid>
      </Grid>
    </Box>
  );
}
