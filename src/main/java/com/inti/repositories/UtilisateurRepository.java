package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Utilisateur findByUsername(String username);
	
	//Selectionner tous les utilisateurs par role (admin, freelancer ou jobowner)
		final String commandeSQL="SELECT * FROM utilisateur WHERE id_utilisateur IN "
				+ "	(SELECT id_utilisateur FROM profil_utilisateur_role WHERE id_role IN"
				+ "(SELECT id_role FROM role WHERE libelle =?1 ))";
		@Query(
				value=commandeSQL,
				nativeQuery = true
		)
		List<Utilisateur> fonction(String Role);
		
		//Tous les utilisateurs à partir d'une candidature
		final String commande2SQL="SELECT * FROM utilisateur WHERE username IN "
				+ "(SELECT username FROM candidature WHERE id_candidature =?1)";
		@Query(
				value=commande2SQL,
				nativeQuery = true)
		List<Utilisateur> fonction2(Long id_candidature);
		
		//Tous les freelancers d'un projet
		final String commande3SQL="SELECT * FROM utilisateur WHERE username IN "
				+ "(SELECT username FROM candidature WHERE projet_id_projet =?1) "
				+ "AND id_utilisateur IN "
				+ "(SELECT id_utilisateur FROM profil_utilisateur_role WHERE id_role IN "
				+ "(SELECT id_role FROM role WHERE libelle ='freelancer'))";
		@Query(
				value=commande3SQL,
				nativeQuery = true)
		List<Utilisateur> fonction3(Long projet_id_projet);

		//Toutes les notes de tous les freelancers et/ou jobowners
		final String commande4SQL="SELECT ec.note FROM utilisateur u "
				+ "INNER JOIN evaluation_candidat ec ON u.username = ec.username_freelancer WHERE u.id_utilisateur IN"
				+ "(SELECT id_utilisateur FROM profil_utilisateur_role WHERE id_role IN"
				+ "(SELECT id_role FROM role WHERE libelle =?1 ))";
		
		@Query(
				value=commande4SQL,
				nativeQuery = true)
		List<Double> fonction4(String role);
		
		final String commande5SQL="SELECT count(*) FROM utilisateur WHERE id_utilisateur IN "
				+"(SELECT id_utilisateur FROM profil_utilisateur_role WHERE id_role IN"
				+"(SELECT id_role FROM role WHERE libelle =?1 ))";
		@Query(
				value=commande5SQL,
				nativeQuery = true)
		Integer fonction5(String role);
		
}
