package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Test;

public interface ITestService {
	List<Test> findAll();
	Test findOne(Long idTest);
	Test save (Test Test);
	void delete (Long idTest);
}
