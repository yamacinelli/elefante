package com.elefante.backend.jobdetail;

import org.springframework.http.ResponseEntity;

public interface JobDetailService {
    ResponseEntity<?> create(JobDetailCreateRequest request);
}
