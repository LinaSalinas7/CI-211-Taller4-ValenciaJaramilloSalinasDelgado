package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.Autotransition;


public interface AutotransitionService {
	public boolean saveAutoTransition(long id, String active, String name, String operand, long instId, long eventStatusId);	
	public boolean editTransition(long id, String newActive, String newName, String newOperand);
	public Iterable<Autotransition> findAll();
	public Autotransition save(Autotransition autotransition);
	public Autotransition findById(long id);
	public void delete(Autotransition autotransition);
	public void edit(long id, Autotransition autotrans);
}
