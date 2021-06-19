package com.edu.icesi.ci.taller4.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.model.FevInstitution;
import com.edu.icesi.ci.taller4.back.repository.FevInstitutionRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.FevInstitutionService;

@Service
public class FevInstitutionServiceImp implements FevInstitutionService {

	private FevInstitutionRepository fevInstitutionRepository;

	@Autowired
	public FevInstitutionServiceImp(FevInstitutionRepository fevInstitutionRepository) {
		this.fevInstitutionRepository = fevInstitutionRepository;
	}

	@Override
	public Iterable<FevInstitution> findAll() {
		return fevInstitutionRepository.findAll();
	}

	@Override
	public FevInstitution save(FevInstitution institution) {
		return fevInstitutionRepository.save(institution);
	}	
}
