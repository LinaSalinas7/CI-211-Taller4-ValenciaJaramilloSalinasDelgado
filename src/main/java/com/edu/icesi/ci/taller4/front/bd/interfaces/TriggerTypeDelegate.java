package com.edu.icesi.ci.taller4.front.bd.interfaces;

import com.edu.icesi.ci.taller4.front.model.clases.Triggertype;

public interface TriggerTypeDelegate {

	public Iterable<Triggertype> findAll();
	public Triggertype save(Triggertype triggerr);
	public Triggertype findById(long id);
	public void delete(Triggertype triggerr);
	public void edit(long id, Triggertype triggerr);
	
}
