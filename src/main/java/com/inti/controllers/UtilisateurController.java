package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.save(utilisateur);
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
        return utilisateurService.save(currentUtilisateur);

    }

    @RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
}
