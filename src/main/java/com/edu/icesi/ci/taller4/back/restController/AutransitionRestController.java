package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.web.bind.annotation.PathVariable;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
import com.edu.icesi.ci.taller4.back.model.Autotransition;

public interface AutransitionRestController {

	public Iterable<Autotransition> indexAutotransition();
	public void saveAutotransition(Autotransition autotransition);
	public void deleteAutotransition(Autotransition autotransition)throws LogicalException;
	public Autotransition showAutotransition(@PathVariable("id") long id);
	public void updateAutotransition(Autotransition autotransition)throws LogicalException;
}
 