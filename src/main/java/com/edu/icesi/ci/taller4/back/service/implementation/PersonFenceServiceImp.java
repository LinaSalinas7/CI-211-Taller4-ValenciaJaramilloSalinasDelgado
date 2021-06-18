package com.edu.icesi.ci.taller4.back.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.PersonFenceDao;
import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonFenceService;

@Service
public class PersonFenceServiceImp implements PersonFenceService{
	
	private PersonFenceDao personFenceDao;
	
	@Autowired
	public PersonFenceServiceImp(PersonFenceDao personFenceDao) {
		this.personFenceDao = personFenceDao;
	}
	
	@Override
	@Transactional
	public Iterable<PersonFence> findAll() {
		return personFenceDao.findAll();
	}


	@Override
	@Transactional
	public void save(PersonFence personFence) {
		personFenceDao.Save(personFence);
		
	}

	@Override
	public PersonFence findById(long id) {
		return personFenceDao.findById(id);
	}

	@Override
	public void delete(PersonFence personFence) {
		personFenceDao.Delete(personFence);
		
	}

	@Override
	public void edit(PersonFence personFence) {
		personFenceDao.Edit(personFence);
		
	}

	
}
