package com.elefante.backend.worklog;

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
@RequestMapping("work-log")
@RestController
public class WorkLogController {

    private final WorkLogService workLogService;

    @PostMapping
    public ResponseEntity<?> clock(@Valid @RequestBody WorkLogClockRequest request) {
        return workLogService.clock(request);
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> get(@RequestParam(name = "id") Integer id) {
        return workLogService.get(id);
    }

    @GetMapping(params = "userId")
    public ResponseEntity<?> list(@RequestParam(name = "userId") Integer userId) {
        return workLogService.get(userId);
    }
}
