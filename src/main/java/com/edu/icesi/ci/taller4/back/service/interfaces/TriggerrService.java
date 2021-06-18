package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Triggerr;

public interface TriggerrService {
<<<<<<< HEAD
	public boolean saveTriggerr(long id, String scope, String Name, long triggertypeID);
	public boolean editTriggerr(long id, String newScope, String newName);
	public Iterable<Triggerr> findAll();
	public Triggerr save(Triggerr trigger);
	public Optional<Triggerr> findById(long id);
=======
	
	public void edit(Triggerr triggerr);
	public Iterable<Triggerr> findAll();
	public void save(Triggerr trigger);
	public Triggerr findById(long id);
>>>>>>> 25644786973967410a755f142756a77da358ab9c
	public void delete(Triggerr triggerr);
}
