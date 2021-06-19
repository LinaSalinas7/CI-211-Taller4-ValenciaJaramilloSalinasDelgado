package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonService {
	
	public void edit(Person person);
	
	public Iterable<Person> findAll();

	public void save(Person person);

	public void delete(Person person);

	public Person findById(long id);
}
