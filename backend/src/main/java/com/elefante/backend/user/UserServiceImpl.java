package com.elefante.backend.user;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.elefante.backend.exception.ResourceNotFoundException;
import com.elefante.backend.setup.SetupRequest;
import com.elefante.backend.userdetail.UserDetailsService;
import com.elefante.backend.util.RoleEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    private final UserRepository userRepository;

    @Override
    public UserDetails findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
    }

    @Override
    public Boolean anyUserExists() {
        return userRepository.existsBy();
    }

    private Optional<UserEntity> create(String email, String password, String role) throws DuplicateKeyException, Exception {
        UserEntity userEntity = UserEntity
            .builder()
            .email(email)
            .password(passwordEncoder.encode(password))
            .role(RoleEnum.valueOf(role))
            .build();
        return Optional.ofNullable(userRepository.save(userEntity));
    }

    private Optional<UserEntity> update(Integer id, String email, String password, String role) throws DuplicateKeyException, Exception {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        if (!Objects.equals(email, userEntity.getEmail())) userEntity.setEmail(email);
        if (StringUtils.hasText(password)) userEntity.setPassword(passwordEncoder.encode(password));
        if (StringUtils.hasText(role) && !Objects.equals(RoleEnum.valueOf(role), userEntity.getRole())) userEntity.setRole(RoleEnum.valueOf(role));
        return Optional.ofNullable(userRepository.save(userEntity));
    }

    @Override
    public ResponseEntity<?> create(SetupRequest request) {
        try {
            create(request.email(), request.password(), RoleEnum.ADMIN.name());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch(ResourceNotFoundException e) {
           logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(Exception e) {
            logger.error("An error occurred while setup", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> update(UserUpdateRequest request) {
        try {
            update(request.id(), request.email(), request.password(), request.role());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch(ResourceNotFoundException e) {
           logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(DataIntegrityViolationException e) {
            logger.error("An account already exists with this email", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(Exception e) {
            logger.error("An error occurred while updating user for " + request.id(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity<?> invite(UserInviteRequest request) {
        try {
            UserEntity userEntity = create(request.email(), request.tmpPassword(), request.role()).orElseThrow();
            userDetailsService.create(userEntity.getId(), request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(DataIntegrityViolationException e) {
            logger.error("An account already exists with this email or identification number", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(Exception e) {
            logger.error("An error occurred while creating invited user for " + request.email(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
