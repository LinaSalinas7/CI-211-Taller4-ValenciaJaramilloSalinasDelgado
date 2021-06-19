package com.edu.icesi.ci.taller4.front.bd.interfaces;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonDelegate {
	public List<Person> personFindAll();

	public void personSave(Person person);
	
	public void personEdit(Person person);
	
	public Person personFindById(long id);
	
	public void personDelete(long id);
}
