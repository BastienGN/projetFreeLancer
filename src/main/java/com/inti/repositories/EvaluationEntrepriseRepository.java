package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.EvaluationEntreprise;
import com.inti.entities.Utilisateur;

@Repository
public interface EvaluationEntrepriseRepository extends JpaRepository<EvaluationEntreprise, Long> {
	//crée une nouvelle evaluation entreprise et complète la table profil jobowner/eval_entreprise
			final String commandeSQL="INSERT INTO evaluation_entreprise (id_evaluation_entreprise, note, username_jobowner) VALUES (NULL, ?1, ?2);"
					+ "INSERT INTO profil_freelancer_evaluation_entreprise (id_freelancer, id_evaluation_entreprise) VALUES (?3,?4);" ;

			@Query(
					value=commandeSQL,
					nativeQuery = true
			)
			void fonction(Integer note,String usernameJobowner,Long idFreelancer,Long idEvaluationEntreprise);
	
	//calcule le nombre d'evaluation
			final String commande2SQL="SELECT COUNT(*) FROM evaluation_entreprise" ;

			@Query(
					value=commandeSQL,
					nativeQuery = true
			)
			Integer fonction2();	

}
