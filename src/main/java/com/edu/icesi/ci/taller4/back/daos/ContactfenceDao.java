package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Contactfence;

public interface ContactfenceDao {

	void save(Contactfence entity);
	void delete(Contactfence entity);
	void edit(Contactfence entity);
	Contactfence findById(long id);
	List<Contactfence>  findAll();

}
