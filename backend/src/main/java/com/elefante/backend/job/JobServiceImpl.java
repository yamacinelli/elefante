package com.elefante.backend.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final JobRepository jobRepository;

    @Override
    public ResponseEntity<?> create(JobCreateRequest request) {
        try {
            JobEntity jobEntity = JobEntity
            .builder()
            .name(request.name())
            .build();
            jobRepository.save(jobEntity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e) {
            logger.error("An error occurred while creating job", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
