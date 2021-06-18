package com.edu.icesi.ci.taller4.back.daos;

import com.edu.icesi.ci.taller4.back.model.Triggertype;

public interface TriggertypeDao {
	public void Save(Triggertype entity);
	public Triggertype findById(long id);
}
