package com.edu.icesi.ci.taller4.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.front.validations.CrearTrigTy;
import com.edu.icesi.ci.taller4.front.validations.EditarTrigTy;

public interface TriggertypeController {
	public String indexTriggerTypes(Model model);
	public String addTriggertype(Model model);
	public String saveTriggertype(@Validated(CrearTrigTy.class) @ModelAttribute("triggertype") Triggertype triggertype, BindingResult bindingresult, 
			@RequestParam(value = "action", required = true) String action, Model model);
	public String deleteTriggertype(@PathVariable("id") long id, Model model);
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	public String updateUser(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrigTy.class) @ModelAttribute("triggertype") Triggertype triggertype, 
			BindingResult bindingresult, Model model);
}
