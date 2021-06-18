package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Triggertype;

public interface TriggertypeDao {
	public void Save(Triggertype entity);
	public Triggertype findById(long id);
	public void Delete(Triggertype entity);
	public void Edit(Triggertype entity);
	public List<Triggertype> findAll();
}
