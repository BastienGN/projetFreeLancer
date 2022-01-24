package com.inti.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
		
	// uodate le status avec le mot voulu grâce à l'id de la candidature
		final String commande3SQL="UPDATE candidature SET candidature.statut=?1 where candidature.id_candidature=?2";
		@Modifying()
		@Transactional
		@Query(
				value=commande3SQL,
				nativeQuery = true)
		void fonction3(String statut,Long idCandidature);
}
