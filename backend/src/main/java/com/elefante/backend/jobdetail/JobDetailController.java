package com.elefante.backend.jobdetail;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("job-detail")
@RestController
public class JobDetailController {

    private final JobDetailService jobDetailService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody JobDetailCreateRequest request) {
        return jobDetailService.create(request);
    }
}
