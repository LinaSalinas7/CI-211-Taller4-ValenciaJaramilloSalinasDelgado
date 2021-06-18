package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Autotransition;

public interface AutotransitionDao {
	public void Save(Autotransition entity);
	public void Delete(Autotransition entity);
	public void Edit(Autotransition entity);
	public Autotransition findById(long id);
	public List<Autotransition> findByName(String name);
	public List<Autotransition> findByActive(String active);	
	public List<Autotransition> findAll();
}
