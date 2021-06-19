package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Institution;

public interface InstitutionDao {
	void save(Institution entity);
	void delete(Institution entity);
	void edit(Institution entity);
	Institution findById(long id);
	List<Institution>  findAll();
}
