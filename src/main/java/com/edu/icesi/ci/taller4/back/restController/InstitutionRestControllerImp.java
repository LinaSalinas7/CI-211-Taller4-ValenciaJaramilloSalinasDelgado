package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.back.service.interfaces.InstitutionService;


@RestController
@RequestMapping("/backend/institution")
public class InstitutionRestControllerImp {
	
	@Autowired
	private InstitutionService institutionService;
	
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
	
	@DeleteMapping("/del/{instId}")
	public void deleteInstitution(@PathVariable("instId") long id){
		Institution institution = institutionService.findById(id);
		institutionService.delete(institution);
	}	
}
