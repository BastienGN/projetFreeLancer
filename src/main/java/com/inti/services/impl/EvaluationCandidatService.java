package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.EvaluationCandidat;
import com.inti.repositories.EvaluationCandidatRepository;

@Service
public class EvaluationCandidatService {
	@Autowired
	EvaluationCandidatRepository evaluationCandidatRepository;

	@Override
	public List<EvaluationCandidat> findAll() {
		return evaluationCandidatRepository.findAll();
	}

	@Override
	public EvaluationCandidat findOne(Long idEvaluationCandidat) {
		return evaluationCandidatRepository.findById(idEvaluationCandidat).get();
	}

	@Override
	public EvaluationCandidat save(EvaluationCandidat evaluationCandidat) {
		return evaluationCandidatRepository.save(evaluationCandidat);
	}

	@Override
	public void delete(Long idEvaluationCandidat) {
		evaluationCandidatRepository.deleteById(idEvaluationCandidat);		
	}

}
