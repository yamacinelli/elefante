package com.elefante.backend.configuration.security;

import java.io.IOException;
import java.util.Objects;

import org.jspecify.annotations.NonNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.elefante.backend.authentication.AuthenticationService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            final Cookie tokenCookie = WebUtils.getCookie(request, "token");

            if (Objects.nonNull(tokenCookie)) {
                final String token = tokenCookie.getValue();

                if (Objects.nonNull(token)) {
                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    String username = authenticationService.extractUsername(token);

                    if (Objects.isNull(authentication) && Objects.nonNull(username)) {
                        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                        if (authenticationService.isTokenValid(token, userDetails)) {
                            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                            );

                            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                        }
                    }
                }
            }
        } catch(Exception exception) {
            logger.error("Filter exception: " + exception.getMessage(), exception);
        }

        filterChain.doFilter(request, response);
    }
}
