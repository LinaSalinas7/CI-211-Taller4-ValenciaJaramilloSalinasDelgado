package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.web.bind.annotation.PathVariable;

import com.edu.icesi.ci.taller4.back.model.Triggerr;

public interface TriggerRestController {

	public Iterable<Triggerr> indexTriggerr();
	public void saveTriggerr(Triggerr triggerr);
	public void deleteTriggerr(long id);
	public Triggerr showTriggerr(@PathVariable("id") long id);
	public void updateTriggerr(Triggerr triggerr);
}
