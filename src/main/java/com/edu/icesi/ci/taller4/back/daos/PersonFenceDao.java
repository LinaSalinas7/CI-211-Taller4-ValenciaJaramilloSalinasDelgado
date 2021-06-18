package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.PersonFence;

public interface PersonFenceDao {
	
	public void Save(PersonFence entity);
	public void Delete(PersonFence entity);
	public void Edit(PersonFence entity);
	public PersonFence findById(long id);
	public List<PersonFence> findAll();

}
