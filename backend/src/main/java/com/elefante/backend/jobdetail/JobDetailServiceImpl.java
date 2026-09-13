package com.elefante.backend.jobdetail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import tools.jackson.databind.ObjectMapper;

@RequiredArgsConstructor
@Service
public class JobDetailServiceImpl implements JobDetailService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final JobDetailRepository jobDetailRepository;

    @Override
    public ResponseEntity<?> create(JobDetailCreateRequest request) {
        try {
            Schedule schedule = objectMapper.convertValue(request.schedule(), Schedule.class);
            JobDetailEntity workDetailsEntity = JobDetailEntity
                .builder()
                .workModel(JobModelEnum.valueOf(request.workModel().toUpperCase()))
                .contractType(ContractTypeEnum.valueOf(request.contractType().toUpperCase()))
                .schedule(schedule)
                .employeeId(request.employeeId())
                .build();
            jobDetailRepository.save(workDetailsEntity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e) {
            logger.error("An error occurred while creating work details for user id " + request.employeeId(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
