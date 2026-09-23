package com.elefante.backend.arpevent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArpEventRepository extends JpaRepository<ArpEventEntity, Integer> { }
