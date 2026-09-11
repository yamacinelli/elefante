package com.elefante.backend.attendancerecord;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("attendance-record")
@RestController
public class AttendanceRecordController {

    private final AttendanceRecordService attendanceRecordService;

    @PostMapping
    public ResponseEntity<?> clock(@Valid @RequestBody AttendanceRecordCreateRequest request) {
        return attendanceRecordService.create(request);
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam(name = "id") Integer id) {
        return attendanceRecordService.get(id);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<?> list(@RequestParam(name = "userId") Integer userId) {
        return attendanceRecordService.get(userId);
    }
}
