package com.blc.backend.api;

import com.blc.backend.model.GameLines;
import com.blc.backend.model.LineProviderInfo;
import com.blc.backend.service.CbbApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LinesController implements LinesApi {

    private final CbbApiService cbbApiService;

    public LinesController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<GameLines>> getLines(Integer season, String team, String conference, String startDateRange, String endDateRange) {
        List<GameLines> result = cbbApiService.getLines(season, team, conference, startDateRange, endDateRange).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<LineProviderInfo>> getProviders() {
        List<LineProviderInfo> result = cbbApiService.getProviders().collectList().block();
        return ResponseEntity.ok(result);
    }
}
