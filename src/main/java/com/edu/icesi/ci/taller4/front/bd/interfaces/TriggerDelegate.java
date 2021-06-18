package com.edu.icesi.ci.taller4.front.bd.interfaces;

import com.edu.icesi.ci.taller4.front.model.clases.Triggerr;
public interface TriggerDelegate {
	
	public Iterable<Triggerr> findAll();
	public Triggerr save(Triggerr Triggerr);
	public Triggerr findById(long id);
	public void delete(Triggerr triggerr);
	public void edit(Triggerr triggerr);

}
