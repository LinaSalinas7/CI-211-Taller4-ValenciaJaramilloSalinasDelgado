package com.edu.icesi.ci.taller4.back.service.interfaces;

import java.util.Optional;

import com.edu.icesi.ci.taller4.back.model.Userr;

public interface UserrService {
	public Userr save(Userr userr);
	public Optional<Userr> findById(long id);	
}
