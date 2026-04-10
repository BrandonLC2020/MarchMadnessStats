package com.blc.backend.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.openapitools.jackson.nullable.JsonNullable;

import com.blc.backend.model.SystemHealth;
import com.blc.backend.service.CbbApiService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SystemController implements SystemApi {

    private final CbbApiService cbbApiService;
    private final HealthEndpoint healthEndpoint;

    public SystemController(CbbApiService cbbApiService, HealthEndpoint healthEndpoint) {
        this.cbbApiService = cbbApiService;
        this.healthEndpoint = healthEndpoint;
    }

    @Override
    public ResponseEntity<SystemHealth> getSystemHealth() {
        SystemHealth health = new SystemHealth();
        
        Status backendStatus = healthEndpoint.health().getStatus();
        health.setBackendStatus(backendStatus.getCode());
        
        health.setApiConnectionStatus(cbbApiService.getQuotaLimit() != null ? "UP" : "UNKNOWN");
        
        if (cbbApiService.getQuotaLimit() != null) {
            health.setQuotaLimit(JsonNullable.of(cbbApiService.getQuotaLimit()));
        }
        if (cbbApiService.getQuotaRemaining() != null) {
            health.setQuotaRemaining(JsonNullable.of(cbbApiService.getQuotaRemaining()));
        }
        if (cbbApiService.getQuotaReset() != null) {
            health.setQuotaReset(JsonNullable.of(cbbApiService.getQuotaReset()));
        }
        
        return ResponseEntity.ok(health);
    }
}
