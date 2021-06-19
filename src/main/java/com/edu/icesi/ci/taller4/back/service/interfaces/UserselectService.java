package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Userselect;

public interface UserselectService {
		
	public Iterable<Userselect> findAll();
	public void save(Userselect userselect);
	public Userselect findById(long id);
	public void delete(Userselect ussel);
	public void edit(long id, Userselect ussel);
}
