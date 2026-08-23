package com.elefante.backend.userdetail;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elefante.backend.user.UserInviteRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public Optional<UserDetailsEntity> create(Integer userId, UserInviteRequest request) {
        UserDetailsEntity userDetailsEntity = UserDetailsEntity
            .builder()
            .name(request.name())
            .lastName(request.lastName())
            .identificationNumber(request.identificationNumber())
            .userId(userId)
            .build();
        return Optional.ofNullable(userDetailsRepository.save(userDetailsEntity));
    }
}
