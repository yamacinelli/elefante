package com.elefante.backend.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/invite")
    public ResponseEntity<?> invite(@Valid @RequestBody UserInviteRequest request) {
        return userService.invite(request);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody UserUpdateRequest request) {
        return userService.update(request);
    }
}
