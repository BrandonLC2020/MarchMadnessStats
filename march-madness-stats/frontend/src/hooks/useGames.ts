import { fetchData } from './apiHelper';
import { GameBoxScorePlayers, GameBoxScoreTeam, GameInfo, GameMediaInfo, GetGamesParams } from '../types/api';

export const useGames = () => {
  const getBroadcasts = (params: GetGamesParams): Promise<GameMediaInfo[]> => {
    return fetchData<GameMediaInfo[]>('/games/media', params);
  };

  const getGamePlayers = (params: GetGamesParams): Promise<GameBoxScorePlayers[]> => {
    return fetchData<GameBoxScorePlayers[]>('/games/players', params);
  };

  const getGameTeams = (params: GetGamesParams): Promise<GameBoxScoreTeam[]> => {
    return fetchData<GameBoxScoreTeam[]>('/games/teams', params);
  };

  const getGames = (params: GetGamesParams): Promise<GameInfo[]> => {
    return fetchData<GameInfo[]>('/games', params);
  };

  return { getBroadcasts, getGamePlayers, getGameTeams, getGames };
};