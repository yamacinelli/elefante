package com.elefante.backend.arptimerecordevent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArpTimeRecordEventRepository extends JpaRepository<ArpTimeRecordEventEntity, Integer> { }
