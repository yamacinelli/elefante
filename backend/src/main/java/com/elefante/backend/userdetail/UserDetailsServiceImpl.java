package com.elefante.backend.userdetail;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public Optional<UserDetailsEntity> save(UserDetailsEntity entity) {
        return Optional.ofNullable(userDetailsRepository.save(entity));
    }
}
