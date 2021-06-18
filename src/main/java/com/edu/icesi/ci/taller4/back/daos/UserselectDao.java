package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Userselect;

public interface UserselectDao {
	public void Save(Userselect entity);
	public void Delete(Userselect entity);
	public void Edit(Userselect entity);
	public List<Userselect> findTriggerrById(long id);
	public Userselect findById(long id);
	public List<Userselect> findByName(String name);	
	public List<Userselect> findByValueKeyColumn(String valuekeycolumn);
	public List<Userselect> findAll();
}
