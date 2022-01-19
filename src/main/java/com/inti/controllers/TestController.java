package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Test;
import com.inti.services.interfaces.ITestService;

@RestController
@CrossOrigin
public class TestController {
	@Autowired
	ITestService TestService;

	@RequestMapping(value = "Tests", method = RequestMethod.GET)
	public List<Test> findAll() {
		return TestService.findAll();
	}

	@RequestMapping(value = "Tests/{idR}", method = RequestMethod.GET)
	public Test findOne(@PathVariable("idR") Long idTest) {
		return TestService.findOne(idTest);
	}


	@RequestMapping(value = "Tests", method = RequestMethod.POST)
	public Test saveTest(@RequestBody Test Test) {
		return TestService.save(Test);
	}

	@RequestMapping(value = "Tests/{idR}", method = RequestMethod.PUT)
	public Test updateTest(@PathVariable(value = "idR") Long idTest, @RequestBody Test Test) {
		Test currentTest = TestService.findOne(idTest);
		currentTest.setDescription(Test.getDescription());
		currentTest.setResultat(Test.getResultat());
		return TestService.save(currentTest);
	}

	@RequestMapping(value = "Tests/{idR}", method = RequestMethod.DELETE)
	public void deleteTest(@PathVariable(value = "idR") Long idTest) {
		TestService.delete(idTest);
	}
}
