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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Candidature;
import com.inti.entities.Projet;
import com.inti.services.interfaces.ICandidatureService;

@RestController
@CrossOrigin
public class CandidatureController {
	@Autowired
	ICandidatureService candidatureService;
	
	@GetMapping("/candidatures")
	public List<Candidature> findAll() {
		return candidatureService.findAll();
	}

	@GetMapping("/candidatures/{idC}")
	public Candidature findOne(@PathVariable(value = "idC") Long idCandidature) {
		return candidatureService.findOne(idCandidature);
	}
	
//	@PostMapping("/candidatures")
//    public Candidature saveCandidature(
//    		@RequestParam(name = "statut",required = false) String statut, 
//    		@RequestParam(name = "lettreMotivation",required = false) String lettreMotivation,
//    		@RequestParam(name = "username",required = false) String username,
//    		@RequestParam(name ="projet",required=false) Projet projet
//    		) {
//            Candidature currentCandidature=new Candidature();
//            currentCandidature.setStatut(statut);
//            currentCandidature.setLettreMotivation(lettreMotivation);
//            currentCandidature.setUsername(username);
//            currentCandidature.setProjet(projet);
//            return candidatureService.save(currentCandidature);
//    }
	
	@PostMapping("/candidatures")
	public Candidature saveCandidature(@RequestBody Candidature candidature)
	{
		return candidatureService.save(candidature);
	}
	
//	@PutMapping("/candidatures/{idC}")
//	public Integer updateCandidature(
//			@PathVariable("idC") Long idCandidature, 
//			@RequestParam(name = "statut",required = false) String statut, 
//    		@RequestParam(name = "lettreMotivation",required = false) String lettreMotivation,
//    		@RequestParam(name = "username",required = false) String username,
//    		@RequestParam(name ="projet_id_projet",required=false) Long projet_id_projet
//			)
//	{
//		return candidatureService.updateCandidature(lettreMotivation, statut, username, projet_id_projet, idCandidature);
//	}
	
	@PutMapping("/candidatures/{idC}")
	public Candidature updateCandidature(@PathVariable("idC") Long idCandidature,@RequestBody Candidature candidature) 
	{
		Candidature currentCandidature=candidatureService.findOne(idCandidature);
		if(candidature.getStatut()!=null) 
		{
			currentCandidature.setStatut(candidature.getStatut());
		}
		if(candidature.getLettreMotivation()!=null) 
		{
			currentCandidature.setLettreMotivation(candidature.getLettreMotivation());
		}
		if(candidature.getUsername()!=null) 
		{
			currentCandidature.setUsername(candidature.getUsername());
		}
		if(candidature.getProjet()!=null) 
		{
			currentCandidature.setProjet(candidature.getProjet());
		}
		return candidatureService.save(currentCandidature);
	}

	@DeleteMapping("/candidatures/{idCandidature}")
	public void deleteCandidature(@PathVariable("idCandidature") Long idCandidature) {
		candidatureService.delete(idCandidature);
	}
	
	@RequestMapping(value="cands/{username}", method=RequestMethod.GET)
    public List<Candidature> findCandidatureByUsername(@PathVariable("username") String username)
    {
    	return candidatureService.findCandidatureByUsername(username);
    }
	
	@PutMapping("/cands/{statut}/{idC}")
	public void updateStatutCandidature(@PathVariable("statut")String statut,@PathVariable("idC") Long idCandidature) 
	{
		candidatureService.updateStatutCandidatureByIdCandidature(statut, idCandidature);
	}
	
}
