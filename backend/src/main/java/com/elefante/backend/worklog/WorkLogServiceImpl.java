package com.elefante.backend.worklog;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WorkLogServiceImpl implements WorkLogService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final WorkLogRepository workLogRepository;

    @Override
    public ResponseEntity<?> clock(WorkLogClockRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<?> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> list(Integer userId) {
        return null;
    }
}
