package com.edu.icesi.ci.taller4.back.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.model.Userr;
import com.edu.icesi.ci.taller4.back.repository.UserrRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.UserrService;

@Service
public class UserrServiceImp implements UserrService{

	private UserrRepository userepo;
	
	@Autowired
	public UserrServiceImp(UserrRepository userepo) {
		this.userepo = userepo;
	}
	
	@Override
	public Userr save(Userr userr) {		
		return userepo.save(userr);
	}

	@Override
	public Optional<Userr> findById(long id) { 
		return userepo.findById(id);		
	}
}
