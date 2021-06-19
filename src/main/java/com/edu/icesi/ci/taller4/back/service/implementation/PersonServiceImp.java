package com.edu.icesi.ci.taller4.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.PersonDao;
import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;

@Service
public class PersonServiceImp implements PersonService {

	private PersonDao personDao;

	@Autowired
	public PersonServiceImp(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void edit(Person person) {
		personDao.edit(person);
	}

	@Override
	public Iterable<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	public void save(Person person) {
		personDao.save(person);
	}

	@Override
	public void delete(Person person) {
		personDao.delete(person);
	}

	@Override
	public Person findById(long id) {
		return personDao.findById(id);
	}
}
