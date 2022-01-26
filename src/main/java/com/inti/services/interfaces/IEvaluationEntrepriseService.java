package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.EvaluationEntreprise;

public interface IEvaluationEntrepriseService {
	List<EvaluationEntreprise> findAll();

	EvaluationEntreprise findOne(Long idEvaluationEntreprise);

	EvaluationEntreprise save(EvaluationEntreprise EvaluationEntreprise);

	void delete(Long idEvaluationEntreprise);
	
	Integer nbEvalEntreprise();
	
}
