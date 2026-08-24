package com.elefante.backend.job;

import org.springframework.http.ResponseEntity;

public interface JobService {
    ResponseEntity<?> create(JobCreateRequest request);
    ResponseEntity<?> get(Integer id);
    ResponseEntity<?> list();
}
