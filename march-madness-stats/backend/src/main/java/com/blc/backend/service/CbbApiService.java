package com.blc.backend.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.blc.backend.model.ConferenceHistory;
import com.blc.backend.model.GameBoxScorePlayers;
import com.blc.backend.model.GameBoxScoreTeam;
import com.blc.backend.model.GameInfo;
import com.blc.backend.model.PlayerSeasonShootingStats;
import com.blc.backend.model.PlayerSeasonStats;
import com.blc.backend.model.PollTeamInfo;
import com.blc.backend.model.SeasonShootingStats;
import com.blc.backend.model.TeamInfo;
import com.blc.backend.model.TeamRoster;
import com.blc.backend.model.TeamSeasonStats;

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
    public Flux<ConferenceHistory> getConferenceHistory(String conference) {
        return performGetRequest("/conferences/history", Map.of("conference", conference), ConferenceHistory.class);
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

    // --- Rankings ---
    public Flux<PollTeamInfo> getRankings(Integer season, String seasonType, Integer week) {
        return performGetRequest("/rankings", Map.of("season", season, "seasonType", seasonType, "week", week, "pollType", "AP"), PollTeamInfo.class);
    }

    // --- Stats ---
    public Flux<TeamSeasonStats> getTeamSeasonStats(Integer season, String team, String conference) {
        return performGetRequest("/stats/team/season", Map.of("season", season, "team", team, "conference", conference), TeamSeasonStats.class);
    }

    public Flux<SeasonShootingStats> getTeamSeasonShootingStats(Integer season, String team, String conference) {
        return performGetRequest("/stats/team/shooting/season", Map.of("season", season, "team", team, "conference", conference), SeasonShootingStats.class);
    }

    public Flux<PlayerSeasonStats> getPlayerSeasonStats(Integer season, String team) {
        return performGetRequest("/stats/player/season", Map.of("season", season, "team", team), PlayerSeasonStats.class);
    }

    public Flux<PlayerSeasonShootingStats> getPlayerSeasonShootingStats(Integer season, String team) {
        return performGetRequest("/stats/player/shooting/season", Map.of("season", season, "team", team), PlayerSeasonShootingStats.class);
    }

    // --- Teams ---
    public Flux<TeamInfo> getTeams(String conference, Integer season) {
        return performGetRequest("/teams", Map.of("conference", conference, "season", season), TeamInfo.class);
    }

    public Flux<TeamRoster> getTeamRoster(Integer season, String team) {
        return performGetRequest("/teams/roster", Map.of("season", season, "team", team), TeamRoster.class);
    }
}
