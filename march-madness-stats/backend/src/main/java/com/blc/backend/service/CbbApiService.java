package com.blc.backend.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.blc.backend.model.AdjustedEfficiencyInfo;
import com.blc.backend.model.ConferenceHistory;
import com.blc.backend.model.ConferenceInfo;
import com.blc.backend.model.DraftPick;
import com.blc.backend.model.DraftPosition;
import com.blc.backend.model.DraftTeam;
import com.blc.backend.model.GameBoxScorePlayers;
import com.blc.backend.model.GameBoxScoreTeam;
import com.blc.backend.model.GameInfo;
import com.blc.backend.model.GameLines;
import com.blc.backend.model.LineProviderInfo;
import com.blc.backend.model.PlayInfo;
import com.blc.backend.model.PlayTypeInfo;
import com.blc.backend.model.PlayerSeasonShootingStats;
import com.blc.backend.model.PlayerSeasonStats;
import com.blc.backend.model.PlayerSubsititution;
import com.blc.backend.model.PollTeamInfo;
import com.blc.backend.model.Recruit;
import com.blc.backend.model.SeasonShootingStats;
import com.blc.backend.model.SrsInfo;
import com.blc.backend.model.TeamInfo;
import com.blc.backend.model.TeamRoster;
import com.blc.backend.model.TeamSeasonStats;
import com.blc.backend.model.VenueInfo;

import reactor.core.publisher.Flux;

@Service
public class CbbApiService {

    private final WebClient webClient;

    @Value("${CBB_API_KEY}")
    private String cbbApiKey;

    public CbbApiService(WebClient.Builder webClientBuilder, @Value("${cbb.api.base-url}") String cbbApiBaseUrl) {
        this.webClient = webClientBuilder.baseUrl(cbbApiBaseUrl).build();
    }

    private <T> Flux<T> performGetRequest(String path, Map<String, Object> params, Class<T> responseType) {
        return this.webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path(path);
                    params.forEach((key, value) -> {
                        if (value != null) {
                            uriBuilder.queryParam(key, value);
                        }
                    });
                    return uriBuilder.build();
                })
                .header("Authorization", "Bearer " + cbbApiKey)
                .retrieve()
                .bodyToFlux(responseType);
    }

    // --- Conferences ---
    public Flux<ConferenceInfo> getConferences() {
        return performGetRequest("/conferences", Map.of(), ConferenceInfo.class);
    }

    public Flux<ConferenceHistory> getConferenceHistory(String conference) {
        Map<String, Object> params = new HashMap<>();
        params.put("conference", conference);
        return performGetRequest("/conferences/history", params, ConferenceHistory.class);
    }

    // --- Draft ---
    public Flux<DraftPick> getDraftPicks(Integer year, String draftTeam, String sourceTeam, String position) {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("draftTeam", draftTeam);
        params.put("sourceTeam", sourceTeam);
        params.put("position", position);
        return performGetRequest("/draft/picks", params, DraftPick.class);
    }

    public Flux<DraftPosition> getDraftPositions() {
        return performGetRequest("/draft/positions", Map.of(), DraftPosition.class);
    }

    public Flux<DraftTeam> getDraftTeams() {
        return performGetRequest("/draft/teams", Map.of(), DraftTeam.class);
    }

    // --- Games ---
    public Flux<GameInfo> getGames(String startDateRange, String endDateRange, String team, String conference, Integer season, String seasonType, String status, String tournament) {
        Map<String, Object> params = new HashMap<>();
        params.put("startDateRange", startDateRange);
        params.put("endDateRange", endDateRange);
        params.put("team", team);
        params.put("conference", conference);
        params.put("season", season);
        params.put("seasonType", seasonType);
        params.put("status", status);
        params.put("tournament", tournament);
        return performGetRequest("/games", params, GameInfo.class);
    }

    public Flux<GameBoxScoreTeam> getGameTeams(String startDateRange, String endDateRange, String team, String conference, Double season, String seasonType, String tournament) {
         Map<String, Object> params = new HashMap<>();
        params.put("startDateRange", startDateRange);
        params.put("endDateRange", endDateRange);
        params.put("team", team);
        params.put("conference", conference);
        params.put("season", season);
        params.put("seasonType", seasonType);
        params.put("tournament", tournament);
        return performGetRequest("/games/teams", params, GameBoxScoreTeam.class);
    }

    public Flux<GameBoxScorePlayers> getGamePlayers(String startDateRange, String endDateRange, String team, String conference, Double season, String seasonType, String tournament) {
        Map<String, Object> params = new HashMap<>();
        params.put("startDateRange", startDateRange);
        params.put("endDateRange", endDateRange);
        params.put("team", team);
        params.put("conference", conference);
        params.put("season", season);
        params.put("seasonType", seasonType);
        params.put("tournament", tournament);
        return performGetRequest("/games/players", params, GameBoxScorePlayers.class);
    }

    // --- Lines ---
    public Flux<GameLines> getLines(Integer season, String team, String conference, String startDateRange, String endDateRange) {
        Map<String, Object> params = new HashMap<>();
        params.put("season", season);
        params.put("team", team);
        params.put("conference", conference);
        params.put("startDateRange", startDateRange);
        params.put("endDateRange", endDateRange);
        return performGetRequest("/lines", params, GameLines.class);
    }

    public Flux<LineProviderInfo> getProviders() {
        return performGetRequest("/lines/providers", Map.of(), LineProviderInfo.class);
    }

    // --- Plays ---
    public Flux<PlayInfo> getPlays(Integer gameId, Boolean shootingPlaysOnly) {
        return performGetRequest("/plays/game/" + gameId, Map.of("shootingPlaysOnly", shootingPlaysOnly), PlayInfo.class);
    }

    public Flux<PlayTypeInfo> getPlayTypes() {
        return performGetRequest("/plays/types", Map.of(), PlayTypeInfo.class);
    }

    // --- Rankings ---
    public Flux<PollTeamInfo> getRankings(Integer season, String seasonType, Integer week, String pollType) {
        Map<String, Object> params = new HashMap<>();
        params.put("season", season);
        params.put("seasonType", seasonType);
        params.put("week", week);
        if (pollType != null) {
            params.put("pollType", pollType.toLowerCase());
        }
        return performGetRequest("/rankings", params, PollTeamInfo.class);
    }


    // --- Ratings ---
    public Flux<SrsInfo> getSrs(Integer season, String team, String conference) {
        Map<String, Object> params = new HashMap<>();
        params.put("season", season);
        params.put("team", team);
        params.put("conference", conference);
        return performGetRequest("/ratings/srs", params, SrsInfo.class);
    }

    public Flux<AdjustedEfficiencyInfo> getAdjustedEfficiency(Integer season, String team, String conference) {
        Map<String, Object> params = new HashMap<>();
        params.put("season", season);
        params.put("team", team);
        params.put("conference", conference);
        return performGetRequest("/ratings/adjusted", params, AdjustedEfficiencyInfo.class);
    }

    // --- Recruiting ---
    public Flux<Recruit> getRecruits(Integer year, String team, String conference, String position) {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("team", team);
        params.put("conference", conference);
        params.put("position", position);
        return performGetRequest("/recruiting/players", params, Recruit.class);
    }

    // --- Stats ---
    public Flux<TeamSeasonStats> getTeamSeasonStats(Integer season, String team, String conference) {
        Map<String, Object> params = new HashMap<>();
        params.put("season", season);
        params.put("team", team);
        params.put("conference", conference);
        return performGetRequest("/stats/team/season", params, TeamSeasonStats.class);
    }

    public Flux<SeasonShootingStats> getTeamSeasonShootingStats(Integer season, String team, String conference) {
        Map<String, Object> params = new HashMap<>();
        params.put("season", season);
        params.put("team", team);
        params.put("conference", conference);
        return performGetRequest("/stats/team/shooting/season", params, SeasonShootingStats.class);
    }

    public Flux<PlayerSeasonStats> getPlayerSeasonStats(Integer season, String team) {
        return performGetRequest("/stats/player/season", Map.of("season", season, "team", team), PlayerSeasonStats.class);
    }

    public Flux<PlayerSeasonShootingStats> getPlayerSeasonShootingStats(Integer season, String team) {
        return performGetRequest("/stats/player/shooting/season", Map.of("season", season, "team", team), PlayerSeasonShootingStats.class);
    }

    // --- Substitutions ---
    public Flux<PlayerSubsititution> getSubstitutionsByGame(Integer gameId) {
        return performGetRequest("/substitutions/game/" + gameId, Map.of(), PlayerSubsititution.class);
    }

    public Flux<PlayerSubsititution> getSubstitutionsByPlayerId(Integer playerId, Integer season) {
        return performGetRequest("/substitutions/player/" + playerId, Map.of("season", season), PlayerSubsititution.class);
    }

    public Flux<PlayerSubsititution> getSubstitutionsByTeam(Integer season, String team) {
        return performGetRequest("/substitutions/team", Map.of("season", season, "team", team), PlayerSubsititution.class);
    }

    // --- Teams ---
    public Flux<TeamInfo> getTeams(String conference, Integer season) {
        return performGetRequest("/teams", Map.of("conference", conference, "season", season), TeamInfo.class);
    }

    public Flux<TeamRoster> getTeamRoster(Integer season, String team) {
        return performGetRequest("/teams/roster", Map.of("season", season, "team", team), TeamRoster.class);
    }

    // --- Venues ---
    public Flux<VenueInfo> getVenues() {
        return performGetRequest("/venues", Map.of(), VenueInfo.class);
    }
}