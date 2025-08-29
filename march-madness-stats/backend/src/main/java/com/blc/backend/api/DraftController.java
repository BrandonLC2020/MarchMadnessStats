package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.DraftPick;
import com.blc.backend.model.DraftPosition;
import com.blc.backend.model.DraftTeam;
import com.blc.backend.service.CbbApiService;

@RestController
public class DraftController implements DraftApi {

    private final CbbApiService cbbApiService;

    public DraftController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<DraftPick>> getDraftPicks(Integer year, String draftTeam, String sourceTeam, String position) {
        List<DraftPick> result = cbbApiService.getDraftPicks(year, draftTeam, sourceTeam, position).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<DraftPosition>> getDraftPositions() {
        List<DraftPosition> result = cbbApiService.getDraftPositions().collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<DraftTeam>> getDraftTeams() {
        List<DraftTeam> result = cbbApiService.getDraftTeams().collectList().block();
        return ResponseEntity.ok(result);
    }
}
