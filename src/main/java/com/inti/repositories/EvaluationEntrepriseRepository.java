package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.EvaluationEntreprise;
import com.inti.entities.Utilisateur;

@Repository
public interface EvaluationEntrepriseRepository extends JpaRepository<EvaluationEntreprise, Long> {
	
	//calcule le nombre d'evaluation
			final String commande2SQL="SELECT COUNT(*) FROM evaluation_entreprise" ;

			@Query(
					value=commande2SQL,
					nativeQuery = true
			)
			Integer fonction2();	

}
