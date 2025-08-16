import React, { useEffect } from 'react';
import { Typography, Box, Grid } from '@mui/material';
import ConferenceCard from '../components/ConferenceCard';



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
                {conferences.map((conference) => (
                    <Grid item xs={12} sm={6} md={4} key={conference.id} component="div">
                        <ConferenceCard conference={conference} />
                    </Grid>
                ))}
            </Grid>
        </Box>
    );
};

export default ConferencesView;
