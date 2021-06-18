package com.edu.icesi.ci.taller4.front.controller.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.icesi.ci.taller4.front.model.clases.Userselect;
import com.edu.icesi.ci.taller4.front.validations.CrearUssel;
import com.edu.icesi.ci.taller4.front.validations.EditarUssel;

public interface UserselectController {
	public String indexUserselects(Model model);
	public String addUserselect(Model model);
	public String saveUserselect(@Validated(CrearUssel.class) @ModelAttribute("userselect") Userselect userselect, 
			BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model);
	public String deleteUserselect(@PathVariable("id") long id, Model model);
	public String showUpdateForm(@PathVariable("id") long id, Model model);
	public String updateUser(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarUssel.class) @ModelAttribute("userselect") Userselect userselect, 
			BindingResult bindingresult, Model model);
}
