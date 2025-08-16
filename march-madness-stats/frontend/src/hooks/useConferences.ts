import { fetchData } from './apiHelper';
import { Conference } from '../types/api'; // Assuming you create a types file

export const useConferences = () => {
  const getConferenceHistory = (conference?: string): Promise<any[]> => { // Replace 'any' with a proper type
    return fetchData<any[]>('/conferences/history', { conference });
  };

  const getConferences = (): Promise<Conference[]> => {
    return fetchData<Conference[]>('/conferences');
  };

  return { getConferenceHistory, getConferences };
};