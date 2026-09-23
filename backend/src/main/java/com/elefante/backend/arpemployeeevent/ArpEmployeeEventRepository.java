package com.elefante.backend.arpemployeeevent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArpEmployeeEventRepository extends JpaRepository<ArpEmployeeEventEntity, Integer> { }
