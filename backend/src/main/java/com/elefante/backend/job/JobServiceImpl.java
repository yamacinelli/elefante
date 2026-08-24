package com.elefante.backend.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elefante.backend.exception.ResourceNotFoundException;

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

    @Override
    public ResponseEntity<?> get(Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(jobRepository.get(id));
        } catch(ResourceNotFoundException e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(Exception e) {
            logger.error("An error occurred while getting job id " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> list() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(jobRepository.list());
        } catch(Exception e) {
            logger.error("An error occurred while listing jobs", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
