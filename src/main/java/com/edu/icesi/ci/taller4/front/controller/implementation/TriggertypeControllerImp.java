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

import com.edu.icesi.ci.taller4.front.model.clases.Triggertype;
import com.edu.icesi.ci.taller4.front.validations.CrearTrigTy;
import com.edu.icesi.ci.taller4.front.validations.EditarTrigTy;
import com.edu.icesi.ci.taller4.front.bd.interfaces.FetInstitutionDelegate;
import com.edu.icesi.ci.taller4.front.bd.interfaces.TriggerTypeDelegate;
import com.edu.icesi.ci.taller4.front.controller.interfaces.TriggertypeController;

@Controller
public class TriggertypeControllerImp implements TriggertypeController{
	
	private TriggerTypeDelegate trigtypedelegate;
	private FetInstitutionDelegate fevinstdelegate;

	@Autowired	
	public TriggertypeControllerImp(TriggerTypeDelegate trigtypedelegate,FetInstitutionDelegate fevinstdelegate) {
		this.trigtypedelegate = trigtypedelegate;
		this.fevinstdelegate = fevinstdelegate;
	}
		
	@GetMapping("/triggertypes/")
	public String indexTriggerTypes(Model model) {
		model.addAttribute("triggertypes", trigtypedelegate.findAll());
		return "triggertypes/index";
	}
	
	@GetMapping("/triggertypes/add")
	public String addTriggertype(Model model) {
		model.addAttribute("triggertype", new Triggertype());
		model.addAttribute("fevInstitutions", fevinstdelegate.findAll());
		return "triggertypes/add-triggertype";
	}
		
	@PostMapping("/triggertypes/add")
	public String saveTriggertype(@Validated(CrearTrigTy.class) @ModelAttribute("triggertype") Triggertype triggertype, BindingResult bindingresult, 
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel"))
			if(bindingresult.hasErrors()) {	
				model.addAttribute("fevInstitutions", fevinstdelegate.findAll());
			 	return "triggertypes/add-triggertype";
			}
			else {
				trigtypedelegate.save(triggertype);
		}
		return "redirect:/triggertypes/";
	}

	@GetMapping("/triggertypes/del/{id}")
	public String deleteTriggertype(@PathVariable("id") long id, Model model) {
		Triggertype trigtype = trigtypedelegate.findById(id);
		trigtypedelegate.delete(trigtype);
		model.addAttribute("triggertypes", trigtypedelegate.findAll());
		return "triggertypes/index";
	}

	@GetMapping("/triggertypes/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Triggertype triggertype = trigtypedelegate.findById(id);
		if (triggertype == null) {
			throw new IllegalArgumentException("Invalid user Id:" + id);
		}
		model.addAttribute("triggertype", triggertype);
		model.addAttribute("fevInstitutions", fevinstdelegate.findAll());
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
				model.addAttribute("fevInstitutions", fevinstdelegate.findAll());
				return "triggertypes/update-triggertype";
			}else {				
				trigtypedelegate.edit(id,triggertype);				
			}			
		}
		return "redirect:/triggertypes/";
	}
}