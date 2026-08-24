package com.elefante.backend.branch;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BranchServiceImpl implements BranchService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final BranchRepository branchRepository;

    private Optional<BranchEntity> create(String name, String registrationNumber) throws DuplicateKeyException, Exception {
        BranchEntity branchEntity = BranchEntity
            .builder()
            .name(name)
            .registrationNumber(registrationNumber)
            .build();
        return Optional.ofNullable(branchRepository.save(branchEntity));
    }

    @Override
    public ResponseEntity<?> create(BranchCreateRequest request) {
        try {
            create(request.name(), request.registrationNumber());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e) {
            logger.error("An error occurred creating branch", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
