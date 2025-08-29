package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.AdjustedEfficiencyInfo;
import com.blc.backend.model.SrsInfo;
import com.blc.backend.service.CbbApiService;

@RestController
public class RatingsController implements RatingsApi {

    private final CbbApiService cbbApiService;

    public RatingsController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<SrsInfo>> getSrs(Integer season, String team, String conference) {
        List<SrsInfo> result = cbbApiService.getSrs(season, team, conference).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<AdjustedEfficiencyInfo>> getAdjustedEfficiency(Integer season, String team, String conference) {
        List<AdjustedEfficiencyInfo> result = cbbApiService.getAdjustedEfficiency(season, team, conference).collectList().block();
        return ResponseEntity.ok(result);
    }
}
