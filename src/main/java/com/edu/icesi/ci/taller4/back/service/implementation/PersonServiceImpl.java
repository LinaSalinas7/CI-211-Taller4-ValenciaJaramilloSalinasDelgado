package com.edu.icesi.ci.taller4.back.service.implementation;

import java.util.List;

import com.edu.icesi.ci.taller4.back.repository.PersonRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.PersonService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.daos.PersonDao;
import com.edu.icesi.ci.taller4.back.model.Person;

@Service
public class PersonServiceImpl implements PersonService{
	
	private PersonDao personDao;
	
	
	public PersonServiceImpl(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@Override
	@Transactional
	public void save(Person person) {
		personDao.Save(person);
		
	}

	@Override
	@Transactional
	public Iterable<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	@Transactional
	public Person findById(long id) {
		return personDao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Person Person) {
		personDao.Delete(Person);
		
	}

	@Override
	public void edit(Person Person) {
		personDao.Edit(Person);
		
	}

}
