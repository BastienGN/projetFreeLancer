package com.inti.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Test;
import com.inti.services.interfaces.ITestService;

@RestController
@CrossOrigin
public class TestController {
	@Autowired
	ITestService TestService;

	@RequestMapping(value = "tests", method = RequestMethod.GET)
	public List<Test> findAll() {
		return TestService.findAll();
	}

	@RequestMapping(value = "tests/{idT}", method = RequestMethod.GET)
	public Test findOne(@PathVariable("idT") Long idTest) {
		return TestService.findOne(idTest);
	}


	@RequestMapping(value = "tests", method = RequestMethod.POST)
	public Test saveTest(@RequestBody Test Test) {
		return TestService.save(Test);
	}

	@RequestMapping(value = "tests/{idT}", method = RequestMethod.PUT)
	public Test updateTest(@PathVariable(value = "idT") Long idTest, @RequestBody Test Test) {
		Test currentTest = TestService.findOne(idTest);
		currentTest.setDescription(Test.getDescription());
		currentTest.setResultat(Test.getResultat());
		return TestService.save(currentTest);
	}
	
	/*@RequestMapping(value = "tests/{idT}", method = RequestMethod.PUT)
	public Test updateTest(@PathVariable(value = "idT") Long idTest, 
			@RequestParam(name = "resultat",required = false) String resultat) {
		Test currentTest = TestService.findOne(idTest);
		currentTest.setResultat(resultat);
		return TestService.save(currentTest);
	}*/
	
	@PutMapping("/testsss/{idR}/{idT}")
	public void updateResultatTest(@PathVariable(value="idR") String resultat,
            @PathVariable(value = "idT") Long idTest) {
        TestService.updateResultatTest(resultat, idTest);
    }

	@RequestMapping(value = "tests/{idT}", method = RequestMethod.DELETE)
	public void deleteTest(@PathVariable(value = "idT") Long idTest) {
		TestService.delete(idTest);
	}
}
