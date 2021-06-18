package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Autotransition;


public interface AutotransitionService {	
	
	public Iterable<Autotransition> findAll();
	public void save(Autotransition autotransition);
	public Autotransition findById(long id);
	public void delete(Autotransition autotransition);
	public void edit( Autotransition autotrans);
}
