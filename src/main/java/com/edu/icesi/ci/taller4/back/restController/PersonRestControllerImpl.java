package com.edu.icesi.ci.taller4.back.restController;

import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.repository.PersonRepository;
import com.edu.icesi.ci.taller4.back.restController.PersonRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonRestControllerImpl implements PersonRestController {

    private PersonRepository personRepository;

    public PersonRestControllerImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @GetMapping("/persons/")
    public Iterable<Person> getPersons(){
        return personRepository.findAll();
    }

    @Override
    @GetMapping("/persons/{persId}")
    public Person getPerson(@PathVariable("persId") long persId) {
        return personRepository.findById(persId).get();
    }
}
