export interface AdjustedEfficiencyInfo {
  season: number;
  teamId: number;
  team: string;
  conference: string;
  offensiveRating: number;
  defensiveRating: number;
  netRating: number;
  rankings: AdjustedEfficiencyInfoRankings;
}

export interface AdjustedEfficiencyInfoRankings {
  net: number;
  defense: number;
  offense: number;
}

export interface ConferenceHistory {
  id: number;
  sourceId: string;
  name: string;
  abbreviation: string;
  shortName: string;
  teams: ConferenceHistoryTeamsInner[];
}

export interface ConferenceHistoryTeamsInner {
  endSeason: number | null;
  startSeason: number;
  mascot: string | null;
  school: string;
  sourceId: string;
  id: number;
}

export interface ConferenceInfo {
  id: number;
  sourceId: string;
  name: string;
  abbreviation: string;
  shortName: string;
}

export interface DraftPick {
  athleteId: number | null;
  sourceTeamId: number | null;
  sourceTeamLocation: string | null;
  sourceTeamName: string | null;
  sourceTeamLeagueAffiliation: string | null;
  sourceTeamCollegeId: number | null;
  draftTeamId: number;
  draftTeam: string;
  year: number;
  overall: number;
  round: number;
  pick: number;
  name: string;
  overallRank: number | null;
  positionRank: number | null;
  height: number | null;
  weight: number | null;
}

export interface DraftPosition {
  name: string;
  abbreviation: string;
}

export interface DraftTeam {
  id: number;
  sourceId: number;
  location: string;
  name: string;
  displayName: string;
  abbreviation: string;
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

export interface GameBoxScorePlayers {
  gameId: number;
  season: number;
  seasonLabel: string;
  seasonType: SeasonType;
  tournament: string | null;
  startDate: string;
  startTimeTbd: boolean;
  teamId: number;
  team: string;
  conference: string | null;
  teamSeed: number | null;
  opponentId: number;
  opponent: string;
  opponentConference: string | null;
  opponentSeed: number | null;
  neutralSite: boolean;
  isHome: boolean;
  conferenceGame: boolean;
  gameType: string | null;
  notes: string | null;
  gameMinutes: number | null;
  gamePace: number | null;
  players: GameBoxScorePlayersPlayersInner[];
}

export interface GameBoxScorePlayersPlayersInner {
  rebounds: TeamSeasonUnitStatsRebounds;
  freeThrows: TeamSeasonUnitStatsFieldGoals;
  threePointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  twoPointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  fieldGoals: TeamSeasonUnitStatsFieldGoals;
  offensiveReboundPct: number | null;
  freeThrowRate: number | null;
  assistsTurnoverRatio: number | null;
  gameScore: number | null;
  trueShootingPct: number | null;
  effectiveFieldGoalPct: number | null;
  netRating: number | null;
  defensiveRating: number | null;
  offensiveRating: number | null;
  usage: number | null;
  blocks: number | null;
  steals: number | null;
  assists: number | null;
  fouls: number | null;
  turnovers: number | null;
  points: number | null;
  minutes: number | null;
  ejected: boolean | null;
  starter: boolean | null;
  position: string;
  name: string;
  athleteSourceId: string;
  athleteId: number;
}

export interface GameBoxScoreTeam {
  gameId: number;
  season: number;
  seasonLabel: string;
  seasonType: SeasonType;
  tournament: string | null;
  startDate: string;
  startTimeTbd: boolean;
  teamId: number;
  team: string;
  conference: string | null;
  teamSeed: number | null;
  opponentId: number;
  opponent: string;
  opponentConference: string | null;
  opponentSeed: number | null;
  neutralSite: boolean;
  isHome: boolean;
  conferenceGame: boolean;
  gameType: string | null;
  notes: string | null;
  gameMinutes: number | null;
  pace: number | null;
  teamStats: GameBoxScoreTeamStats;
  opponentStats: GameBoxScoreTeamStats;
}

export interface GameBoxScoreTeamStats {
  fieldGoals: TeamSeasonUnitStatsFieldGoals;
  twoPointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  threePointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  freeThrows: TeamSeasonUnitStatsFieldGoals;
  rebounds: TeamSeasonUnitStatsRebounds;
  turnovers: TeamSeasonUnitStatsTurnovers;
  fouls: TeamSeasonUnitStatsFouls;
  points: GameBoxScoreTeamStatsPoints;
  fourFactors: TeamSeasonUnitStatsFourFactors;
  assists: number | null;
  blocks: number | null;
  steals: number | null;
  possessions: number | null;
  rating: number | null;
  trueShooting: number | null;
  gameScore: number | null;
}

export interface GameBoxScoreTeamStatsPoints {
  fastBreak: number | null;
  offTurnovers: number | null;
  inPaint: number | null;
  byPeriod: number[] | null;
  largestLead: number | null;
  total: number | null;
}

export interface GameInfo {
  id: number;
  sourceId: string;
  seasonLabel: string;
  season: number;
  seasonType: SeasonType;
  startDate: string;
  startTimeTbd: boolean;
  neutralSite: boolean;
  conferenceGame: boolean;
  gameType: string | null;
  tournament: string | null;
  gameNotes: string | null;
  status: GameStatus;
  attendance: number | null;
  homeTeamId: number;
  homeTeam: string;
  homeConferenceId: number | null;
  homeConference: string | null;
  homeSeed: number | null;
  homePoints: number | null;
  homePeriodPoints: number[] | null;
  homeWinner: boolean | null;
  awayTeamId: number;
  awayTeam: string;
  awayConferenceId: number | null;
  awayConference: string | null;
  awaySeed: number | null;
  awayPoints: number | null;
  awayPeriodPoints: number[] | null;
  awayWinner: boolean | null;
  excitement: number | null;
  venueId: number | null;
  venue: string | null;
  city: string | null;
  state: string | null;
}

export interface GameLineInfo {
  provider: string;
  spread: number | null;
  overUnder: number | null;
  homeMoneyline: number | null;
  awayMoneyline: number | null;
  spreadOpen: number | null;
  overUnderOpen: number | null;
}

export interface GameLines {
  gameId: number;
  season: number;
  seasonType: SeasonType;
  startDate: string;
  homeTeamId: number;
  homeTeam: string;
  homeConference: string | null;
  homeScore: number | null;
  awayTeamId: number;
  awayTeam: string;
  awayConference: string | null;
  awayScore: number | null;
  lines: GameLineInfo[];
}

export interface GameMediaInfo {
  gameId: number;
  season: number;
  seasonLabel: string;
  seasonType: SeasonType;
  tournament: string | null;
  startDate: string;
  startTimeTbd: boolean;
  homeTeamId: number;
  homeTeam: string;
  homeConference: string | null;
  awayTeamId: number;
  awayTeam: string;
  awayConference: string | null;
  neutralSite: boolean;
  conferenceGame: boolean;
  gameType: string | null;
  notes: string | null;
  broadcasts: GameMediaInfoBroadcastsInner[];
}

export interface GameMediaInfoBroadcastsInner {
  broadcastName: string;
  broadcastType: string;
}

export type GameStatus = "scheduled" | "in_progress" | "final" | "postponed" | "cancelled";

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

export interface LineupStats {
  teamId: number;
  team: string;
  conference: string;
  idHash: string;
  athletes: PlayInfoParticipantsInner[];
  totalSeconds: number;
  pace: number;
  offenseRating: number;
  defenseRating: number;
  netRating: number;
  teamStats: LineupUnitStats;
  opponentStats: LineupUnitStats;
}

export interface LineupUnitStats {
  possessions: number;
  points: number;
  blocks: number;
  assists: number;
  steals: number;
  turnovers: number;
  defensiveRebounds: number;
  offensiveRebounds: number;
  trueShooting: number;
  fieldGoals: ShootingStats;
  twoPointers: LineupUnitStatsTwoPointers;
  threePointers: ShootingStats;
  freeThrows: ShootingStats;
  fourFactors: LineupUnitStatsFourFactors;
}

export interface LineupUnitStatsFourFactors {
  freeThrowRate: number;
  offensiveReboundPct: number;
  turnoverRatio: number;
  effectiveFieldGoalPct: number;
}

export interface LineupUnitStatsTwoPointers {
  made: number;
  attempted: number;
  pct: number;
  jumpers: ShootingStats;
  layups: ShootingStats;
  dunks: ShootingStats;
  tipIns: ShootingStats;
}

export interface LineProviderInfo {
  id: number;
  name: string;
}

export interface PlayInfo {
  id: number;
  sourceId: string;
  gameId: number;
  gameSourceId: string;
  gameStartDate: string;
  season: number;
  seasonType: SeasonType;
  gameType: string;
  tournament: string | null;
  playType: string;
  isHomeTeam: boolean | null;
  teamId: number | null;
  team: string | null;
  conference: string | null;
  teamSeed: number | null;
  opponentId: number | null;
  opponent: string | null;
  opponentConference: string | null;
  opponentSeed: number | null;
  period: number;
  clock: string;
  secondsRemaining: number;
  homeScore: number;
  awayScore: number;
  homeWinProbability: number | null;
  scoringPlay: boolean | null;
  shootingPlay: boolean | null;
  scoreValue: number | null;
  wallclock: string | null;
  playText: string | null;
  participants: PlayInfoParticipantsInner[];
  onFloor: PlayInfoOnFloorInner[];
  shotInfo: ShotInfo | null;
}

export interface PlayInfoOnFloorInner {
  team: string;
  name: string;
  id: number;
}

export interface PlayInfoParticipantsInner {
  name: string;
  id: number;
}

export interface PlayerSeasonShootingStats {
  season: number;
  teamId: number;
  team: string;
  conference: string | null;
  trackedShots: number;
  assistedPct: number;
  dunks: SeasonShootingStatsDunks;
  layups: SeasonShootingStatsDunks;
  tipIns: ShotTypeBreakdown;
  twoPointJumpers: SeasonShootingStatsDunks;
  threePointJumpers: SeasonShootingStatsDunks;
  attemptsBreakdown: SeasonShootingStatsAttemptsBreakdown;
  athleteId: number;
  athleteName: string;
}

export interface PlayerSeasonStats {
  season: number;
  seasonLabel: string;
  teamId: number;
  team: string;
  conference: string | null;
  athleteId: number;
  athleteSourceId: string;
  name: string;
  position: string;
  games: number;
  starts: number;
  minutes: number;
  points: number | null;
  turnovers: number | null;
  fouls: number | null;
  assists: number | null;
  steals: number | null;
  blocks: number | null;
  usage: number | null;
  offensiveRating: number | null;
  defensiveRating: number | null;
  netRating: number | null;
  PORPAG: number | null;
  effectiveFieldGoalPct: number | null;
  trueShootingPct: number | null;
  assistsTurnoverRatio: number | null;
  freeThrowRate: number | null;
  offensiveReboundPct: number | null;
  fieldGoals: TeamSeasonUnitStatsFieldGoals;
  twoPointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  threePointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  freeThrows: TeamSeasonUnitStatsFieldGoals;
  rebounds: TeamSeasonUnitStatsRebounds;
  winShares: PlayerSeasonStatsWinShares;
}

export interface PlayerSeasonStatsWinShares {
  totalPer40: number | null;
  total: number | null;
  defensive: number | null;
  offensive: number | null;
}

export interface PlayerSubsititution {
  gameId: number;
  startDate: string;
  teamId: number;
  team: string;
  conference: string | null;
  athleteId: number;
  athlete: string;
  position: string | null;
  opponentId: number;
  opponent: string;
  opponentConference: string | null;
  subIn: PlayerSubsititutionSubIn;
  subOut: PlayerSubsititutionSubIn;
}

export interface PlayerSubsititutionSubIn {
  opponentPoints: number;
  teamPoints: number;
  secondsRemaining: number;
  period: number;
}

export interface PlayTypeInfo {
  id: number;
  name: string;
}

export interface PollTeamInfo {
  season: number;
  seasonType: SeasonType;
  week: number;
  pollDate: string | null;
  pollType: string;
  teamId: number;
  team: string;
  conference: string | null;
  ranking: number | null;
  points: number | null;
  firstPlaceVotes: number | null;
}

export interface Recruit {
  id: number;
  sourceId: string | null;
  position: string | null;
  schoolId: number | null;
  school: string | null;
  hometown: RecruitHometown | null;
  committedTo: RecruitCommittedTo | null;
  athleteId: number | null;
  year: number;
  name: string;
  heightInches: number | null;
  weightPounds: number | null;
  stars: number;
  rating: number;
  ranking: number | null;
}

export interface RecruitCommittedTo {
  conference: string | null;
  name: string | null;
  id: number | null;
}

export interface RecruitHometown {
  countyFips: string | null;
  longitude: number | null;
  latitude: number | null;
  country: string | null;
  state: string | null;
  city: string | null;
}

export interface SeasonShootingStats {
  season: number;
  teamId: number;
  team: string;
  conference: string | null;
  trackedShots: number;
  assistedPct: number;
  dunks: SeasonShootingStatsDunks;
  layups: SeasonShootingStatsDunks;
  tipIns: ShotTypeBreakdown;
  twoPointJumpers: SeasonShootingStatsDunks;
  threePointJumpers: SeasonShootingStatsDunks;
  attemptsBreakdown: SeasonShootingStatsAttemptsBreakdown;
}

export interface SeasonShootingStatsAttemptsBreakdown {
  threePointJumpers: number;
  twoPointJumpers: number;
  tipIns: number;
  layups: number;
  dunks: number;
}

export interface SeasonShootingStatsDunks {
  made: number;
  attempted: number;
  pct: number;
  assistedPct: number;
  assisted: number;
}

export type SeasonType = "postseason" | "preseason" | "regular";

export interface ShootingStats {
  made: number;
  attempted: number;
  pct: number;
}

export interface ShotInfo {
  shooter: ShotInfoShooter;
  made: boolean;
  range: "rim" | "jumper" | "three_pointer" | "free_throw";
  assisted: boolean;
  assistedBy: ShotInfoShooter;
  location: ShotInfoLocation;
}

export interface ShotInfoLocation {
  y: number | null;
  x: number | null;
}

export interface ShotInfoShooter {
  name: string | null;
  id: number | null;
}

export interface ShotTypeBreakdown {
  made: number;
  attempted: number;
  pct: number;
}

export interface SrsInfo {
  season: number;
  teamId: number;
  team: string;
  conference: string;
  rating: number;
}

export interface Team {
  id: number;
  school: string;
  mascot: string;
  abbreviation: string;
  conference: string;
}

export interface TeamInfo {
  id: number;
  sourceId: string;
  school: string;
  mascot: string | null;
  abbreviation: string | null;
  displayName: string | null;
  shortDisplayName: string | null;
  primaryColor: string | null;
  secondaryColor: string | null;
  currentVenueId: number | null;
  currentVenue: string | null;
  currentCity: string | null;
  currentState: string | null;
  conferenceId: number | null;
  conference: string | null;
}

export interface TeamRoster {
  teamId: number;
  teamSourceId: string;
  team: string;
  conference: string | null;
  season: number;
  players: TeamRosterPlayer[];
}

export interface TeamRosterPlayer {
  id: number;
  sourceId: string;
  name: string;
  firstName: string | null;
  lastName: string | null;
  jersey: string | null;
  position: string | null;
  height: number | null;
  weight: number | null;
  hometown: TeamRosterPlayerHometown;
  dateOfBirth: string | null;
  startSeason: number;
  endSeason: number;
}

export interface TeamRosterPlayerHometown {
  countyFips: string | null;
  longitude: number | null;
  latitude: number | null;
  country: string | null;
  state: string | null;
  city: string | null;
}

export interface TeamSeasonStats {
  season: number;
  seasonLabel: string;
  teamId: number;
  team: string;
  conference: string | null;
  games: number;
  wins: number;
  losses: number;
  totalMinutes: number | null;
  pace: number | null;
  teamStats: TeamSeasonUnitStats;
  opponentStats: TeamSeasonUnitStats;
}

export interface TeamSeasonUnitStats {
  fieldGoals: TeamSeasonUnitStatsFieldGoals;
  twoPointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  threePointFieldGoals: TeamSeasonUnitStatsFieldGoals;
  freeThrows: TeamSeasonUnitStatsFieldGoals;
  rebounds: TeamSeasonUnitStatsRebounds;
  turnovers: TeamSeasonUnitStatsTurnovers;
  fouls: TeamSeasonUnitStatsFouls;
  points: TeamSeasonUnitStatsPoints;
  fourFactors: TeamSeasonUnitStatsFourFactors;
  assists: number | null;
  blocks: number | null;
  steals: number | null;
  possessions: number | null;
  rating: number | null;
  trueShooting: number | null;
}

export interface TeamSeasonUnitStatsFieldGoals {
  pct: number | null;
  attempted: number | null;
  made: number | null;
}

export interface TeamSeasonUnitStatsFouls {
  flagrant: number | null;
  technical: number | null;
  total: number | null;
}

export interface TeamSeasonUnitStatsFourFactors {
  freeThrowRate: number | null;
  offensiveReboundPct: number | null;
  turnoverRatio: number | null;
  effectiveFieldGoalPct: number | null;
}

export interface TeamSeasonUnitStatsPoints {
  fastBreak: number | null;
  offTurnovers: number | null;
  inPaint: number | null;
  total: number | null;
}

export interface TeamSeasonUnitStatsRebounds {
  total: number | null;
  defensive: number | null;
  offensive: number | null;
}

export interface TeamSeasonUnitStatsTurnovers {
  teamTotal: number | null;
  total: number | null;
}

export interface VenueInfo {
  id: number;
  sourceId: string | null;
  name: string;
  city: string | null;
  state: string | null;
  country: string | null;
}