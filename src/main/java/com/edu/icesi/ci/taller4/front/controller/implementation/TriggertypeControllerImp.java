package com.edu.icesi.ci.taller4.front.controller.implementation;

import java.util.Optional;

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

import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.service.interfaces.FevInstitutionService;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggertypeService;
import com.edu.icesi.ci.taller4.front.controller.interfaces.TriggertypeController;
import com.edu.icesi.ci.taller4.front.validations.CrearTrigTy;
import com.edu.icesi.ci.taller4.front.validations.EditarTrigTy;

@Controller
public class TriggertypeControllerImp implements TriggertypeController{
	
	private TriggertypeService trigtypeservice;
	private FevInstitutionService fevinstservice;

	@Autowired	
	public TriggertypeControllerImp(TriggertypeService trigtypeservice,FevInstitutionService fevinstservice) {
		this.trigtypeservice = trigtypeservice;
		this.fevinstservice = fevinstservice;
	}
		
	@GetMapping("/triggertypes/")
	public String indexTriggerTypes(Model model) {
		model.addAttribute("triggertypes", trigtypeservice.findAll());
		return "triggertypes/index";
	}
	
	@GetMapping("/triggertypes/add")
	public String addTriggertype(Model model) {
		model.addAttribute("triggertype", new Triggertype());
		model.addAttribute("fevInstitutions", fevinstservice.findAll());
		return "triggertypes/add-triggertype";
	}
		
	@PostMapping("/triggertypes/add")
	public String saveTriggertype(@Validated(CrearTrigTy.class) @ModelAttribute("triggertype") Triggertype triggertype, BindingResult bindingresult, 
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {	
				model.addAttribute("fevInstitutions", fevinstservice.findAll());
			 	return "triggertypes/add-triggertype";
			}
			else {
				trigtypeservice.save(triggertype);
		}
		return "redirect:/triggertypes/";
	}

	@GetMapping("/triggertypes/del/{id}")
	public String deleteTriggertype(@PathVariable("id") long id, Model model) {
		Triggertype trigtype = trigtypeservice.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		trigtypeservice.delete(trigtype);
		model.addAttribute("triggertypes", trigtypeservice.findAll());
		return "triggertypes/index";
	}

	@GetMapping("/triggertypes/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<Triggertype> triggertype = trigtypeservice.findById(id);
		if (triggertype == null) {
			throw new IllegalArgumentException("Invalid user Id:" + id);
		}
		model.addAttribute("triggertype", triggertype.get());
		model.addAttribute("fevInstitutions", fevinstservice.findAll());
		return "triggertypes/update-triggertype";
	}

	@PostMapping("/triggertypes/edit/{id}")
	public String updateUser(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrigTy.class) @ModelAttribute("triggertype") Triggertype triggertype, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {				
				model.addAttribute("triggertype", triggertype);
				model.addAttribute("fevInstitutions", fevinstservice.findAll());
				return "triggertypes/update-triggertype";
			}else {				
				trigtypeservice.editTriggerType(id,triggertype);				
			}			
		}
		return "redirect:/triggertypes/";
	}
}