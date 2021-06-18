package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonService {
	
	public Iterable<Person> findAll();
	public void save(Person Person);
	public Person findById(long id);
	public void delete(Person Person);
	public void edit(Person Person);
}
