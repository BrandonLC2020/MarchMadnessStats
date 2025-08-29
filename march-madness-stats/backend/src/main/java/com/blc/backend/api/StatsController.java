package com.blc.backend.api;

import com.blc.backend.model.PlayerSeasonShootingStats;
import com.blc.backend.model.PlayerSeasonStats;
import com.blc.backend.model.SeasonShootingStats;
import com.blc.backend.model.TeamSeasonStats;
import com.blc.backend.service.CbbApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StatsController implements StatsApi {

    private final CbbApiService cbbApiService;

    public StatsController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<TeamSeasonStats>> getTeamSeasonStats(Double season, String seasonType, String team, String conference, String startDateRange, String endDateRange) {
        List<TeamSeasonStats> result = cbbApiService.getTeamSeasonStats(season != null ? season.intValue() : null, team, conference).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<SeasonShootingStats>> getTeamSeasonShootingStats(Integer season, String seasonType, String team, String conference, String startDateRange, String endDateRange) {
        List<SeasonShootingStats> result = cbbApiService.getTeamSeasonShootingStats(season, team, conference).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PlayerSeasonStats>> getPlayerSeasonStats(Double season, String seasonType, String team, String conference, String startDateRange, String endDateRange) {
        List<PlayerSeasonStats> result = cbbApiService.getPlayerSeasonStats(season.intValue(), team).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PlayerSeasonShootingStats>> getPlayerSeasonShootingStats(Integer season, String seasonType, String team, String conference, String startDateRange, String endDateRange) {
        List<PlayerSeasonShootingStats> result = cbbApiService.getPlayerSeasonShootingStats(season, team).collectList().block();
        return ResponseEntity.ok(result);
    }
}