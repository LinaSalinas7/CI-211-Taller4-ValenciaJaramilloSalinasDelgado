package com.edu.icesi.ci.taller4.front.bd.interfaces;

import java.util.List;

import com.edu.icesi.ci.taller4.front.model.clases.Institution;

public interface InstitutionDelegate {
	
	public List<Institution> institutionFindAll();
	public void institutionSave(Institution institution);
	public void institutionEdit(Institution institution);
	public Institution institutionFindById(long id);
	public void institutionDelete(long id);

}
