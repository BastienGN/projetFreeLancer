package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.EvaluationEntreprise;
import com.inti.services.interfaces.IEvaluationEntrepriseService;

@RestController
@CrossOrigin
public class EvaluationEntrepriseController {
	@Autowired
	IEvaluationEntrepriseService EvaluationEntrepriseService;

	@RequestMapping(value = "EvaluationEntreprises", method = RequestMethod.GET)
	public List<EvaluationEntreprise> findAll() {
		return EvaluationEntrepriseService.findAll();
	}

	@RequestMapping(value = "EvaluationEntreprises/{idR}", method = RequestMethod.GET)
	public EvaluationEntreprise findOne(@PathVariable("idR") Long idEvaluationEntreprise) {
		return EvaluationEntrepriseService.findOne(idEvaluationEntreprise);
	}


	@RequestMapping(value = "EvaluationEntreprises", method = RequestMethod.POST)
	public EvaluationEntreprise saveEvaluationEntreprise(@RequestBody EvaluationEntreprise EvaluationEntreprise) {
		return EvaluationEntrepriseService.save(EvaluationEntreprise);
	}

	@RequestMapping(value = "EvaluationEntreprises/{idR}", method = RequestMethod.PUT)
	public EvaluationEntreprise updateEvaluationEntreprise(@PathVariable(value = "idR") Long idEvaluationEntreprise, @RequestBody EvaluationEntreprise EvaluationEntreprise) {
		EvaluationEntreprise currentEvaluationEntreprise = EvaluationEntrepriseService.findOne(idEvaluationEntreprise);
		currentEvaluationEntreprise.setDescription(EvaluationEntreprise.getDescription());
		currentEvaluationEntreprise.setNote(EvaluationEntreprise.getNote());
		return EvaluationEntrepriseService.save(currentEvaluationEntreprise);
	}

	@RequestMapping(value = "EvaluationEntreprises/{idR}", method = RequestMethod.DELETE)
	public void deleteEvaluationEntreprise(@PathVariable(value = "idR") Long idEvaluationEntreprise) {
		EvaluationEntrepriseService.delete(idEvaluationEntreprise);
	}
}
