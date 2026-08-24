package com.elefante.backend.worklog;

import org.springframework.http.ResponseEntity;

public interface WorkLogService {
    ResponseEntity<?> clock(WorkLogClockRequest request);
    ResponseEntity<?> get(Integer id);
    ResponseEntity<?> list(Integer userId);
}
