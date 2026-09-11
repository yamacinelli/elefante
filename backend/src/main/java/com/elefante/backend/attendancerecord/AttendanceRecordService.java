package com.elefante.backend.attendancerecord;

import org.springframework.http.ResponseEntity;

public interface AttendanceRecordService {
    ResponseEntity<?> create(AttendanceRecordCreateRequest request);
    ResponseEntity<?> get(Integer id);
    ResponseEntity<?> list(Integer userId);
}
