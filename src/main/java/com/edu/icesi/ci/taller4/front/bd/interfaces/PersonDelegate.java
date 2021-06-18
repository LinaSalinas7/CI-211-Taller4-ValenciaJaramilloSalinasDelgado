package com.edu.icesi.ci.taller4.front.bd.interfaces;

import com.edu.icesi.ci.taller4.front.model.clases.Person;

public interface PersonDelegate {
	
	public Iterable<Person> findAll();
	public Person save(Person person);
	public Person findById(long id);
	public void delete(Person person);
	public void edit(Person person);

}
