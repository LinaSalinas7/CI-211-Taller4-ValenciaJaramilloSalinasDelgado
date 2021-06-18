package com.edu.icesi.ci.taller4.back.service.interfaces;

import java.util.Optional;

import com.edu.icesi.ci.taller4.back.model.Triggertype;

public interface TriggertypeService{
	public boolean saveTriggerType(long id, String name, long instId);
	public void editTriggerType(long id,Triggertype triggertype);
	public Iterable<Triggertype> findAll();
	public Triggertype save(Triggertype trigtype);
	public Optional<Triggertype> findById(long id);
	public void delete(Triggertype trigtype);
}
