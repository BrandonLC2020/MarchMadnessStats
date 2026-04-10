import { fetchData } from './apiHelper';
import { PlayerSubsititution } from '../types/api';

export const useSubstitutions = () => {
  const getSubstitutionsByGame = (gameId: number): Promise<PlayerSubsititution[]> => {
    return fetchData<PlayerSubsititution[]>(`/substitutions/game/${gameId}`);
  };

  const getSubstitutionsByPlayerId = (playerId: number, season: number): Promise<PlayerSubsititution[]> => {
    return fetchData<PlayerSubsititution[]>(`/substitutions/player/${playerId}`, { season });
  };

  const getSubstitutionsByTeam = (season: number, team: string): Promise<PlayerSubsititution[]> => {
    return fetchData<PlayerSubsititution[]>('/substitutions/team', { season, team });
  };

  return { getSubstitutionsByGame, getSubstitutionsByPlayerId, getSubstitutionsByTeam };
};