package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonDao {
	void save(Person entity);

	void delete(Person entity);

	void edit(Person entity);

	Person findById(long id);
	
	List<Person>  findAll();
}
