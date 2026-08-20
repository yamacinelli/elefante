package com.elefante.backend.configuration.security;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import jakarta.annotation.PostConstruct;

import lombok.Getter;

@Getter
@Configuration
public class JwtConfiguration {

    @Value("${application.security.jwt.secret-key}")
    private String jwtSecretKey;

    @Value("${application.security.jwt.expiration-time}")
    private Long jwtExpirationTime;

    private SecretKey signingKey;

    @PostConstruct
    public void init() {
        byte[] decodedKey = Decoders.BASE64.decode(jwtSecretKey);
        this.signingKey = Keys.hmacShaKeyFor(decodedKey);
    }
}
