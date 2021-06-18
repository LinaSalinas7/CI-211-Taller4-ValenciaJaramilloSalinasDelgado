package com.edu.icesi.ci.taller4.back.service.interfaces;

import java.util.Optional;

import com.edu.icesi.ci.taller4.back.exception.*;
import com.edu.icesi.ci.taller4.back.model.Institution;

public interface InstitutionService{
	
	public Institution crearInstitucion(Institution institution) throws LogicalException;
	public Institution getInstitutionById(long id) throws LogicalException;
	public Optional<Institution> search (long id);
	public Iterable<Institution> findAll();
	public Institution save(Institution institution);
	
	
}
