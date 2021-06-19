package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Triggerr;

public interface TriggerrService {	
	public Iterable<Triggerr> findAll();
	public void save(Triggerr trigger);
	public Triggerr findById(long id);	
	public void edit(long id, Triggerr trigger);
	public void delete(Triggerr triggerr);
}
