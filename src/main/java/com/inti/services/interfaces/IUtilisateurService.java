package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Utilisateur;

public interface IUtilisateurService {
	List<Utilisateur> findAll();

	Utilisateur findOne(Long idUtilisateur);

	Utilisateur save(Utilisateur utilisateur);

	void delete(Long idUtilisateur);

	Utilisateur findbyUsername(String username);
	
	List<Utilisateur> findByRole(String libelle);
	
	List<Utilisateur> findUtilisateursByCandidature(Long id_candidature);
	
	List<Utilisateur> findFreelancerByProjet(Long projet_id_projet);
	
	Double findMoyenneByFreelancer(String username);
	
	Double findMoyenneByJobOwner(String username);
	
	Integer nombreFreelancer();
	
	Integer nombreJobOwner();
	
}
