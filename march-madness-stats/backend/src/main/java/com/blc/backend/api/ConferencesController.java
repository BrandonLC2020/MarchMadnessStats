package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blc.backend.model.ConferenceHistory;
import com.blc.backend.model.ConferenceInfo;
import com.blc.backend.service.CbbApiService;

@RestController
public class ConferencesController implements ConferencesApi {

    private final CbbApiService cbbApiService;

    public ConferencesController(CbbApiService cbbApiService) {
        this.cbbApiService = cbbApiService;
    }

    @Override
    public ResponseEntity<List<ConferenceHistory>> getConferenceHistory(String conference) {
        List<ConferenceHistory> result = cbbApiService.getConferenceHistory(conference).collectList().block();
        return ResponseEntity.ok(result);
    }

    // This method was missing from the previous version, but is required by the ConferencesApi interface
    @Override
    public ResponseEntity<List<ConferenceInfo>> getConferences() {
        // This endpoint doesn't exist in your service yet, so we'll return an empty list for now.
        // You can implement getConferences in CbbApiService later if needed.
        return ResponseEntity.ok(List.of());
    }
}
