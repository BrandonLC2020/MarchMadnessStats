package com.blc.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<ConferenceHistory>> getConferenceHistory(@RequestParam(required = false) String conference) {
        List<ConferenceHistory> result = cbbApiService.getConferenceHistory(conference).collectList().block();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<ConferenceInfo>> getConferences() {
        List<ConferenceInfo> result = cbbApiService.getConferences().collectList().block();
        return ResponseEntity.ok(result);
    }
}
