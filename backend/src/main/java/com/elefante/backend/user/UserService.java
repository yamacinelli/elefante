package com.elefante.backend.user;

import java.util.Optional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails findByEmail(String email);
    Boolean anyUserExists();
    Optional<UserEntity> save(UserEntity entity) throws DuplicateKeyException, Exception;
    ResponseEntity<?> invite(InviteRequest request);
}
