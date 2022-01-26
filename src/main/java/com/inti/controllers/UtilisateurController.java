package com.inti.controllers;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Role;
import com.inti.entities.Utilisateur;

import com.inti.services.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {
    @Autowired
    IUtilisateurService utilisateurService;

    @RequestMapping(value="utilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }
    
    @RequestMapping(value="utilisateurs/{idU}", method = RequestMethod.GET)
    public Utilisateur findOne(@PathVariable("idU") Long idUtilisateur) {
        return utilisateurService.findOne(idUtilisateur);
    }

    @RequestMapping(value="utilisateurs/{idU}/{username}", method =
    RequestMethod.GET)
    public Utilisateur findByIdUtilisateurAndLibelle(@PathVariable("idU") Long idUtilisateur,
            @PathVariable("username") String username) {
        return utilisateurService.findbyUsername(username);
    }
    
    @PostMapping(value="utilisateurs")
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) 
    {
    		return utilisateurService.save(utilisateur);
    }
    
    @PutMapping("utilisateurs/{idU}")
    public Utilisateur updateUtilisateur(
    		@PathVariable(name="idU") Long idUtilisateur,
    		@RequestBody Utilisateur utilisateur
    		)
    {
    	Utilisateur currentUtilisateur=utilisateurService.findOne(idUtilisateur);
    	 if (utilisateur.getNomUtilisateur() !=null) {
         	currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
         }
         if (utilisateur.getPrenomUtilisateur()!=null) {
         	currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
         }
         if (utilisateur.getUsername()!=null) {
         	currentUtilisateur.setUsername(utilisateur.getUsername());
         }
         if (utilisateur.getPassword() !=null) {
         	currentUtilisateur.setPassword(utilisateur.getPassword());
         }
         if (utilisateur.getAdresseMail() !=null) {
         	currentUtilisateur.setAdresseMail(utilisateur.getAdresseMail());
         }
         if(utilisateur.getTelephone() !=null) 
         {
        	 currentUtilisateur.setTelephone(utilisateur.getTelephone());
         }
         if(utilisateur.getNote() !=null) 
         {
        	 currentUtilisateur.setNote(utilisateur.getNote());
         }
         if(utilisateur.getCv()!= null) 
         {
        	 currentUtilisateur.setCv(utilisateur.getCv());
         }
         if(utilisateur.getNomEntreprise()!=null) 
         {
        	 currentUtilisateur.setNomEntreprise(utilisateur.getNomEntreprise());
         }
         if(utilisateur.getRoles()!=null) 
         {
        	 currentUtilisateur.setRoles(utilisateur.getRoles());
         }     
         return utilisateurService.save(currentUtilisateur);
    }

    @RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
    //méthode particulière
	    @RequestMapping(value="util/{libelle_role}", method=RequestMethod.GET)
	    public List<Utilisateur> findByRole(@PathVariable("libelle_role") String libelle)
	    {
	    	return utilisateurService.findByRole(libelle);
	    }
	    
	    @RequestMapping(value="utilisateurscandidature/{idU}", method=RequestMethod.GET)
	    public List<Utilisateur> findUtilisateursByCandidature(@PathVariable("idU") Long id_candidature)
	    {
	    	return utilisateurService.findUtilisateursByCandidature(id_candidature);
	    }
	    
	    @RequestMapping(value="freelancersprojets/{idF}", method=RequestMethod.GET)
	    public List<Utilisateur> findFreelancerByProjet(@PathVariable("idF") Long projet_id_projet)
	    {
	    	return utilisateurService.findFreelancerByProjet(projet_id_projet);
	    }
	    
	    @RequestMapping(value="moyennefreelancer/{idF}", method=RequestMethod.GET)
	    public Double findMoyenneByFreelancer(@PathVariable("idF") String libelle)
	    {
	    	return utilisateurService.findMoyenneByFreelancer(libelle);
	    }
	    
	    @RequestMapping(value="moyennejobowner/{idJ}", method=RequestMethod.GET)
	    public Double findMoyenneByJobOwner(@PathVariable("idJ") String libelle)
	    {
	    	return utilisateurService.findMoyenneByJobOwner(libelle);
	    }
	    
	    @RequestMapping(value="nombrefreelancer", method=RequestMethod.GET)
	    public Integer nombreFreelancer()
	    {
	    	return utilisateurService.nombreFreelancer();
	    }
	    
	    @RequestMapping(value="nombrejobowner", method=RequestMethod.GET)
	    public Integer nombreJobOwner()
	    {
	    	return utilisateurService.nombreJobOwner();
	    }
	    
}
