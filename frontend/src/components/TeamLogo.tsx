import React, { useState } from 'react';
import { Avatar, Box } from '@mui/material';
import SportsBasketballIcon from '@mui/icons-material/SportsBasketball';

interface TeamLogoProps {
  school: string;
  size?: number;
}

const TeamLogo: React.FC<TeamLogoProps> = ({ school, size = 60 }) => {
  const [error, setError] = useState(false);

  const slug = school.toLowerCase().replace(/ /g, '-').replace(/[^\w-]/g, '');
  const url = `https://ncaa-api.henrygd.me/logo/${slug}.svg`;

  if (error) {
    return (
      <Avatar sx={{ width: size, height: size, bgcolor: 'primary.main' }}>
        <SportsBasketballIcon />
      </Avatar>
    );
  }

  return (
    <Box
      component="img"
      src={url}
      alt={`${school} logo`}
      onError={() => setError(true)}
      sx={{
        width: size,
        height: size,
        objectFit: 'contain',
        filter: 'drop-shadow(0px 4px 6px rgba(0,0,0,0.2))',
      }}
    />
  );
};

export default TeamLogo;
