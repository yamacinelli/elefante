package com.elefante.backend.authentication;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.elefante.backend.configuration.security.JwtConfiguration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtConfiguration jwtConfiguration;

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(jwtConfiguration.getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Check if usernames are the same
     * @param token
     * @param username
     * @return {@code true} if the provided references is equals
     * otherwise {@code false}
     */
    private Boolean isTokenUsernameEquals(String token, String username) {
        return extractUsername(token).equals(username);
    }

    private Date extractExpirationTime(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Check if expiration time from token is valid
     * @param token
     * @return {@code true} if the provided reference is after <b>now</b>
     * otherwise {@code false}
     */
    private Boolean isTokenNonExpired(String token) {
        return extractExpirationTime(token).after(new Date());
    }

    @Override
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtConfiguration.getJwtExpirationTime()))
                .signWith(jwtConfiguration.getSigningKey(), Jwts.SIG.HS512)
                .compact();
    }

    @Override
    public Boolean isTokenValid(String token, UserDetails userDetails) {
        return isTokenUsernameEquals(token, userDetails.getUsername()) && isTokenNonExpired(token);
    }
}
