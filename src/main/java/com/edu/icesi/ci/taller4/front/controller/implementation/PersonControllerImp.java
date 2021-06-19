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

import com.edu.icesi.ci.taller4.front.bd.interfaces.InstitutionDelegate;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonDelegate;
import com.edu.icesi.ci.taller4.front.validations.CrearPerson;
import com.edu.icesi.ci.taller4.front.validations.EditarPerson;
import com.edu.icesi.ci.taller4.back.model.Person;

@Controller
public class PersonControllerImp {
	
	private PersonDelegate persDelegate;
	private InstitutionDelegate instDelegate;
	
	@Autowired
	public PersonControllerImp( PersonDelegate persDelegate,InstitutionDelegate instDelegate) {
		this.persDelegate = persDelegate;
		this.instDelegate = instDelegate;
	}

	@GetMapping("/person/")
	public String indexPerson(Model model) {
		model.addAttribute("persons", persDelegate.personFindAll());
		return "person/index";
	}

	@GetMapping("/person/add-person")
	public String addPerson(Model model, @ModelAttribute("person") Person person) {
		model.addAttribute("person", new Person());
		model.addAttribute("institution", instDelegate.institutionFindAll());
		return "person/add-person";
	}

	@PostMapping("/person/add-person")
	public String savePerson(@Validated(CrearPerson.class) Person person, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("institution", instDelegate.institutionFindAll());
				return "person/add-person";
			} else {
				persDelegate.personSave(person);
			}
		return "redirect:/person/";
	}

	@GetMapping("/person/edit/{id}")
	public String editPerson(@PathVariable("id") long id, Model model) {
		Person person = persDelegate.personFindById(id);
		if (person == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("person", person);
		model.addAttribute("institution", instDelegate.institutionFindAll());
		return "person/edit-person";
	}

	@PostMapping("/person/edit/{id}")
	public String updatePerson(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(EditarPerson.class) Person person, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("person", person);
				model.addAttribute("institution", instDelegate.institutionFindAll());
				return "person/edit-person";
			}
			persDelegate.personEdit(person);
		}
		return "redirect:/person/";
	}

	@GetMapping("/person/del/{id}")
	public String deletePerson(@PathVariable("id") long id, Model model) {
		Person person = persDelegate.personFindById(id);
		persDelegate.personDelete(person.getPersId());
		return "redirect:/person/";
	}
}
