package com.blc.backend.api;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.GameLines;
import com.blc.backend.model.LineProviderInfo;
import com.blc.backend.service.CbbApiService;

@RestController
public class LinesController implements LinesApi {

    private final CbbApiService cbbApiService;

    public LinesController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<GameLines>> getLines(Integer season, String team, String conference, OffsetDateTime startDateRange, OffsetDateTime endDateRange) {
        String startDateString = (startDateRange != null) ? startDateRange.toString() : null;
        String endDateString = (endDateRange != null) ? endDateRange.toString() : null;
        List<GameLines> result = cbbApiService.getLines(season, team, conference, startDateString, endDateString).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<LineProviderInfo>> getProviders() {
        List<LineProviderInfo> result = cbbApiService.getProviders().collectList().block();
        return ResponseEntity.ok(result);
    }
}