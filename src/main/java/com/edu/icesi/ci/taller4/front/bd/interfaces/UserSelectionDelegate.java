package com.edu.icesi.ci.taller4.front.bd.interfaces;

import com.edu.icesi.ci.taller4.front.model.clases.Userselect;

public interface UserSelectionDelegate {
	public Iterable<Userselect> findAll();
	public Userselect save(Userselect userselect);
	public Userselect findById(long id);
	public void delete(Userselect userselect);	
	public void edit(long id, Userselect userselect);
}
