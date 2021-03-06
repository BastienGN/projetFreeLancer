package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.EvaluationEntreprise;
import com.inti.services.interfaces.IEvaluationEntrepriseService;

@RestController
@CrossOrigin
public class EvaluationEntrepriseController {
	@Autowired
	IEvaluationEntrepriseService EvaluationEntrepriseService;

	@RequestMapping(value = "evaluationEntreprises", method = RequestMethod.GET)
	public List<EvaluationEntreprise> findAll() {
		return EvaluationEntrepriseService.findAll();
	}

	@RequestMapping(value = "evaluationEntreprises/{idEE}", method = RequestMethod.GET)
	public EvaluationEntreprise findOne(@PathVariable("idEE") Long idEvaluationEntreprise) {
		return EvaluationEntrepriseService.findOne(idEvaluationEntreprise);
	}


	@RequestMapping(value = "evaluationEntreprises", method = RequestMethod.POST)
	public EvaluationEntreprise saveEvaluationEntreprise(@RequestBody EvaluationEntreprise EvaluationEntreprise) {
		return EvaluationEntrepriseService.save(EvaluationEntreprise);
	}

	@RequestMapping(value = "evaluationEntreprises/{idEE}", method = RequestMethod.PUT)
	public EvaluationEntreprise updateEvaluationEntreprise(@PathVariable(value = "idEE") Long idEvaluationEntreprise, @RequestBody EvaluationEntreprise evaluationEntreprise) {
		EvaluationEntreprise currentEvaluationEntreprise = EvaluationEntrepriseService.findOne(idEvaluationEntreprise);
		if(evaluationEntreprise.getUsernameJobowner()!=null) 
		{
			currentEvaluationEntreprise.setUsernameJobowner(evaluationEntreprise.getUsernameJobowner());
		}
		if(evaluationEntreprise.getNote()!=null) 
		{
			currentEvaluationEntreprise.setNote(evaluationEntreprise.getNote());
		}
		if(evaluationEntreprise.getUtilisateurs()!=null) 
		{
			currentEvaluationEntreprise.setUtilisateurs(evaluationEntreprise.getUtilisateurs());
		}
		return EvaluationEntrepriseService.save(currentEvaluationEntreprise);
	}

	@RequestMapping(value = "evaluationEntreprises/{idEE}", method = RequestMethod.DELETE)
	public void deleteEvaluationEntreprise(@PathVariable(value = "idEE") Long idEvaluationEntreprise) {
		EvaluationEntrepriseService.delete(idEvaluationEntreprise);
	}
}
