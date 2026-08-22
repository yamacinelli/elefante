package com.elefante.backend.authentication;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    String extractUsername(String token);
    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);
    Boolean isTokenValid(String token, UserDetails userDetails);
    ResponseEntity<?> signIn(SignInRequest request);
}
