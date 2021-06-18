package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.web.bind.annotation.PathVariable;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
import com.edu.icesi.ci.taller4.back.model.Userselect;

public interface UserSelecctionRestController {
	
	public Iterable<Userselect> indexTriggerr();
	public void save(Userselect userselect);
	public void delete(Userselect userselect)throws LogicalException;
	public Userselect showUserselect(@PathVariable("id") long id);
	public void updateUserselect(Userselect userselect)throws LogicalException;

}
