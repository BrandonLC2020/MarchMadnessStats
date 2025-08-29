package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.TeamInfo;
import com.blc.backend.model.TeamRoster;
import com.blc.backend.service.CbbApiService;

@RestController
public class TeamsController implements TeamsApi {

    private final CbbApiService cbbApiService;

    public TeamsController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<TeamInfo>> getTeams(String conference, Integer season) {
        List<TeamInfo> result = cbbApiService.getTeams(conference, season).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<TeamRoster>> getTeamRoster(Integer season, String team) {
        List<TeamRoster> result = cbbApiService.getTeamRoster(season, team).collectList().block();
        return ResponseEntity.ok(result);
    }
}
