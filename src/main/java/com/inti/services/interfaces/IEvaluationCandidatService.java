package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.EvaluationCandidat;

public interface IEvaluationCandidatService {
	List<EvaluationCandidat> findAll();

	EvaluationCandidat findOne(Long idEvaluationCandidat);

	EvaluationCandidat save(EvaluationCandidat evaluationCandidat);

	void delete(Long idEvaluationCandidat);
	
	List<Double> findAllNoteByUsername(String username);
}
