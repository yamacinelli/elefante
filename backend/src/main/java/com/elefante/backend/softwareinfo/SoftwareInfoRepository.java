package com.elefante.backend.softwareinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareInfoRepository extends JpaRepository<SoftwareInfoEntity, Integer> { }
