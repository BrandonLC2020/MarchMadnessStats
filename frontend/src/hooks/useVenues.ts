import { fetchData } from './apiHelper';
import { VenueInfo } from '../types/api';

export const useVenues = () => {
  const getVenues = (): Promise<VenueInfo[]> => {
    return fetchData<VenueInfo[]>('/venues');
  };

  return { getVenues };
};