package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.Recruit;
import com.blc.backend.service.CbbApiService;

@RestController
public class RecruitingController implements RecruitingApi {

    private final CbbApiService cbbApiService;

    public RecruitingController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<Recruit>> getRecruits(Integer year, String team, String conference, String position) {
        List<Recruit> result = cbbApiService.getRecruits(year, team, conference, position).collectList().block();
        return ResponseEntity.ok(result);
    }
}
