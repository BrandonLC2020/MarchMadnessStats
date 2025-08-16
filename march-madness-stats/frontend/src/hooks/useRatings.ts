import { fetchData } from './apiHelper';
import { AdjustedEfficiencyInfo, SrsInfo } from '../types/api';

export const useRatings = () => {
  const getAdjustedEfficiency = (params: { season?: number; team?: string; conference?: string; }): Promise<AdjustedEfficiencyInfo[]> => {
    return fetchData<AdjustedEfficiencyInfo[]>('/ratings/adjusted', params);
  };

  const getSrs = (params: { season?: number; team?: string; conference?: string; }): Promise<SrsInfo[]> => {
    return fetchData<SrsInfo[]>('/ratings/srs', params);
  };

  return { getAdjustedEfficiency, getSrs };
};