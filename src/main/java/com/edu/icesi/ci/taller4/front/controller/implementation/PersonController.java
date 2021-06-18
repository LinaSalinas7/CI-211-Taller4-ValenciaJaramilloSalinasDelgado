package com.edu.icesi.ci.taller4.front.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.icesi.ci.taller4.back.service.interfaces.InstitutionService;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;
import com.edu.icesi.ci.taller4.front.bd.interfaces.InstitutionDelegate;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Autotransition;
import com.edu.icesi.ci.taller4.front.model.clases.Person;
import com.edu.icesi.ci.taller4.front.validations.CrearAutotran;
import com.edu.icesi.ci.taller4.front.validations.EditarTrig;

@Controller
public class PersonController {
	
	private PersonDelegate personDelegate;
	private InstitutionDelegate institutionDelegate;
	
	@Autowired
	public PersonController(PersonDelegate personDelegate, InstitutionDelegate institutionDelegate) {
		this.personDelegate = personDelegate;
		this.institutionDelegate = institutionDelegate;
	}
	
	@GetMapping("/persons/")
	public String indexAutotransition(Model model) {
		model.addAttribute("persons", personDelegate.findAll());
		return "persons/index";
	}
	
	@GetMapping("/persons/add")
	public String addAutotransition(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("institutions", institutionDelegate.getInstitution());
		return "persons/add-person";
	}
	
	@PostMapping("/persons/add")
	public String saveAutotransition(@Validated(CrearAutotran.class) @ModelAttribute("person") Person person
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {				
				model.addAttribute("institutions", institutionDelegate.getInstitution());
			 	return "persons/add-person";
			}		
			else {
				personDelegate.save(person);
			}			
		return "redirect:/persons/";
	}
	
	@GetMapping("/persons/del/{id}")
	public String deleteAutotransition(@PathVariable("id") long id, Model model) {
		Person person = personDelegate.findById(id);//.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		personDelegate.delete(person);
		model.addAttribute("persons", personDelegate.findAll());
		return "persons/index";
	}
	
	@GetMapping("/persons/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Person person = personDelegate.findById(id);
		if (person == null) 
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("person", person);
		model.addAttribute("institutions", institutionDelegate.getInstitution());
		return "persons/update-person";
	}
	
	@PostMapping("/persons/edit/{id}")
	public String updateAutotransition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrig.class) @ModelAttribute("person") Person person, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("person", person);
				model.addAttribute("institutions", institutionDelegate.getInstitution());
				return "persons/update-person";
			}
			personDelegate.delete(person);
		}
		return "redirect:/persons/";
	}
}
