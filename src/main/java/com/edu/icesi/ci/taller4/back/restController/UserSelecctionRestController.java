package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.icesi.ci.taller4.back.model.Userselect;

public interface UserSelecctionRestController {
	
	public Iterable<Userselect> indexTriggerr();
	public void save(@RequestBody Userselect userselect);
	public Userselect showUserselect(@PathVariable("usselId") long id);	
	public void updateUserselect(@PathVariable("usselId") long id, @RequestBody Userselect userselect);
	public void delete(@PathVariable("usselId") long id);

}
