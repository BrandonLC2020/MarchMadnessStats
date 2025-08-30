package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.PollTeamInfo;
import com.blc.backend.model.SeasonType;
import com.blc.backend.service.CbbApiService;

@RestController
public class RankingsController implements RankingsApi {

    private final CbbApiService cbbApiService;

    public RankingsController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<PollTeamInfo>> getRankings(Integer season, SeasonType seasonType, Integer week, String pollType, String team, String conference) {
        String seasonTypeString = (seasonType != null) ? seasonType.getValue() : null;
        
        List<PollTeamInfo> result = cbbApiService.getRankings(season, seasonTypeString, week).collectList().block();
        
        return ResponseEntity.ok(result);
    }
}