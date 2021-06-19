package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.PersonFence;


public interface PersonFenceDao {
	void save(PersonFence entity);

	void delete(PersonFence entity);

	void edit(PersonFence entity);

	PersonFence findById(long id);
	
	List<PersonFence>  findAll();
}
