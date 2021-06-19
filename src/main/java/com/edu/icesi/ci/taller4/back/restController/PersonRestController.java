package com.edu.icesi.ci.taller4.back.restController;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonRestController {
	public Iterable<Person> indexTriggerr();
	public void savePerson(@RequestBody Person person);	
	public Person showPerson(@PathVariable("persId") long id);	
	public void deletePerson(@PathVariable("persId") long id);
	public void updatePerson(@PathVariable("persId") long id, @RequestBody Person person);
}
