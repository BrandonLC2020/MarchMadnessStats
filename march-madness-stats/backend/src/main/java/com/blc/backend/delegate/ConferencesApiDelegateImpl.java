package com.blc.backend.delegate;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blc.backend.api.ConferencesApiDelegate;
import com.blc.backend.model.ConferenceInfo;

@Service
public class ConferencesApiDelegateImpl implements ConferencesApiDelegate {

    @Override
    public ResponseEntity<List<ConferenceInfo>> getConferences() {
        // TODO: Implement your logic to fetch conference infos
        System.out.println("Fetching all conference infos...");
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}