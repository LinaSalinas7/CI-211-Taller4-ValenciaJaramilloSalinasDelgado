package com.edu.icesi.ci.taller4.front.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonFenceDelegate;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonpkDelegate;
import com.edu.icesi.ci.taller4.front.validations.CrearAutotran;
import com.edu.icesi.ci.taller4.front.validations.EditarTrig;

public class PersonFenceControllerImp {
	
	private PersonFenceDelegate perFenDel;
	private PersonpkDelegate perpkDelegate;
	
	@Autowired
	public PersonFenceControllerImp(PersonFenceDelegate perFenDel, PersonpkDelegate perpkDelegate) {
		this.perFenDel = perFenDel;
		this.perpkDelegate = perpkDelegate;
	}
	
	@GetMapping("/personFences/")
	public String indexPersonFence(Model model) {
		model.addAttribute("personFences", perFenDel.findAll());
		return "personFence/index";
	}
	
	@GetMapping("/personFences/add")
	public String addPersonFence(Model model) {
		model.addAttribute("personFence", new PersonFence());
		model.addAttribute("personFencepk", perpkDelegate.findAll());
		return "personFence/add-personFence";
	}
	
	@PostMapping("/personFences/add")
	public String savePersonFences(@Validated(CrearAutotran.class) @ModelAttribute("personFence") PersonFence personFence
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {				
				model.addAttribute("personFencepk", perpkDelegate.findAll());
			 	return "personFence/add-personFence";
			}		
			else {
				perFenDel.save(personFence);
			}			
		return "redirect:/personFence/";
	}
	
	@GetMapping("/personFences/del/{id}")
	public String deletePerson(@PathVariable("id") long id, Model model) {
		PersonFence personFence = perFenDel.findById(id);//.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		perFenDel.delete(personFence);
		model.addAttribute("personFence", perFenDel.findAll());
		return "personFence/index";
	}
	
	@GetMapping("/personFences/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		PersonFence personFence = perFenDel.findById(id);
		if (personFence == null) 
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("personFence", personFence);
		model.addAttribute("personFencepk", perpkDelegate.findAll());
		return "personFence/update-personFence";
	}
	
	@PostMapping("/personFences/edit/{id}")
	public String updateAutotransition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrig.class) @ModelAttribute("personFence") PersonFence personFence, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("personFence", personFence);
				model.addAttribute("personFencepk", perpkDelegate.findAll());
				return "personFence/update-personFence";
			}
			perFenDel.delete(personFence);
		}
		return "redirect:/personFence/";
	}
	
	

}
