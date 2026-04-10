import { fetchData } from './apiHelper';
import { LineupStats } from '../types/api';

export const useLineups = () => {
  const getLineupStatsByGame = (gameId: number): Promise<LineupStats[]> => {
    return fetchData<LineupStats[]>(`/lineups/game/${gameId}`);
  };

  const getLineupsByTeamSeason = (params: { season: number; team: string; startDateRange?: string; endDateRange?: string; }): Promise<LineupStats[]> => {
    return fetchData<LineupStats[]>('/lineups/team', params);
  };

  return { getLineupStatsByGame, getLineupsByTeamSeason };
};