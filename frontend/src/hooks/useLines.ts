import { fetchData } from './apiHelper';
import { GameLines, LineProviderInfo } from '../types/api';

export const useLines = () => {
  const getLines = (params: { season?: number; team?: string; conference?: string; startDateRange?: string; endDateRange?: string; }): Promise<GameLines[]> => {
    return fetchData<GameLines[]>('/lines', params);
  };

  const getProviders = (): Promise<LineProviderInfo[]> => {
    return fetchData<LineProviderInfo[]>('/lines/providers');
  };

  return { getLines, getProviders };
};