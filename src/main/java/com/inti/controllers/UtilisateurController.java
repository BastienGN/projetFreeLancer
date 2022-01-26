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
//         if(utilisateur.getEvalutationsEntreprises()!=null) 
//         {
//        	 currentUtilisateur.setEvalutationsEntreprises(utilisateur.getEvalutationsEntreprises());
//         }
//         if(utilisateur.getEvaluationCandidats()!=null) 
//         {
//        	 currentUtilisateur.setEvaluationCandidats(utilisateur.getEvaluationCandidats());
//         }
//         if(utilisateur.getTests()!=null) 
//         {
//        	 currentUtilisateur.setTests(utilisateur.getTests());
//         }
//         if(utilisateur.getProjets()!=null) 
//         {
//        	 currentUtilisateur.setProjets(utilisateur.getProjets());
//         }
         
         return utilisateurService.save(currentUtilisateur);
    }
//    @RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
//	public String saveUtilisateur(
//			@RequestParam(name = "nomUtilisateur",required = false) String nomUtilisateur,
//    		@RequestParam(name = "prenomUtilisateur",required = false) String prenomUtilisateur,
//    		@RequestParam(name = "username",required = false) String username,
//    		@RequestParam(name = "password",required = false) String password, 
//    		@RequestParam(name = "adresseMail",required = false) String adresseMail,
//    		@RequestParam(name = "telephone",required = false) Long telephone, 
//    		@RequestParam(name = "cv",required = false) MultipartFile cv,
//    		@RequestParam(name = "note",required = false) Integer note,
//			@RequestParam(name = "nomEntreprise",required = false) String nomEntreprise
//								) {
//    	try {
//    		Utilisateur currentUtilisateur = new Utilisateur();
//        currentUtilisateur.setNomUtilisateur(nomUtilisateur);
//        currentUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
//        currentUtilisateur.setUsername(username);
//        currentUtilisateur.setPassword(password);
//        currentUtilisateur.setAdresseMail(adresseMail);
//        currentUtilisateur.setTelephone(telephone);
//        if (cv != null) {
//            currentUtilisateur.setCv(cv.getBytes());
//        }
//        currentUtilisateur.setNote(note);
//        currentUtilisateur.setNomEntreprise(nomEntreprise);
//		utilisateurService.save(currentUtilisateur);
//    	return "c'est ok";
//    	} catch (Exception ex) {
//            ex.printStackTrace();
//            return "c'est la problèmatique";
//    	}
//
//    	
//	}
//
//    @RequestMapping(value="utilisateurs/{idU}", method=RequestMethod.PUT)
//    public String updateUtilisateur(
//    		@PathVariable(name = "idU") Long idUtilisateur,
//    		@RequestParam(name = "nomUtilisateur",required = false) String nomUtilisateur,
//    	    @RequestParam(name = "prenomUtilisateur",required = false) String prenomUtilisateur,
//    	    @RequestParam(name = "username",required = false) String username,
//    	    @RequestParam(name = "password",required = false) String password, 
//    	    @RequestParam(name = "adresseMail",required = false) String adresseMail,
//    	    @RequestParam(name = "telephone",required = false) Long telephone, 
//    	    @RequestParam(name="roles",required=false) Set<Role> roles,//ici
//    	    @RequestParam(name = "cv",required = false) MultipartFile cv,
//    	    @RequestParam(name = "note",required = false) Integer note,
//    		@RequestParam(name = "nomEntreprise",required = false) String nomEntreprise
//    									) {
//     	try {
//    	Utilisateur currentUtilisateur =utilisateurService.findOne(idUtilisateur);
//    	if (roles !=null) {
//        	currentUtilisateur.setRoles(roles);//ici
//        }
//        if (nomUtilisateur !=null) {
//        	currentUtilisateur.setNomUtilisateur(nomUtilisateur);
//        }
//        if (prenomUtilisateur !=null) {
//        	currentUtilisateur.setPrenomUtilisateur(prenomUtilisateur);
//        }
//        if (username !=null) {
//        	currentUtilisateur.setUsername(username);
//        }
//        if (password !=null) {
//        	currentUtilisateur.setPassword(password);
//        }
//        if (adresseMail !=null) {
//        	currentUtilisateur.setAdresseMail(adresseMail);
//        }
//        if (telephone !=null) {
//        	currentUtilisateur.setTelephone(telephone);
//        }
//        if (cv != null) {
//            currentUtilisateur.setCv(cv.getBytes());
//        }
//        if(note!=null){
//            currentUtilisateur.setNote(note);
//        }
//        if(nomEntreprise!=null) 
//        {
//            currentUtilisateur.setNomEntreprise(nomEntreprise);
//        }
//		utilisateurService.save(currentUtilisateur);
//    	return "c'est ok";
//    	} catch (Exception ex) {
//            ex.printStackTrace();
//            return "c'est la problèmatique";
//    	}
//}

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
