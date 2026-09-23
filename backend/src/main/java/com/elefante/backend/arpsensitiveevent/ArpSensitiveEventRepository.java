package com.elefante.backend.arpsensitiveevent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArpSensitiveEventRepository extends JpaRepository<ArpSensitiveEventEntity, Integer> { }
