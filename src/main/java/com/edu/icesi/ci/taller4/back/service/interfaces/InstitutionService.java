package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Institution;

public interface InstitutionService {
	public void edit(Institution person);
	public Iterable<Institution> findAll();
	public void save(Institution person);
	public void delete(Institution person);
	public Institution findById(long id);
}
