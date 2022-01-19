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
	public Utilisateur saveUtilisateur(@RequestParam(name = "titre",required = false) String titre, 
    		@RequestParam(name = "nomUtilisateur",required = false) String nomUtilisateur,
    		@RequestParam(name = "prenomUtilisateur",required = false) String prenomUtilisateur,
    		@RequestParam(name = "username",required = false) String username,
    		@RequestParam(name = "password",required = false) String password, 
    		@RequestParam(name = "adresse",required = false) Adresse adresse,
    		@RequestParam(name = "dateNaissance",required = false) Date dateNaissance,
    		@RequestParam(name = "adresseMail",required = false) String adresseMail,
    		@RequestParam(name = "telephone",required = false) Long telephone, 
    		@RequestParam(name = "experience",required = false) Integer experience,
    		@RequestParam(name = "cv",required = false) File cv,
    		@RequestParam(name = "note",required = false) Integer note,
			@RequestParam(name = "sitePersonnel",required = false) String sitePersonnel, 
			@RequestParam(name = "nomEntreprise",required = false) String nomEntreprise,
			@RequestParam(name = "avis",required = false) String avis) {
    	Utilisateur currentUtilisateur = new Utilisateur();
        currentUtilisateur.setNomUtilisateur(nomUtilisateur);
        currentUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
        currentUtilisateur.setUsername(username);
        currentUtilisateur.setPassword(password);
        currentUtilisateur.setAdresse(adresse);
        currentUtilisateur.setDateNaissance(dateNaissance);
        currentUtilisateur.setAdresseMail(adresseMail);
        currentUtilisateur.setTelephone(telephone);
        currentUtilisateur.setExperience(experience);
        currentUtilisateur.setCv(cv);
        currentUtilisateur.setNote(note);
        currentUtilisateur.setSitePersonnel(sitePersonnel);
        currentUtilisateur.setNomEntreprise(nomEntreprise);
        currentUtilisateur.setAvis(avis);
		return utilisateurService.save(currentUtilisateur);
	}

    @RequestMapping(value="utilisateurs/{idU}", method=RequestMethod.PUT)
    public Utilisateur updateUtilisateur(@PathVariable("idU") Long idUtilisateur,
            @RequestBody Utilisateur utilisateur) {
        Utilisateur currentUtilisateur = utilisateurService.findOne(idUtilisateur);
        currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
        currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
        currentUtilisateur.setUsername(utilisateur.getUsername());
        currentUtilisateur.setPassword(utilisateur.getPassword());
        currentUtilisateur.setAdresse(utilisateur.getAdresse());
        currentUtilisateur.setDateNaissance(utilisateur.getDateNaissance());
        currentUtilisateur.setAdresseMail(utilisateur.getAdresseMail());
        currentUtilisateur.setTelephone(utilisateur.getTelephone());
        currentUtilisateur.setExperience(utilisateur.getExperience());
        currentUtilisateur.setCv(utilisateur.getCv());
        currentUtilisateur.setNote(utilisateur.getNote());
        currentUtilisateur.setSitePersonnel(utilisateur.getSitePersonnel());
        currentUtilisateur.setNomEntreprise(utilisateur.getNomEntreprise());
        currentUtilisateur.setAvis(utilisateur.getAvis());
        return utilisateurService.save(currentUtilisateur);
    }

    @RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
}
