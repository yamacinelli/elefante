package com.elefante.backend.workdetail;

import org.springframework.http.ResponseEntity;

public interface WorkDetailsService {
    ResponseEntity<?> create(WorkDetailsCreateRequest request);
}
