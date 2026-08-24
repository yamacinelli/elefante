package com.elefante.backend.job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer> {

    @Query("SELECT new com.elefante.backend.job.JobResponse(j.id, j.name, j.isEnabled) FROM JobEntity j WHERE j.id = :id")
    JobResponse get(@Param("id") Integer id);

    @Query("SELECT new com.elefante.backend.job.JobResponse(j.id, j.name, j.isEnabled) FROM JobEntity j")
    List<JobResponse> list();
}
