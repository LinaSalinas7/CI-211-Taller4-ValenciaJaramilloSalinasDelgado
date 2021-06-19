package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.ci.taller4.back.model.FevInstitution;
import com.edu.icesi.ci.taller4.back.service.interfaces.FevInstitutionService;

@RestController
@RequestMapping("/api-rest/fevInstitution")
public class FevInstitutionRestControllerImp implements FevInstitutionRestController {

	@Autowired
	private FevInstitutionService fevInstitutionService;

	@Override
	@GetMapping("/")
	public Iterable<FevInstitution> indexFevInstitution() {
		return fevInstitutionService.findAll();
	}
	

}
