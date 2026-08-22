package com.elefante.backend.setup;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elefante.backend.user.UserEntity;
import com.elefante.backend.user.UserService;
import com.elefante.backend.util.RoleEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SetupServiceImpl implements SetupService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final UserService userService;

    @Override
    public ResponseEntity<?> needsSetup() {
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("needsSetup", userService.anyUserExists()));
    }

    @Override
    public ResponseEntity<?> setup(SetupRequest request) {
        if (userService.anyUserExists()) {
            try {
                UserEntity userEntity = UserEntity
                    .builder()
                    .email(request.email())
                    .password(request.password())
                    .role(RoleEnum.ADMIN)
                    .isFirstAccess(Boolean.FALSE)
                    .build();
                userService.save(userEntity);

                return ResponseEntity.status(HttpStatus.CREATED).build();
            } catch (Exception e) {
                logger.error("An error occurred while setup", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
