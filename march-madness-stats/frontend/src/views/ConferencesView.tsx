import React, { use, useEffect } from 'react';
import { Typography, Box, Grid } from '@mui/material';

const ConferencesView: React.FC = () => {
    const [conferences, setConferences] = React.useState([]);
    useEffect(() => {
        // Fetch conference data here
    }, []);

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Conferences
            </Typography>
            <Grid container spacing={2}>
                {/* Map through your conference data and render ConferenceCard components here */}
            </Grid>
        </Box>
    );
};

export default ConferencesView;
