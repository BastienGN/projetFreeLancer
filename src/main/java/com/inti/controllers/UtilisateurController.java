package com.inti.controllers;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entities.Utilisateur;
import com.inti.models.Adresse;
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

    @RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
	public String saveUtilisateur(
			@RequestParam(name = "nomUtilisateur",required = false) String nomUtilisateur,
    		@RequestParam(name = "prenomUtilisateur",required = false) String prenomUtilisateur,
    		@RequestParam(name = "username",required = false) String username,
    		@RequestParam(name = "password",required = false) String password, 
    		@RequestParam(name = "adresseMail",required = false) String adresseMail,
    		@RequestParam(name = "telephone",required = false) Long telephone, 
    		@RequestParam(name = "cv",required = false) MultipartFile cv,
    		@RequestParam(name = "note",required = false) Integer note,
			@RequestParam(name = "nomEntreprise",required = false) String nomEntreprise
								) {
    	try {
    		Utilisateur currentUtilisateur = new Utilisateur();
        currentUtilisateur.setNomUtilisateur(nomUtilisateur);
        currentUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
        currentUtilisateur.setUsername(username);
        currentUtilisateur.setPassword(password);
        currentUtilisateur.setAdresseMail(adresseMail);
        currentUtilisateur.setTelephone(telephone);
        currentUtilisateur.setCv(cv.getBytes());
        currentUtilisateur.setNote(note);
        currentUtilisateur.setNomEntreprise(nomEntreprise);
		utilisateurService.save(currentUtilisateur);
    	return "c'est ok";
    	} catch (Exception ex) {
            ex.printStackTrace();
            return "c'est la problèmatique";
    	}

    	
	}

    @RequestMapping(value="utilisateurs/{idU}", method=RequestMethod.PUT)
    public String updateUtilisateur(
    		@RequestParam(name = "idUtilisateur",required = false) Long idUtilisateur,
    		@RequestParam(name = "nomUtilisateur",required = false) String nomUtilisateur,
    	    @RequestParam(name = "prenomUtilisateur",required = false) String prenomUtilisateur,
    	    @RequestParam(name = "username",required = false) String username,
    	    @RequestParam(name = "password",required = false) String password, 
    	    @RequestParam(name = "adresseMail",required = false) String adresseMail,
    	    @RequestParam(name = "telephone",required = false) Long telephone, 
    	    @RequestParam(name = "cv",required = false) MultipartFile cv,
    	    @RequestParam(name = "note",required = false) Integer note,
    		@RequestParam(name = "nomEntreprise",required = false) String nomEntreprise
    									) {
     	try {
    	Utilisateur currentUtilisateur =utilisateurService.findOne(idUtilisateur);
        currentUtilisateur.setNomUtilisateur(nomUtilisateur);
        currentUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
        currentUtilisateur.setUsername(username);
        currentUtilisateur.setPassword(password);
        currentUtilisateur.setAdresseMail(adresseMail);
        currentUtilisateur.setTelephone(telephone);
        currentUtilisateur.setCv(cv.getBytes());
        currentUtilisateur.setNote(note);
        currentUtilisateur.setNomEntreprise(nomEntreprise);
		utilisateurService.save(currentUtilisateur);
    	return "c'est ok";
    	} catch (Exception ex) {
            ex.printStackTrace();
            return "c'est la problèmatique";
    	}
}

    @RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
    
    @RequestMapping(value="util/{libelle_role}", method=RequestMethod.GET)
    public List<Utilisateur> findByRole(@PathVariable("libelle_role") String libelle)
    {
    	return utilisateurService.findByRole(libelle);
    }
}
