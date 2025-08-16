import { fetchData } from './apiHelper';
import { PlayerSeasonShootingStats, PlayerSeasonStats, SeasonShootingStats, SeasonType, TeamSeasonStats } from '../types/api';

export const useStats = () => {
  const getPlayerSeasonShootingStats = (params: { season: number; seasonType?: SeasonType; team?: string; conference?: string; startDateRange?: string; endDateRange?: string; }): Promise<PlayerSeasonShootingStats[]> => {
    return fetchData<PlayerSeasonShootingStats[]>('/stats/player/shooting/season', params);
  };

  const getPlayerSeasonStats = (params: { season: number; seasonType?: SeasonType; team?: string; conference?: string; startDateRange?: string; endDateRange?: string; }): Promise<PlayerSeasonStats[]> => {
    return fetchData<PlayerSeasonStats[]>('/stats/player/season', params);
  };

  const getTeamSeasonShootingStats = (params: { season: number; seasonType?: SeasonType; team?: string; conference?: string; startDateRange?: string; endDateRange?: string; }): Promise<SeasonShootingStats[]> => {
    return fetchData<SeasonShootingStats[]>('/stats/team/shooting/season', params);
  };

  const getTeamSeasonStats = (params: { season?: number; seasonType?: SeasonType; team?: string; conference?: string; startDateRange?: string; endDateRange?: string; }): Promise<TeamSeasonStats[]> => {
    return fetchData<TeamSeasonStats[]>('/stats/team/season', params);
  };

  return { getPlayerSeasonShootingStats, getPlayerSeasonStats, getTeamSeasonShootingStats, getTeamSeasonStats };
};