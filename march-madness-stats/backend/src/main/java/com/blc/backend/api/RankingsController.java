package com.blc.backend.api;

import com.blc.backend.model.PollTeamInfo;
import com.blc.backend.service.CbbApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RankingsController implements RankingsApi {

    private final CbbApiService cbbApiService;

    public RankingsController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<PollTeamInfo>> getRankings(Integer season, String seasonType, Integer week, String pollType, String team, String conference) {
        List<PollTeamInfo> result = cbbApiService.getRankings(season, seasonType, week).collectList().block();
        return ResponseEntity.ok(result);
    }
}