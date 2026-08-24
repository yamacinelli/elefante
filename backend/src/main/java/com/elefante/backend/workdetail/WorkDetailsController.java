package com.elefante.backend.workdetail;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("work-details")
@RestController
public class WorkDetailsController {

    private final WorkDetailsService workDetailsService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody WorkDetailsCreateRequest request) {
        return workDetailsService.create(request);
    }
}
