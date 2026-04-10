import { fetchData } from './apiHelper';
import { PollTeamInfo, SeasonType } from '../types/api';

export const useRankings = () => {
  const getRankings = (params: { season?: number; seasonType?: SeasonType; week?: number; pollType?: string; team?: string; conference?: string; }): Promise<PollTeamInfo[]> => {
    return fetchData<PollTeamInfo[]>('/rankings', params);
  };

  return { getRankings };
};