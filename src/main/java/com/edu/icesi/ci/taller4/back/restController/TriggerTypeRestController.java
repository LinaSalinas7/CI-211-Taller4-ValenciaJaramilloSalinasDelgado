package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.web.bind.annotation.PathVariable;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
import com.edu.icesi.ci.taller4.back.model.Triggertype;

public interface TriggerTypeRestController {
	
	public Iterable<Triggertype> indexTriggerr();
	public void saveTriggertype(Triggertype triggerrtype);
	public void deleteTriggertype(Triggertype triggertype)throws LogicalException;
	public Triggertype showTriggertype(@PathVariable("id") long id);
	public void updateTriggertype(Triggertype triggertype)throws LogicalException;

}
