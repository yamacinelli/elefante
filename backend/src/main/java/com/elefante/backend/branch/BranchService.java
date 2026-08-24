package com.elefante.backend.branch;

import org.springframework.http.ResponseEntity;

public interface BranchService {
    ResponseEntity<?> create(BranchCreateRequest request);
}
