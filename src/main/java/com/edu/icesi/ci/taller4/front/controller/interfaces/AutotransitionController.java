package com.edu.icesi.ci.taller4.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.icesi.ci.taller4.front.model.clases.Autotransition;
import com.edu.icesi.ci.taller4.back.validations.CrearAutotran;
import com.edu.icesi.ci.taller4.back.validations.EditarTrig;

public interface AutotransitionController {
	public String indexAutotransition(Model model);
	public String addAutotransition(Model model);
	public String saveAutotransition(@Validated(CrearAutotran.class) @ModelAttribute("autotransition") Autotransition autotransition
			,BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model);
	public String deleteAutotransition(@PathVariable("id") long id, Model model);
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	public String updateAutotransition(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarTrig.class) @ModelAttribute("autotransition") Autotransition autotransition, 
			BindingResult bindingresult, Model model);
}
