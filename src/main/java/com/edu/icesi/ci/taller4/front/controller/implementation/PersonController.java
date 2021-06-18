package com.edu.icesi.ci.taller4.front.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.edu.icesi.ci.taller4.back.service.interfaces.InstitutionService;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	private InstitutionService institutionService;
	
	@Autowired
	public PersonController(PersonService personService, InstitutionService institutionService) {
		this.personService = personService;
		this.institutionService = institutionService;
	}
}
