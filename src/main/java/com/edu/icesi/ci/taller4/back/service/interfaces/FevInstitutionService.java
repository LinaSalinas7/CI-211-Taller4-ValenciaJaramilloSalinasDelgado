package com.edu.icesi.ci.taller4.back.service.interfaces;

import com.edu.icesi.ci.taller4.back.model.FevInstitution;

public interface FevInstitutionService {
	public Iterable<FevInstitution> findAll();
	public FevInstitution save(FevInstitution institution);
}
