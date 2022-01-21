package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Candidature;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
	
	//Trouver toutes les candidatures à partir d'un nom de freelancer
		final String commande2SQL="SELECT * FROM candidature WHERE username =?1";
		@Query(
				value=commande2SQL,
				nativeQuery = true)
		List<Candidature> fonction2(String username);
		
}
