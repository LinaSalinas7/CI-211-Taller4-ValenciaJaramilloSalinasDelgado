package com.edu.icesi.ci.taller4.back.service.interfaces;

//import java.util.Optional;


public interface TriggerrService {
	public boolean saveTriggerr(long id, String scope, String Name, long triggertypeID);
	public boolean editTriggerr(long id, String newScope, String newName);
	/*public Iterable<Triggerr> findAll();
	public Triggerr save(Triggerr trigger);
	public Optional<Triggerr> findById(long id);
	public void delete(Triggerr triggerr);*/
}
