package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.JobOwner;

public interface IJobOwnerService {
	List<JobOwner> findAll();
	JobOwner findOne(Long idJobOwner);
	JobOwner save (JobOwner jobOwner);
	void delete (Long idJobOwner);
}
