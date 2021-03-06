package com.edu.icesi.ci.taller4.front.bd.interfaces;

import com.edu.icesi.ci.taller4.front.model.clases.Autotransition;

public interface AutotransitionDelegate {
	
	public Iterable<Autotransition> findAll();
	public Autotransition save(Autotransition autotransition);
	public Autotransition findById(long id);	
	public void edit(long id, Autotransition autotransition);		
	public void delete(Autotransition autotran);
}
