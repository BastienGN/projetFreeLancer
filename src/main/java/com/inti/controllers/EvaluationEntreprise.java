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
public class EvaluationEntreprise {
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

	@RequestMapping(value = "EvaluationEntreprises/{idR}/{libelle}", method = RequestMethod.GET)
	public EvaluationEntreprise findByIdEvaluationEntrepriseAndLibelle(@PathVariable("idR") Long idEvaluationEntreprise, @PathVariable("libelle") String libelle) {
		return EvaluationEntrepriseService.findByIdEvaluationEntrepriseAndLibelle(idEvaluationEntreprise, libelle);
	}

	@RequestMapping(value = "EvaluationEntreprises", method = RequestMethod.POST)
	public EvaluationEntreprise saveEvaluationEntreprise(@RequestBody EvaluationEntreprise EvaluationEntreprise) {
		return EvaluationEntrepriseService.save(EvaluationEntreprise);
	}

	@RequestMapping(value = "EvaluationEntreprises/{idR}", method = RequestMethod.PUT)
	public EvaluationEntreprise updateEvaluationEntreprise(@PathVariable(value = "idR") Long idEvaluationEntreprise, @RequestBody EvaluationEntreprise EvaluationEntreprise) {
		EvaluationEntreprise currentEvaluationEntreprise = EvaluationEntrepriseService.findOne(idEvaluationEntreprise);
		currentEvaluationEntreprise.setLibelle(EvaluationEntreprise.getLibelle());
		return EvaluationEntrepriseService.save(currentEvaluationEntreprise);
	}

	@RequestMapping(value = "EvaluationEntreprises/{idR}", method = RequestMethod.DELETE)
	public void deleteEvaluationEntreprise(@PathVariable(value = "idR") Long idEvaluationEntreprise) {
		EvaluationEntrepriseService.delete(idEvaluationEntreprise);

}
