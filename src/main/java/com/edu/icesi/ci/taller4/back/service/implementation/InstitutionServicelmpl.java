package com.edu.icesi.ci.taller4.back.service.implementation;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.edu.icesi.ci.taller4.back.exception.*;
import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.back.repository.InstitutionRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.InstitutionService;

@Service
public class InstitutionServicelmpl implements InstitutionService {
	
	private InstitutionRepository institutionRepository;
	
	@Autowired
	public InstitutionServicelmpl(InstitutionRepository institutionRepository) {
		this.institutionRepository=institutionRepository;
	}

	@Override
	public Institution crearInstitucion(Institution institution) throws LogicalException {
		if(institution==null) {
			throw new LogicalException("La institución no puede ser nula");
		}
		else if(institution.getInstName().equals("") || institution.getInstName() == null){
			throw new LogicalException("La isntitución debe tener un nombre");	
		}
		institutionRepository.save(institution);
		return institution	;
	}	


	@Override
	public Institution getInstitutionById(long id) throws LogicalException {
		try {
			Institution institution = institutionRepository.findById(id).get();
			return institution;
		}catch(NoSuchElementException e) {
			throw new LogicalException("No se ha encontrado la institución");
			
		}
		
	}
	
	@Override
	public Optional<Institution> search (long id){
		Optional<Institution> optional = institutionRepository.findById(id);
		return optional;
	}
	
	@Override
	public Iterable<Institution> findAll(){
		return institutionRepository.findAll();
		
	}

	@Override
	public Institution save(Institution institution) {
		return institutionRepository.save(institution);
	}


}
