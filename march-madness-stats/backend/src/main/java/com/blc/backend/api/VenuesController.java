package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.VenueInfo;
import com.blc.backend.service.CbbApiService;

@RestController
public class VenuesController implements VenuesApi {

    private final CbbApiService cbbApiService;

    public VenuesController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<VenueInfo>> getVenues() {
        List<VenueInfo> result = cbbApiService.getVenues().collectList().block();
        return ResponseEntity.ok(result);
    }
}
