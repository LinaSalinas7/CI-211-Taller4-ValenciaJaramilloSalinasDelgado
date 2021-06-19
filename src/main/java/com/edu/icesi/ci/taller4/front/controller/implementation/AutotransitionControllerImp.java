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

import com.edu.icesi.ci.taller4.front.model.clases.Autotransition;
import com.edu.icesi.ci.taller4.front.validations.CrearAutotran;
import com.edu.icesi.ci.taller4.front.validations.EditarTrig;
import com.edu.icesi.ci.taller4.front.bd.interfaces.AutotransitionDelegate;
import com.edu.icesi.ci.taller4.front.bd.interfaces.FetInstitutionDelegate;
import com.edu.icesi.ci.taller4.front.controller.interfaces.AutotransitionController;

@Controller
public class AutotransitionControllerImp implements AutotransitionController{
	
	private AutotransitionDelegate autotranDele;
	private FetInstitutionDelegate fevInstitutionDele; 

	@Autowired	
	public AutotransitionControllerImp(AutotransitionDelegate autotranDele, FetInstitutionDelegate fevInstitutionDele) {
		this.autotranDele = autotranDele;
		this.fevInstitutionDele = fevInstitutionDele;
	}
		
	@GetMapping("/autotransitions/")
	public String indexAutotransition(Model model) {
		model.addAttribute("autotransitions", autotranDele.findAll());
		return "autotransitions/index";
	}
	
	@GetMapping("/autotransitions/add")
	public String addAutotransition(Model model) {
		model.addAttribute("autotransition", new Autotransition());
		model.addAttribute("fevInstitutions", fevInstitutionDele.findAll());
		return "autotransitions/add-autotransition";
	}
		
	@PostMapping("/autotransitions/add")
	public String saveAutotransition(@Validated(CrearAutotran.class) @ModelAttribute("autotransition") Autotransition autotransition
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {				
				model.addAttribute("fevInstitutions", fevInstitutionDele.findAll());
			 	return "autotransitions/add-autotransition";
			}		
			else {
				autotranDele.save(autotransition);
			}			
		return "redirect:/autotransitions/";
	}

	@GetMapping("/autotransitions/del/{id}")
	public String deleteAutotransition(@PathVariable("id") long id, Model model) {
		Autotransition autotransition = autotranDele.findById(id);//.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		autotranDele.delete(autotransition);
		model.addAttribute("autotransitions", autotranDele.findAll());
		return "autotransitions/index";
	}


	@GetMapping("/autotransitions/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Autotransition autotransition = autotranDele.findById(id);
		if (autotransition == null) 
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("autotransition", autotransition);
		model.addAttribute("fevInstitutions", fevInstitutionDele.findAll());
		return "autotransitions/update-autotransition";
	}

	@PostMapping("/autotransitions/edit/{id}")
	public String updateAutotransition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrig.class) @ModelAttribute("autotransition") Autotransition autotransition, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("Autotransition", autotransition);
				model.addAttribute("fevInstitutions", fevInstitutionDele.findAll());
				return "autotransitions/update-autotransition";
			}
			autotranDele.edit(id, autotransition);
		}
		return "redirect:/autotransitions/";
	}
}