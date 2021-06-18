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

import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggerrService;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggertypeService;
import com.edu.icesi.ci.taller4.back.validations.CrearTrig;
import com.edu.icesi.ci.taller4.back.validations.EditarTrig;
import com.edu.icesi.ci.taller4.front.controller.interfaces.TriggerrController;

@Controller
public class TriggerrControllerImp implements TriggerrController{
	
	private TriggerrService trigservice;
	private TriggertypeService trigtypeservice;
	

	@Autowired	
	public TriggerrControllerImp(TriggerrService trigservice,TriggertypeService trigtypeservice) {
		this.trigservice = trigservice;
		this.trigtypeservice = trigtypeservice;
	}
		
	@GetMapping("/triggerrs/")
	public String indexTriggerrs(Model model) {
		model.addAttribute("triggerrs", trigservice.findAll());
		return "triggerrs/index";
	}
	
	@GetMapping("/triggerrs/add")
	public String addTriggerr(Model model) {
		model.addAttribute("triggerr", new Triggerr());
		model.addAttribute("triggerTypes", trigtypeservice.findAll());
		return "triggerrs/add-trigger";
	}
		
	@PostMapping("/triggerrs/add")
	public String saveTriggerr(@Validated(CrearTrig.class) @ModelAttribute("triggerr") Triggerr trigger, 
			BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {				
				model.addAttribute("triggerTypes", trigtypeservice.findAll());
			 	return "triggerrs/add-trigger";
			}			
			else {
				trigservice.save(trigger);
			}			
		return "redirect:/triggerrs/";
	}

	@GetMapping("/triggerrs/del/{id}")
	public String deleteTriggerr(@PathVariable("id") long id, Model model) {
		Triggerr triggerr = trigservice.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		trigservice.delete(triggerr);
		model.addAttribute("triggerrs", trigservice.findAll());
		return "triggerrs/index";
	}


	@GetMapping("/triggerrs/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<Triggerr> triggerr = trigservice.findById(id);
		if (triggerr == null) {
			throw new IllegalArgumentException("Invalid user Id:" + id);
		}
		model.addAttribute("triggerr", triggerr.get());
		model.addAttribute("triggerTypes", trigtypeservice.findAll());
		return "triggerrs/update-trigger";
	}

	@PostMapping("/triggerrs/edit/{id}")
	public String updateTriggerr(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrig.class) @ModelAttribute("triggerr") Triggerr triggerr, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("triggerr", triggerr);
				model.addAttribute("triggerTypes", trigtypeservice.findAll());
				return "triggerrs/update-trigger";
			}
			else {
				trigservice.editTriggerr(id, triggerr);		
			}
		}
		return "redirect:/triggerrs/";
	}
}