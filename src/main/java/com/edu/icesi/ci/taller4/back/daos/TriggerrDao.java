package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Triggertype;

public interface TriggerrDao {
	public void Save(Triggerr entity);
	public void Delete(Triggerr entity);
	public void Edit(Triggerr entity);
	public List<Triggerr> findByName(String name);
	public List<Triggerr> findByScope(String scope);
	public List<Triggerr> findByTriggerType(Triggertype triggertype);
	public List<Triggertype> findIfLocalScope();
	public List<Triggertype> findIfUserSelectValueIsOne();
	public List<Triggerr> findAll();
	public Triggerr findById(long id);
}
