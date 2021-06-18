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

import com.edu.icesi.ci.taller4.back.model.Userselect;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggerrService;
import com.edu.icesi.ci.taller4.back.service.interfaces.UserselectService;
import com.edu.icesi.ci.taller4.back.validations.CrearUssel;
import com.edu.icesi.ci.taller4.back.validations.EditarUssel;
import com.edu.icesi.ci.taller4.front.controller.interfaces.UserselectController;

@Controller
public class UserselectControllerImp implements UserselectController{
	
	private UserselectService userservice;
	private TriggerrService trigservice;
	

	@Autowired	
	public UserselectControllerImp(UserselectService userservice,TriggerrService trigservice) {
		this.userservice = userservice;
		this.trigservice = trigservice;		
	}
		
	@GetMapping("/userselects/")
	public String indexUserselects(Model model) {
		model.addAttribute("userselects", userservice.findAll());
		return "userselects/index";
	}
	
	@GetMapping("/userselects/add")
	public String addUserselect(Model model) {
		model.addAttribute("userselect", new Userselect());
		model.addAttribute("triggerrs", trigservice.findAll());
		return "userselects/add-userselect";
	}
		
	@PostMapping("/userselects/add")
	public String saveUserselect(@Validated(CrearUssel.class) @ModelAttribute("userselect") Userselect userselect, 
			BindingResult bindingresult, @RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {				
				model.addAttribute("triggerrs", trigservice.findAll());
			 	return "userselects/add-userselect";
			}			
			else {
				userservice.save(userselect);
			}			
		return "redirect:/userselects/";
	}

	@GetMapping("/userselects/del/{id}")
	public String deleteUserselect(@PathVariable("id") long id, Model model) {
		Userselect ussel = userservice.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userservice.delete(ussel);
		model.addAttribute("userselects", userservice.findAll());
		return "userselects/index";
	}

	@GetMapping("/userselects/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Optional<Userselect> userselect = userservice.findById(id);
		if (userselect == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("userselect", userselect.get());
		model.addAttribute("triggerrs", trigservice.findAll());
		return "userselects/update-userselect";
	}

	@PostMapping("/userselects/edit/{id}")
	public String updateUser(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true) String action, 
			@Validated(EditarUssel.class) @ModelAttribute("userselect") Userselect userselect, 
			BindingResult bindingresult, Model model) {
		if (action != null && !action.equals("Cancel")) {
			if(bindingresult.hasErrors()) {
				model.addAttribute("userselect", userselect);
				model.addAttribute("triggerrs", trigservice.findAll());
				return "userselects/update-userselect";
			}
			userservice.save(userselect);			
		}
		return "redirect:/userselects/";
	}
}