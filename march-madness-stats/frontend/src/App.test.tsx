import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
 
test('renders dashboard page', () => {
  render(<App />);
  const titleElement = screen.getByText(/March Madness Stats Dashboard/i);
  expect(titleElement).toBeInTheDocument();

  const conferencesCard = screen.getByText('Conferences');
  expect(conferencesCard).toBeInTheDocument();

  const rankingsCard = screen.getByText('Rankings');
  expect(rankingsCard).toBeInTheDocument();
});
