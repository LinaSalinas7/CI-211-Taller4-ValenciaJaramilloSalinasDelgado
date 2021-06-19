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

import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;


@RestController
@RequestMapping("/api-rest/person")
public class PersonRestControllerImp {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public Iterable<Person> indexPerson(){
		return personService.findAll();
	}
	
	@GetMapping("/{persId}")
	public Person findByIdPerson(@PathVariable("persId") long instId) {
		return personService.findById(instId);
	}
	
	@PostMapping
	public void savePerson(@RequestBody Person person) {
		personService.save(person);
	}
	
	@PutMapping
	public void editPerson(@RequestBody Person person) {
		personService.edit(person);
	}
	
	@DeleteMapping("/{persId}")
	public void deletePerson(@PathVariable("persId") long id){
		Person person = personService.findById(id);
		personService.delete(person);
	}	
}
