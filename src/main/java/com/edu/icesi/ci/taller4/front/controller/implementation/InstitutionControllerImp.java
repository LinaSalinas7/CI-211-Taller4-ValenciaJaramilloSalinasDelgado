package com.edu.icesi.ci.taller4.front.controller.implementation;

import java.io.IOException;
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

import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.front.bd.interfaces.InstitutionDelegate;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonDelegate;
import com.edu.icesi.ci.taller4.front.validations.CrearInstit;
import com.edu.icesi.ci.taller4.front.validations.EditarInstit;

@Controller
public class InstitutionControllerImp {

	private InstitutionDelegate instDelegate;
	private PersonDelegate persDelegate;
	
	@Autowired
	public InstitutionControllerImp(InstitutionDelegate instDelegate, PersonDelegate persDelegate) {
		this.instDelegate = instDelegate;
		this.persDelegate = persDelegate;
	}
	
	@GetMapping("/institution/")
	public String indexInstitution(Model model) throws IOException {
		model.addAttribute("institutions", instDelegate.institutionFindAll());
		return "institution/index";
	}

	@GetMapping("/institution/add-institution")
	public String addInstitution(Model model, @ModelAttribute("person") Institution institution) {
		model.addAttribute("institution", new Institution());
		model.addAttribute("person", persDelegate.personFindAll());
		return "institution/add-institution";
	}

	@PostMapping("/institution/add-institution")
	public String saveInstitution(@Validated(CrearInstit.class)  Institution institution,
			BindingResult bindingResult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				model.addAttribute("person", persDelegate.personFindAll());
				return "institution/add-institution";
			} else {
				instDelegate.institutionSave(institution);
			}
		return "redirect:/institution/";
	}

	@GetMapping("/institution/edit/{id}")
	public String editInstitution(@PathVariable("id") long id, Model model) {
		Institution institution = instDelegate.institutionFindById(id);
		if (institution == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);

		model.addAttribute("institution", institution);
		model.addAttribute("person", persDelegate.personFindAll());
		return "institution/edit-institution";
	}

	@PostMapping("/institution/edit/{id}")
	public String updateInstitution(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action,
			@Validated(EditarInstit.class) Institution institution, BindingResult bindingResult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("institution", institution);
				model.addAttribute("person", persDelegate.personFindAll());
				return "institution/edit-institution";
			}
			instDelegate.institutionEdit(institution);
		}
		return "redirect:/institution/";
	}

	@GetMapping("/institution/del/{id}")
	public String deleteInstitution(@PathVariable("id") long id, Model model) {
		Institution institution = instDelegate.institutionFindById(id);
		instDelegate.institutionDelete(institution.getInstId());
		return "redirect:/institution/";
	}
}
