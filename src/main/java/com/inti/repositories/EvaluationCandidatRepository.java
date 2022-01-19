package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.EvaluationCandidat;

@Repository
public interface EvaluationCandidatRepository extends JpaRepository<EvaluationCandidat, Long> {

}
