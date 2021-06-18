package com.edu.icesi.ci.taller4.back.restController;


import org.springframework.web.bind.annotation.PathVariable;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonRestController {
	public Iterable<Person> indexTriggerr();
	public void savePerson(Person person);
	public void deletePerson(Person person)throws LogicalException;
	public Person showPerson(@PathVariable("id") long id);
	public void updatePerson(Person person)throws LogicalException;
}
