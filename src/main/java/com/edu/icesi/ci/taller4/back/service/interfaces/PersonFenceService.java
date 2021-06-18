package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.PersonFence;

public interface PersonFenceService {
	
	public Iterable<PersonFence> findAll();
	public void save(PersonFence personFence);
	public PersonFence findById(long id);
	public void delete(PersonFence personFence);
	public void edit(PersonFence personFence);

}
