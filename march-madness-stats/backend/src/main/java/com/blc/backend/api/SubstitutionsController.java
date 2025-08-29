package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.PlayerSubsititution;
import com.blc.backend.service.CbbApiService;

@RestController
public class SubstitutionsController implements SubstitutionsApi {

    private final CbbApiService cbbApiService;

    public SubstitutionsController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<PlayerSubsititution>> getSubstitutionsByGame(Integer gameId) {
        List<PlayerSubsititution> result = cbbApiService.getSubstitutionsByGame(gameId).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PlayerSubsititution>> getSubstitutionsByPlayerId(Integer playerId, Integer season) {
        List<PlayerSubsititution> result = cbbApiService.getSubstitutionsByPlayerId(playerId, season).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PlayerSubsititution>> getSubstitutionsByTeam(Integer season, String team) {
        List<PlayerSubsititution> result = cbbApiService.getSubstitutionsByTeam(season, team).collectList().block();
        return ResponseEntity.ok(result);
    }
}
