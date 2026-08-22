package com.elefante.backend.user;

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

import com.elefante.backend.userdetail.UserDetailsEntity;
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

    @Override
    public Optional<UserEntity> save(UserEntity entity) throws DuplicateKeyException, Exception {
        return Optional.ofNullable(userRepository.save(entity));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity<?> invite(InviteRequest request) {
        try {
            UserEntity userEntity = UserEntity
                .builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.tmpPassword()))
                .role(RoleEnum.valueOf(request.role().toUpperCase()))
                .build();
            userEntity = save(userEntity).orElseThrow();

            UserDetailsEntity userDetailsEntity = UserDetailsEntity
                .builder()
                .name(request.name())
                .lastName(request.lastName())
                .identificationNumber(request.identificationNumber())
                .userId(userEntity.getId())
                .build();
            userDetailsService.save(userDetailsEntity);

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
