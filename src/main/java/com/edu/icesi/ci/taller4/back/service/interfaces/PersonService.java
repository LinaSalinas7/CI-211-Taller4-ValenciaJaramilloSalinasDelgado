package com.edu.icesi.ci.taller4.back.service.interfaces;

import java.util.List;

import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.model.PersonRole;

public interface PersonService {
	
	public List<PersonRole> getPersonRoles(Person person);
	public void save(Person person);
}
