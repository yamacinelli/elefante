package com.elefante.backend.job;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("job")
@RestController
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody JobCreateRequest request) {
        return jobService.create(request);
    }
}
