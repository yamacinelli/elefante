package com.elefante.backend.user;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.elefante.backend.setup.SetupRequest;

public interface UserService {
    UserDetails findByEmail(String email);
    Boolean anyUserExists();
    ResponseEntity<?> create(SetupRequest request);
    ResponseEntity<?> update(UserUpdateRequest request);
    ResponseEntity<?> invite(UserInviteRequest request);
}
