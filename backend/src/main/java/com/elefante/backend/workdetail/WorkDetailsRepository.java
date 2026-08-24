package com.elefante.backend.workdetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDetailsRepository extends JpaRepository<WorkDetailsEntity, Integer> { }
