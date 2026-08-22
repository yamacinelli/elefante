package com.elefante.backend.setup;

import org.springframework.http.ResponseEntity;

public interface SetupService {
    ResponseEntity<?> needsSetup();
    ResponseEntity<?> setup(SetupRequest request);
}
