package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonDao {
	
	public void Save(Person entity);
	public void Delete(Person entity);
	public void Edit(Person entity);
	public Person findById(long id);
	public List<Person> findByName(String name);
	public List<Person> findAll();

}
