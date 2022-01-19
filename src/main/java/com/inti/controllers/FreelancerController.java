package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Freelancer;
import com.inti.services.interfaces.IFreelancerService;

@RestController
@CrossOrigin
public class FreelancerController {
	@Autowired
	IFreelancerService FreelancerService;

	@RequestMapping(value = "Freelancers", method = RequestMethod.GET)
	public List<Freelancer> findAll() {
		return FreelancerService.findAll();
	}

	@RequestMapping(value = "Freelancers/{idR}", method = RequestMethod.GET)
	public Freelancer findOne(@PathVariable("idR") Long idFreelancer) {
		return FreelancerService.findOne(idFreelancer);
	}


	@RequestMapping(value = "Freelancers", method = RequestMethod.POST)
	public Freelancer saveFreelancer(@RequestBody Freelancer Freelancer) {
		return FreelancerService.save(Freelancer);
	}

	@RequestMapping(value = "Freelancers/{idR}", method = RequestMethod.PUT)
	public Freelancer updateFreelancer(@PathVariable(value = "idR") Long idFreelancer, @RequestBody Freelancer Freelancer) {
		Freelancer currentFreelancer = FreelancerService.findOne(idFreelancer);
		currentFreelancer.setExperience(Freelancer.getExperience());
		currentFreelancer.setSitePersonnel(Freelancer.getSitePersonnel());
		currentFreelancer.setCv(Freelancer.getCv());
		currentFreelancer.setNote(Freelancer.getNote());
		return FreelancerService.save(currentFreelancer);
	}

	@RequestMapping(value = "Freelancers/{idR}", method = RequestMethod.DELETE)
	public void deleteFreelancer(@PathVariable(value = "idR") Long idFreelancer) {
		FreelancerService.delete(idFreelancer);
	}
}
