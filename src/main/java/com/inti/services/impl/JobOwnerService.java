package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.JobOwner;
import com.inti.repositories.JobOwnerRepository;
import com.inti.services.interfaces.IJobOwnerService;

@Service
public class JobOwnerService implements IJobOwnerService{
	@Autowired
	JobOwnerRepository jobOwnerRepository;

	@Override
	public List<JobOwner> findAll() {
		return jobOwnerRepository.findAll();
	}

	@Override
	public JobOwner findOne(Long idJobOwner) {
		return jobOwnerRepository.findById(idJobOwner).get();
	}

	@Override
	public JobOwner save(JobOwner jobOwner) {
		return jobOwnerRepository.save(jobOwner);
	}

	@Override
	public void delete(Long idJobOwner) {
		jobOwnerRepository.deleteById(idJobOwner);		
	}

}
