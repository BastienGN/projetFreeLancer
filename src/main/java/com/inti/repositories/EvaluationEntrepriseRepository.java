package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.EvaluationEntreprise;

@Repository
public interface EvaluationEntrepriseRepository extends JpaRepository<EvaluationEntreprise, Long> {

}
