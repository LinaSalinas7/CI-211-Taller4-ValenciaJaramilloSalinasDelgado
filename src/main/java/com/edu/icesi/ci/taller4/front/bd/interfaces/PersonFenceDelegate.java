package com.edu.icesi.ci.taller4.front.bd.interfaces;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.back.model.PersonFencePK;

public interface PersonFenceDelegate {
	public List<PersonFence> personFenceFindAll();

	public void personFenceSave(PersonFence personFence);
	
	public void personFenceEdit(PersonFence personFence);
	
	public PersonFence personFenceFindById(PersonFencePK id);
	
	public void personFenceDelete(PersonFence id);
}
