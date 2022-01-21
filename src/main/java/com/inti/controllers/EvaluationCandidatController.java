package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inti.entities.EvaluationCandidat;
import com.inti.services.interfaces.IEvaluationCandidatService;

public class EvaluationCandidatController {
	@Autowired
	IEvaluationCandidatService evaluationCandidatService;

	@RequestMapping(value = "evaluationCandidats", method = RequestMethod.GET)
	public List<EvaluationCandidat> findAll() {
		return evaluationCandidatService.findAll();
	}

	@RequestMapping(value = "evaluationCandidats/{idEC}", method = RequestMethod.GET)
	public EvaluationCandidat findOne(@PathVariable("idEC") Long idEvaluationCandidat) {
		return evaluationCandidatService.findOne(idEvaluationCandidat);
	}

	@RequestMapping(value = "evaluationCandidats", method = RequestMethod.POST)
	public EvaluationCandidat saveEvaluationCandidat(@RequestBody EvaluationCandidat evaluationCandidat) {
		return evaluationCandidatService.save(evaluationCandidat);
	}

	@RequestMapping(value = "evaluationCandidats/{idEC}", method = RequestMethod.PUT)
	public EvaluationCandidat updateEvaluationCandidat(@PathVariable(value = "idEC") Long idEvaluationCandidat, @RequestBody EvaluationCandidat evaluationCandidat) {
		EvaluationCandidat currentEvaluationCandidat = evaluationCandidatService.findOne(idEvaluationCandidat);
		currentEvaluationCandidat.setNote(evaluationCandidat.getNote());
		currentEvaluationCandidat.setUsername(evaluationCandidat.getUsername());
		return evaluationCandidatService.save(currentEvaluationCandidat);
	}

	@RequestMapping(value = "evaluationCandidats/{idR}", method = RequestMethod.DELETE)
	public void deleteEvaluationCandidat(@PathVariable(value = "idR") Long idEvaluationCandidat) {
		evaluationCandidatService.delete(idEvaluationCandidat);
	}
}
