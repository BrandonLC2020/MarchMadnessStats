// A few example types to get you started.
// You would continue to flesh these out based on your models.

export interface Conference {
  id: number;
  name: string;
  abbreviation: string;
  shortName?: string;
  teams?: Team[];
}

export interface Team {
  id: number;
  school: string;
  mascot: string;
  abbreviation: string;
  conference: string;
}

export interface Game {
  id: number;
  season: number;
  homeTeam: string;
  awayTeam: string;
  homePoints: number;
  awayPoints: number;
  startDate: string;
}

// You can create more specific types for request parameters
export interface GetGamesParams {
  startDateRange?: string;
  endDateRange?: string;
  team?: string;
  conference?: string;
  season?: number;
  seasonType?: string;
  status?: string;
  tournament?: string;
}