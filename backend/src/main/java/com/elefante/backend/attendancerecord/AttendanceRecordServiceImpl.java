package com.elefante.backend.attendancerecord;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AttendanceRecordServiceImpl implements AttendanceRecordService {

    protected final Log logger = LogFactory.getLog(getClass());

    private final AttendanceRecordRepository attendanceRecordRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity<?> create(AttendanceRecordCreateRequest request) {
        try {
            AttendanceRecordEntity attendanceRecordEntity = AttendanceRecordEntity
                .builder()
                .coordinate(request.coordinate())
                .employeeId(request.employeeId())
                .build();
            attendanceRecordRepository.save(attendanceRecordEntity);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> get(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> list(Integer userId) {
        return null;
    }
}
