package com.elefante.backend.userdetail;

import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;

import com.elefante.backend.user.UserInviteRequest;

public interface UserDetailsService {
    Optional<UserDetailsEntity> create(Integer userId, UserInviteRequest request) throws DuplicateKeyException, Exception;
}
