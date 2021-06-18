package com.edu.icesi.ci.taller4.back.restController;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PostMapping("/save")
	public void savePerson(Person person) {
		personService.save(person);
		
	}

	@Override
	@DeleteMapping("/delete/{persId}")
	public void deletePerson(Person person) throws LogicalException {
		try {
			personService.delete(person);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@GetMapping("/show/{persId}")
	public Person showPerson(long id) {
		try {
			return personService.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	@PutMapping("/edit")
	public void updatePerson(Person person) throws LogicalException {
		personService.edit(person);
		
	}
}
