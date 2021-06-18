package com.edu.icesi.ci.taller4.back.service.interfaces;


import com.edu.icesi.ci.taller4.back.model.Triggertype;

public interface TriggertypeService{
	
	public void editTriggerType(Triggertype trigtype);
	public Iterable<Triggertype> findAll();
	public void save(Triggertype trigtype);
	public Triggertype findById(long id);
	public void delete(Triggertype trigtype);
}
