package com.blc.backend.api;

import com.blc.backend.model.PlayInfo;
import com.blc.backend.model.PlayTypeInfo;
import com.blc.backend.service.CbbApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PlaysController implements PlaysApi {

    private final CbbApiService cbbApiService;

    public PlaysController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<PlayInfo>> getPlays(Integer gameId, Boolean shootingPlaysOnly) {
        List<PlayInfo> result = cbbApiService.getPlays(gameId, shootingPlaysOnly).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PlayTypeInfo>> getPlayTypes() {
        List<PlayTypeInfo> result = cbbApiService.getPlayTypes().collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PlayInfo>> getPlaysByDate(String date, Boolean shootingPlaysOnly) {
        // This endpoint doesn't exist in your service yet, so we'll return an empty list for now.
        return ResponseEntity.ok(List.of());
    }

    @Override
    public ResponseEntity<List<PlayInfo>> getPlaysByPlayerId(Integer playerId, Integer season, Boolean shootingPlaysOnly) {
        // This endpoint doesn't exist in your service yet, so we'll return an empty list for now.
        return ResponseEntity.ok(List.of());
    }

    @Override
    public ResponseEntity<List<PlayInfo>> getPlaysByTeam(Integer season, String team, Boolean shootingPlaysOnly) {
        // This endpoint doesn't exist in your service yet, so we'll return an empty list for now.
        return ResponseEntity.ok(List.of());
    }

    @Override
    public ResponseEntity<List<PlayInfo>> getPlaysByTournament(String tournament, Double season, Boolean shootingPlaysOnly) {
        // This endpoint doesn't exist in your service yet, so we'll return an empty list for now.
        return ResponseEntity.ok(List.of());
    }
}