package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.EvaluationCandidat;
import com.inti.entities.Utilisateur;

@Repository
public interface EvaluationCandidatRepository extends JpaRepository<EvaluationCandidat, Long> {
	final String commandeSQL="SELECT `note` FROM `evaluation_candidat` where `username_freelancer` =?1";
	@Query(
			value=commandeSQL,
			nativeQuery = true
	)
	List<Double> fonction(String username);
}
