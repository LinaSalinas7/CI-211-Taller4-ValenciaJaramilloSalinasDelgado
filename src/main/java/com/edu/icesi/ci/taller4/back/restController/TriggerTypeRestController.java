package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.icesi.ci.taller4.back.model.Triggertype;

public interface TriggerTypeRestController {
	
	public Iterable<Triggertype> indexTriggerr();
	public void saveTriggertype(@RequestBody Triggertype triggerrtype);	
	public Triggertype showTriggertype(@PathVariable("trigtypeId") long id);	
	public void updateTriggertype(@PathVariable("trigtypeId") long id, @RequestBody Triggertype triggertype);
	public void deleteTriggertype(@PathVariable("trigtypeId") long id);

}
