package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.EvaluationEntreprise;
import com.inti.repositories.EvaluationEntrepriseRepository;
import com.inti.services.interfaces.IEvaluationEntrepriseService;

@Service
public class EvaluationEntrepriseService implements IEvaluationEntrepriseService {
	@Autowired
	EvaluationEntrepriseRepository EvaluationEntrepriseRepository;

	@Override
	public List<EvaluationEntreprise> findAll() {
		return EvaluationEntrepriseRepository.findAll();
	}

	@Override
	public EvaluationEntreprise findOne(Long idEvaluationEntreprise) {
		return EvaluationEntrepriseRepository.findById(idEvaluationEntreprise).get();
	}

	@Override
	public EvaluationEntreprise save(EvaluationEntreprise EvaluationEntreprise) {
		return EvaluationEntrepriseRepository.save(EvaluationEntreprise);
	}

	@Override
	public void delete(Long idEvaluationEntreprise) {
		EvaluationEntrepriseRepository.deleteById(idEvaluationEntreprise);		
	}
}
