package com.edu.icesi.ci.taller4.front.bd.interfaces;

import com.edu.icesi.ci.taller4.front.model.clases.Triggertype;

public interface TriggerTypeDelegate {
	
	public Iterable<Triggertype> findAll();
	public Triggertype save(Triggertype triggertype);
	public Triggertype findById(long id);
	public void delete(Triggertype triggertype);
	public void edit(Triggertype triggertype);

}
