package com.blc.backend.api;

import com.blc.backend.model.GameBoxScorePlayers;
import com.blc.backend.model.GameBoxScoreTeam;
import com.blc.backend.model.GameInfo;
import com.blc.backend.model.GameMediaInfo;
import com.blc.backend.service.CbbApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GamesController implements GamesApi {

    private final CbbApiService cbbApiService;

    public GamesController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<GameInfo>> getGames(String startDateRange, String endDateRange, String team, String conference, Integer season, String seasonType, String status, String tournament) {
        List<GameInfo> result = cbbApiService.getGames(startDateRange, endDateRange, team, conference, season, seasonType, status, tournament).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<GameBoxScoreTeam>> getGameTeams(String startDateRange, String endDateRange, String team, String conference, Integer season, String seasonType, String tournament) {
        List<GameBoxScoreTeam> result = cbbApiService.getGameTeams(startDateRange, endDateRange, team, conference, Double.valueOf(season), seasonType, tournament).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<GameBoxScorePlayers>> getGamePlayers(String startDateRange, String endDateRange, String team, String conference, Integer season, String seasonType, String tournament) {
        List<GameBoxScorePlayers> result = cbbApiService.getGamePlayers(startDateRange, endDateRange, team, conference, Double.valueOf(season), seasonType, tournament).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<GameMediaInfo>> getBroadcasts(String startDateRange, String endDateRange, String team, String conference, Integer season, String seasonType, String tournament) {
        // This endpoint doesn't exist in your service yet, so we'll return an empty list for now.
        return ResponseEntity.ok(List.of());
    }
}