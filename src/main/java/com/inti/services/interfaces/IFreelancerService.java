package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Freelancer;


public interface IFreelancerService {
	List<Freelancer> findAll();
	Freelancer findOne(Long idFreelancer);
	Freelancer save (Freelancer Freelancer);
	void delete (Long idFreelancer);
}
