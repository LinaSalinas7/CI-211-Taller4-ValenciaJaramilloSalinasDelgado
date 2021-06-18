package com.edu.icesi.ci.taller4.front.bd.interfaces;

import com.edu.icesi.ci.taller4.back.model.PersonFence;

public interface PersonFenceDelegate {

	public Iterable<PersonFence> findAll();
	public PersonFence save(PersonFence personFence);
	public PersonFence findById(long id);
	public void delete(PersonFence personFence);
	public void edit(PersonFence personFence);
}
