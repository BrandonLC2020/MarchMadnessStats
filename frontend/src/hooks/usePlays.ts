import { fetchData } from './apiHelper';
import { PlayInfo, PlayTypeInfo } from '../types/api';

export const usePlays = () => {
  const getPlayTypes = (): Promise<PlayTypeInfo[]> => {
    return fetchData<PlayTypeInfo[]>('/plays/types');
  };

  const getPlays = (gameId: number, shootingPlaysOnly?: boolean): Promise<PlayInfo[]> => {
    return fetchData<PlayInfo[]>(`/plays/game/${gameId}`, { shootingPlaysOnly });
  };

  const getPlaysByDate = (date: string, shootingPlaysOnly?: boolean): Promise<PlayInfo[]> => {
    return fetchData<PlayInfo[]>('/plays/date', { date, shootingPlaysOnly });
  };

  const getPlaysByPlayerId = (playerId: number, season: number, shootingPlaysOnly?: boolean): Promise<PlayInfo[]> => {
    return fetchData<PlayInfo[]>(`/plays/player/${playerId}`, { season, shootingPlaysOnly });
  };

  const getPlaysByTeam = (season: number, team: string, shootingPlaysOnly?: boolean): Promise<PlayInfo[]> => {
    return fetchData<PlayInfo[]>('/plays/team', { season, team, shootingPlaysOnly });
  };

  const getPlaysByTournament = (tournament: string, season: number, shootingPlaysOnly?: boolean): Promise<PlayInfo[]> => {
    return fetchData<PlayInfo[]>('/plays/tournament', { tournament, season, shootingPlaysOnly });
  };

  return { getPlayTypes, getPlays, getPlaysByDate, getPlaysByPlayerId, getPlaysByTeam, getPlaysByTournament };
};