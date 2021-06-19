package com.edu.icesi.ci.taller4.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.PersonFenceDao;
import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonFenceService;

@Service
public class PersonFenceServiceImp implements PersonFenceService {

	private PersonFenceDao personFenceDao;

	@Autowired
	public PersonFenceServiceImp(PersonFenceDao personFenceDao) {
		this.personFenceDao = personFenceDao;
	}

	@Override
	public void edit(PersonFence personFence) {
		personFenceDao.edit(personFence);
	}

	@Override
	public Iterable<PersonFence> findAll() {
		return personFenceDao.findAll();
	}

	@Override
	public void save(PersonFence personFence) {
		personFenceDao.save(personFence);
	}

	@Override
	public void delete(PersonFence personFence) {
		personFenceDao.delete(personFence);
	}

	@Override
	public PersonFence findById(long id) {
		return personFenceDao.findById(id);
	}
}
