package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Test;
import com.inti.entities.Test;
import com.inti.repositories.TestRepository;
import com.inti.services.interfaces.ITestService;

@Service
public class TestService implements ITestService{
	@Autowired
	TestRepository TestRepository;

	@Override
	public List<Test> findAll() {
		return TestRepository.findAll();
	}

	@Override
	public Test findOne(Long idTest) {
		return TestRepository.findById(idTest).get();
	}

	@Override
	public Test save(Test Test) {
		return TestRepository.save(Test);
	}

	@Override
	public void delete(Long idTest) {
		TestRepository.deleteById(idTest);		
	}
	
	@Override
    public void updateResultatTest(String resultat, Long id_test) {
        TestRepository.fonction(resultat,id_test);
    }
}
