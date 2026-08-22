package com.elefante.backend.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("auth")
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
