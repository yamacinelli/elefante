package com.elefante.backend.authentication;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.elefante.backend.configuration.security.JwtConfiguration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final JwtConfiguration jwtConfiguration;

    private final AuthenticationManager authenticationManager;

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

    @Override
    public ResponseEntity<?> signIn(SignInRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
            );
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return ResponseEntity.ok(Map.of("token", generateToken(null, userDetails)));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (DisabledException | LockedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (Exception e) {
            logger.error("An error occurred during sign-in for "+ request.email(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
