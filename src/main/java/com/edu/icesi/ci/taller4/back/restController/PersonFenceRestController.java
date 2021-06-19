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

import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonFenceService;


@RestController
@RequestMapping("/api-rest/personfence")
public class PersonFenceRestController {
	
	@Autowired
	private PersonFenceService personFenceService;
	
	@GetMapping("/")
	public Iterable<PersonFence> indexPerson(){
		return personFenceService.findAll();
	}
	
	@GetMapping("/{persId}")
	public PersonFence findByIdPerson(@PathVariable("persId") long instId) {
		return personFenceService.findById(instId);
	}
	
	@PostMapping
	public void savePerson(@RequestBody PersonFence personFence) {
		personFenceService.save(personFence);
	}
	
	@PutMapping
	public void editPerson(@RequestBody PersonFence personFence) {
		personFenceService.edit(personFence);
	}	
	
	@DeleteMapping("/{persId}")
	public void deletePerson(@PathVariable("persId") long id){
		PersonFence person = personFenceService.findById(id);
		personFenceService.delete(person);
	}	
}
