package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Freelancer;
import com.inti.repositories.FreelancerRepository;
import com.inti.services.interfaces.IFreelancerService;

@Service
public class FreelancerService implements IFreelancerService{
	@Autowired
	FreelancerRepository FreelancerRepository;

	@Override
	public List<Freelancer> findAll() {
		return FreelancerRepository.findAll();
	}

	@Override
	public Freelancer findOne(Long idFreelancer) {
		return FreelancerRepository.findById(idFreelancer).get();
	}

	@Override
	public Freelancer save(Freelancer Freelancer) {
		return FreelancerRepository.save(Freelancer);
	}

	@Override
	public void delete(Long idFreelancer) {
		FreelancerRepository.deleteById(idFreelancer);		
	}
}
