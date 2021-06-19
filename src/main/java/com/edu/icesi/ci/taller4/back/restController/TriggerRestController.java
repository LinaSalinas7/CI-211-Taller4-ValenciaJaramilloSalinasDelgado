package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.icesi.ci.taller4.back.model.Triggerr;

public interface TriggerRestController {

	public Iterable<Triggerr> indexTriggerr();
	public void saveTriggerr(@RequestBody Triggerr triggerr);
	public void deleteTriggerr(@PathVariable("trigId") long id);
	public Triggerr showTriggerr(@PathVariable("trigId") long id);	
	public void updateTriggerr(@PathVariable("trigId") long id, Triggerr triggerr);
}
