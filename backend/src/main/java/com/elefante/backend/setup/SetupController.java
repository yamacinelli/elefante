package com.elefante.backend.setup;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("setup")
@RestController
public class SetupController {

    private final SetupService setupService;

    @GetMapping
    public ResponseEntity<?> needsSetup() {
        return setupService.needsSetup();
    }

    @PostMapping
    public ResponseEntity<?> setup(@Valid @RequestBody SetupRequest request) {
        return setupService.setup(request);
    }
}
