package com.elefante.backend.userdetail;

import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;

public interface UserDetailsService {
    Optional<UserDetailsEntity> save(UserDetailsEntity entity) throws DuplicateKeyException, Exception;
}
