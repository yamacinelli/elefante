package com.elefante.backend.workdetail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elefante.backend.util.ContractTypeEnum;
import com.elefante.backend.util.WorkModelEnum;

import lombok.RequiredArgsConstructor;

import tools.jackson.databind.ObjectMapper;

@RequiredArgsConstructor
@Service
public class WorkDetailsServiceImpl implements WorkDetailsService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final WorkDetailsRepository workDetailsRepository;

    @Override
    public ResponseEntity<?> create(WorkDetailsCreateRequest request) {
        try {
            Schedule schedule = objectMapper.convertValue(request.schedule(), Schedule.class);
            WorkDetailsEntity workDetailsEntity = WorkDetailsEntity
                .builder()
                .workModel(WorkModelEnum.valueOf(request.workModel().toUpperCase()))
                .contractType(ContractTypeEnum.valueOf(request.contractType().toUpperCase()))
                .schedule(schedule)
                .jobId(request.jobId())
                .branchId(request.branchId())
                .userId(request.userId())
                .build();
            workDetailsRepository.save(workDetailsEntity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e) {
            logger.error("An error occurred while creating work details for user id " + request.userId(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
