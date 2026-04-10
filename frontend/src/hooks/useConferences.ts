import { fetchData } from './apiHelper';
import { ConferenceHistory, ConferenceInfo } from '../types/api';

export const useConferences = () => {
  const getConferenceHistory = (conference?: string): Promise<ConferenceHistory[]> => {
    return fetchData<ConferenceHistory[]>('/conferences/history', { conference });
  };

  const getConferences = (): Promise<ConferenceInfo[]> => {
    return fetchData<ConferenceInfo[]>('/conferences');
  };

  return { getConferenceHistory, getConferences };
};