import { fetchData } from './apiHelper';
import { ConferenceHistory } from '../types/api'; // Assuming you create a types file

export const useConferences = () => {
  const getConferenceHistory = (conference?: string): Promise<ConferenceHistory[]> => { // Replace 'any' with a proper type
    return fetchData<ConferenceHistory[]>('/conferences/history', { conference });
  };

  return { getConferenceHistory };
};