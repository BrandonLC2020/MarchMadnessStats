package com.blc.backend.api;

import com.blc.backend.model.GameBoxScorePlayers;
import com.blc.backend.model.GameBoxScoreTeam;
import com.blc.backend.model.GameInfo;
import com.blc.backend.model.GameMediaInfo;
import com.blc.backend.model.GameStatus;
import com.blc.backend.model.SeasonType;
import com.blc.backend.service.CbbApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class GamesController implements GamesApi {

    private final CbbApiService cbbApiService;

    public GamesController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<GameInfo>> getGames(OffsetDateTime startDateRange, OffsetDateTime endDateRange, String team, String conference, Integer season, SeasonType seasonType, GameStatus status, String tournament) {
        // Convert OffsetDateTime to String for the service layer if needed.
        String startDateString = (startDateRange != null) ? startDateRange.toString() : null;
        String endDateString = (endDateRange != null) ? endDateRange.toString() : null;
        String seasonTypeString = (seasonType != null) ? seasonType.getValue() : null;
        String statusString = (status != null) ? status.getValue() : null;


        List<GameInfo> result = cbbApiService.getGames(startDateString, endDateString, team, conference, season, seasonTypeString, statusString, tournament).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<GameBoxScoreTeam>> getGameTeams(OffsetDateTime startDateRange, OffsetDateTime endDateRange, String team, String conference, Double season, SeasonType seasonType, String tournament) {
        String startDateString = (startDateRange != null) ? startDateRange.toString() : null;
        String endDateString = (endDateRange != null) ? endDateRange.toString() : null;
        String seasonTypeString = (seasonType != null) ? seasonType.getValue() : null;

        List<GameBoxScoreTeam> result = cbbApiService.getGameTeams(startDateString, endDateString, team, conference, season, seasonTypeString, tournament).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<GameBoxScorePlayers>> getGamePlayers(OffsetDateTime startDateRange, OffsetDateTime endDateRange, String team, String conference, Double season, SeasonType seasonType, String tournament) {
        String startDateString = (startDateRange != null) ? startDateRange.toString() : null;
        String endDateString = (endDateRange != null) ? endDateRange.toString() : null;
        String seasonTypeString = (seasonType != null) ? seasonType.getValue() : null;

        List<GameBoxScorePlayers> result = cbbApiService.getGamePlayers(startDateString, endDateString, team, conference, season, seasonTypeString, tournament).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<GameMediaInfo>> getBroadcasts(OffsetDateTime startDateRange, OffsetDateTime endDateRange, String team, String conference, Double season, SeasonType seasonType, String tournament) {
        // This endpoint doesn't exist in your CbbApiService yet, so we'll return an empty list for now.
        return ResponseEntity.ok(List.of());
    }
}