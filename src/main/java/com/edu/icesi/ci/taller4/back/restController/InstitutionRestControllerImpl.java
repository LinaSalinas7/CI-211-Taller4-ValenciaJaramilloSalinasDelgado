package com.edu.icesi.ci.taller4.back.restController;

import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.back.repository.InstitutionRepository;
import com.edu.icesi.ci.taller4.back.restController.InstitutionRestController;
import com.edu.icesi.ci.taller4.back.service.interfaces.InstitutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-rest/institutions")
public class InstitutionRestControllerImpl implements InstitutionRestController {

	@Autowired
	private  InstitutionService institutionService;
	
	@GetMapping("/")
	public Iterable<Institution> indexInstitution(){
		return institutionService.findAll();
	}
	
	@GetMapping("/{instId}")
	public Institution findByIdInstitution(@PathVariable("instId") long instId) {
		return institutionService.findById(instId);
	}
	
	@PostMapping
	public void saveInstitution(@RequestBody Institution institution) {
		institutionService.save(institution);
	}
	
	@PutMapping
	public void editInstitution(@RequestBody Institution institution) {
		institutionService.edit(institution);
	}
	
	@DeleteMapping("/{instId}")
	public void deleteInstitution(@PathVariable("instId") long id){
		Institution institution = institutionService.findById(id);
		institutionService.delete(institution);
	}
}
