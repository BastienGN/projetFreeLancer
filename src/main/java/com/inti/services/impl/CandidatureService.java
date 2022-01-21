package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Candidature;
import com.inti.repositories.CandidatureRepository;
import com.inti.services.interfaces.ICandidatureService;

@Service
public class CandidatureService implements ICandidatureService{

	@Autowired
	CandidatureRepository candidatureRepository;
	
	@Override
	public List<Candidature> findAll() {
		return candidatureRepository.findAll();
	}

	@Override
	public Candidature findOne(Long idCandidature) {
		return candidatureRepository.findById(idCandidature).get();
	}

	@Override
	public Candidature save(Candidature candidature) {
		return candidatureRepository.save(candidature);
	}

	@Override
	public void delete(Long idCandidature) {
		candidatureRepository.deleteById(idCandidature);
	}
	
	@Override
	public List<Candidature> findCandidatureByUsername(String username) {
		return candidatureRepository.fonction2(username);
	}
	
}
