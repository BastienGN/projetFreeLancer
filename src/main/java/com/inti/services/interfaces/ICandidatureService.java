package com.inti.services.interfaces;

import java.util.List;
import com.inti.entities.Candidature;

public interface ICandidatureService {
	
	List<Candidature> findAll();

	Candidature findOne(Long idCandidature);

	Candidature save(Candidature candidature);

	void delete(Long idCandidature);
	
	List<Candidature> findCandidatureByUsername(String username);
	
	void updateStatutCandidatureByIdCandidature(String statut,Long idCandidature);
}
