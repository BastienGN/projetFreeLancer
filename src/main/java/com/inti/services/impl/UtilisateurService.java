package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Utilisateur;
import com.inti.repositories.UtilisateurRepository;
import com.inti.services.interfaces.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long idUtilisateur) {
		return utilisateurRepository.findById(idUtilisateur).get();
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void delete(Long idUtilisateur) {
		utilisateurRepository.deleteById(idUtilisateur);
	}

	@Override
	public Utilisateur findbyUsername(String username) {
		return utilisateurRepository.findByUsername(username);
	}

	@Override
	public List<Utilisateur> findByRole(String libelle) {
		return utilisateurRepository.fonction(libelle);
	}

	@Override
	public List<Utilisateur> findUtilisateursByCandidature(Long id_candidature) {
		return utilisateurRepository.fonction2(id_candidature);
	}

	@Override
	public List<Utilisateur> findFreelancerByProjet(Long projet_id_projet) {
		return utilisateurRepository.fonction3(projet_id_projet);
	}

	@Override
	public Double findMoyenneByFreelancer(String username) {
		List<Double> listeNoteFreelancer = utilisateurRepository.fonction4(username);
		Integer taille = listeNoteFreelancer.size();
		Double sum=0.0;
		for (Double note : listeNoteFreelancer)
		{
			sum+=note;
		}
		return sum/taille;
	}

	@Override
	public Double findMoyenneByJobOwner(String username) {
		List<Double> listeNoteJobOwner = utilisateurRepository.fonction4b(username);
		Integer taille = listeNoteJobOwner.size();
		Double sum=0.0;
		for (Double note : listeNoteJobOwner)
		{
			sum+=note;
		}
		return sum/taille;
	}

	@Override
	public Integer nombreFreelancer() {
		return utilisateurRepository.fonction5("freelancer");
	}

	@Override
	public Integer nombreJobOwner() {
		return utilisateurRepository.fonction5("jobowner");
	}

	
}