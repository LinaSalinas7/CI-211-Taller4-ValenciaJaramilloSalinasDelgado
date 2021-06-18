package com.edu.icesi.ci.taller4.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.icesi.ci.taller4.front.model.clases.Triggerr;
import com.edu.icesi.ci.taller4.front.validations.CrearTrig;
import com.edu.icesi.ci.taller4.front.validations.EditarTrig;

public interface TriggerrController {
	public String indexTriggerrs(Model model);
	public String addTriggerr(Model model);
	public String saveTriggerr(@Validated(CrearTrig.class) @ModelAttribute("triggerr") Triggerr trigger, 
			BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model);
	public String deleteTriggerr(@PathVariable("id") long id, Model model);
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	public String updateTriggerr(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrig.class) @ModelAttribute("triggerr") Triggerr triggerr, 
			BindingResult bindingresult, Model model); 
}
