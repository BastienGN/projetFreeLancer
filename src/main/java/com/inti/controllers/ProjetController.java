package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Projet;
import com.inti.services.interfaces.IProjetService;

@RestController
@CrossOrigin
public class ProjetController {
	
	@Autowired
	IProjetService projetService;
	
	@GetMapping("/projets")
	public List<Projet> findAll() {
		return projetService.findAll();
	}
	
	@GetMapping("/projets/{idP}")
	public Projet findOne(@PathVariable(value = "idP") Long idProjet) {
		return projetService.findOne(idProjet);
	}
	
	@PostMapping("/projets")
    public Projet saveProjet(
    		@RequestBody Projet projet){
            return projetService.save(projet);
    }
	
	@PutMapping("/projets/{idP}")
	public Projet updateProjet(
			@PathVariable("idP") Long idProjet,
			@RequestBody Projet projet) {
		Projet currentProjet = projetService.findOne(idProjet);
		if (projet.getTitre() != null){
			currentProjet.setTitre(projet.getTitre());
		}
		if (projet.getStatut() != null){
			currentProjet.setStatut(projet.getStatut());
		}
		if (projet.getUtilisateurs() != null){
			currentProjet.setUtilisateurs(projet.getUtilisateurs());
		}
		return projetService.save(currentProjet);
	}
	
	@DeleteMapping("/projets/{idProjet}")
	public void deleteProjet(@PathVariable("idProjet") Long idProjet) {
		projetService.delete(idProjet);
	}

}
