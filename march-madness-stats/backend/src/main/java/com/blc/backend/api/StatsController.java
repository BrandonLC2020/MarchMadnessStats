package com.blc.backend.api;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.PlayerSeasonShootingStats;
import com.blc.backend.model.PlayerSeasonStats;
import com.blc.backend.model.SeasonShootingStats;
import com.blc.backend.model.SeasonType;
import com.blc.backend.model.TeamSeasonStats;
import com.blc.backend.service.CbbApiService;

@RestController
public class StatsController implements StatsApi {

    private final CbbApiService cbbApiService;

    public StatsController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<PlayerSeasonShootingStats>> getPlayerSeasonShootingStats(Integer season, SeasonType seasonType, String team, String conference, OffsetDateTime startDateRange, OffsetDateTime endDateRange) {
        // The service layer doesn't currently use seasonType, startDateRange, or endDateRange for this call.
        List<PlayerSeasonShootingStats> result = cbbApiService.getPlayerSeasonShootingStats(season, team).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PlayerSeasonStats>> getPlayerSeasonStats(Double season, SeasonType seasonType, String team, String conference, OffsetDateTime startDateRange, OffsetDateTime endDateRange) {
        // The service layer doesn't currently use seasonType, conference, startDateRange, or endDateRange for this call.
        List<PlayerSeasonStats> result = cbbApiService.getPlayerSeasonStats(season.intValue(), team).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<SeasonShootingStats>> getTeamSeasonShootingStats(Integer season, SeasonType seasonType, String team, String conference, OffsetDateTime startDateRange, OffsetDateTime endDateRange) {
        // The service layer doesn't currently use seasonType, startDateRange, or endDateRange for this call.
        List<SeasonShootingStats> result = cbbApiService.getTeamSeasonShootingStats(season, team, conference).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<TeamSeasonStats>> getTeamSeasonStats(Double season, SeasonType seasonType, String team, String conference, OffsetDateTime startDateRange, OffsetDateTime endDateRange) {
        // The service layer doesn't currently use seasonType, startDateRange, or endDateRange for this call.
        List<TeamSeasonStats> result = cbbApiService.getTeamSeasonStats(season.intValue(), team, conference).collectList().block();
        return ResponseEntity.ok(result);
    }
}