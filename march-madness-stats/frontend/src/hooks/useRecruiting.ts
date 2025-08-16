import { fetchData } from './apiHelper';
import { Recruit } from '../types/api';

export const useRecruiting = () => {
  const getRecruits = (params: { year?: number; team?: string; conference?: string; position?: string; }): Promise<Recruit[]> => {
    return fetchData<Recruit[]>('/recruiting/players', params);
  };

  return { getRecruits };
};