package com.edu.icesi.ci.taller4.back.restController;

import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-rest/person")
public class PersonRestControllerImpl implements PersonRestController {

	@Autowired
	private PersonService personService;

	public PersonRestControllerImpl(PersonService personService) {
		this.personService = personService;
	}

	@Override
	@GetMapping("/")
	public Iterable<Person> indexTriggerr(){
		return personService.findAll();
	}

	@Override
	@PostMapping
	public void savePerson(@RequestBody Person person) {
		personService.save(person);
	}

	@Override	
	@DeleteMapping("/{persId}")
	public void deletePerson(@PathVariable("persId") long id){
		Person person = personService.findById(id);
		personService.delete(person);
	}

	@Override
	@GetMapping("/{persId}")
	public Person showPerson(@PathVariable("persId") long id) {
		return personService.findById(id);
	}

	@Override	
	@PutMapping("/{persId")
	public void updatePerson(@PathVariable("persId") long id, @RequestBody Person person){
		personService.edit(person);
	}
}
