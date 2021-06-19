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

import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.back.model.PersonFencePK;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonDelegate;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonFenceDelegate;
import com.edu.icesi.ci.taller4.front.validations.CrearPersF;
import com.edu.icesi.ci.taller4.front.validations.EditarPersF;

@Controller
public class PersonFenceController {

	private PersonFenceDelegate persfendelegate;
	private PersonDelegate persdelegate;

	@Autowired
	public PersonFenceController(PersonFenceDelegate persfendelegate,PersonDelegate persdelegate) {
		this.persfendelegate = persfendelegate;
		this.persdelegate = persdelegate;
	}

	@GetMapping("/personfence/")
	public String indexPersonFence(Model model) {
		model.addAttribute("personfences", persfendelegate.personFenceFindAll());
		return "personfence/index";
	}

	@GetMapping("/personfence/add-personfence")
	public String addPersonFence(Model model, @ModelAttribute("personfence") PersonFence personFence) {
		model.addAttribute("personfence", new PersonFence());
		model.addAttribute("person", persdelegate.personFindAll());
		return "personfence/add-personfence";
	}

	@PostMapping("/personfence/add-personfence")
	public String savePerson(@Validated(CrearPersF.class) PersonFence personFence, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("person", persdelegate.personFindAll());
				return "personfence/add-personfence";
			} else {
				persfendelegate.personFenceSave(personFence);
			}
		return "redirect:/personfence/";
	}

	@GetMapping("/personfence/edit/{id}/{id2}")
	public String editPerson(@PathVariable("id") long id,@PathVariable("id2") long id2, Model model) {
		PersonFencePK pfPK = new PersonFencePK();
		pfPK.setPersPersId(id);
		pfPK.setContfenContfenId(id2);
		PersonFence personFence = persfendelegate.personFenceFindById(pfPK);
		
		if (personFence == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("personfence", personFence);
		model.addAttribute("person", persdelegate.personFindAll());
		return "personfence/edit-personfence";
	}

	@PostMapping("/personfence/edit/{id}/{id2}")
	public String updatePersonFence(@PathVariable("id") long id,@PathVariable("id2") long id2,
			@RequestParam(value = "action", required = true) String action,
			@Validated(EditarPersF.class) PersonFence personFence, BindingResult bindingResult, Model model) {
		PersonFencePK pfPK = new PersonFencePK();
		pfPK.setPersPersId(id);
		pfPK.setContfenContfenId(id2);
		
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				personFence.setId(pfPK);
				model.addAttribute("personfence", personFence);
				model.addAttribute("person", persdelegate.personFindAll());
				return "personfence/edit-personfence";
			}
			personFence.setId(pfPK);
			persfendelegate.personFenceEdit(personFence);
		}
		return "redirect:/personfence/";
	}

	@GetMapping("/personfence/del/{id}/{id2}")
	public String deletePerson(@PathVariable("id") long id,@PathVariable("id2") long id2, Model model) {
		PersonFencePK pfPK = new PersonFencePK();
		pfPK.setPersPersId(id);
		pfPK.setContfenContfenId(id2);		
		PersonFence personFence = persfendelegate.personFenceFindById(pfPK);

		persfendelegate.personFenceDelete(personFence);
		return "redirect:/personfence/";
	}
}
