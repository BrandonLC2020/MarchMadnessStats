import { fetchData } from './apiHelper';
import { TeamInfo, TeamRoster } from '../types/api';

export const useTeams = () => {
  const getTeamRoster = (season: number, team?: string): Promise<TeamRoster[]> => {
    return fetchData<TeamRoster[]>('/teams/roster', { season, team });
  };

  const getTeams = (params: { conference?: string; season?: number; }): Promise<TeamInfo[]> => {
    return fetchData<TeamInfo[]>('/teams', params);
  };

  return { getTeamRoster, getTeams };
};