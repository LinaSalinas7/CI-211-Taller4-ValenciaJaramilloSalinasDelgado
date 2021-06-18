package com.edu.icesi.ci.taller4.back.service.interfaces;

<<<<<<< HEAD
import java.util.List;
=======
public interface PersonService {
>>>>>>> 25644786973967410a755f142756a77da358ab9c

import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.model.PersonRole;

public interface PersonService {
	
	public List<PersonRole> getPersonRoles(Person person);
	public void save(Person person);
}
