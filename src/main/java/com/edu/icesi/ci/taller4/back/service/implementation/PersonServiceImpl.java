package com.edu.icesi.ci.taller4.back.service.implementation;

import java.util.List;

import com.edu.icesi.ci.taller4.back.repository.PersonRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.model.PersonRole;

@Service
public class PersonServiceImpl implements PersonService{
	
	private PersonRepository personRepo;
	
	
	public PersonServiceImpl(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	@Transactional
	@Override
	public List<PersonRole> getPersonRoles(Person person) {
		
		return personRepo.findById(person.getPersId()).get().getPersonRoles();
	}
	
	@Override
	public void save(Person person) {
		personRepo.save(person);
		
	}

}
