import { fetchData } from './apiHelper';
import { DraftPick, DraftPosition, DraftTeam } from '../types/api';

export const useDraft = () => {
  const getDraftPicks = (params: { year?: number; draftTeam?: string; sourceTeam?: string; position?: string; }): Promise<DraftPick[]> => {
    return fetchData<DraftPick[]>('/draft/picks', params);
  };

  const getDraftPositions = (): Promise<DraftPosition[]> => {
    return fetchData<DraftPosition[]>('/draft/positions');
  };

  const getDraftTeams = (): Promise<DraftTeam[]> => {
    return fetchData<DraftTeam[]>('/draft/teams');
  };

  return { getDraftPicks, getDraftPositions, getDraftTeams };
};