package com.edu.icesi.ci.taller4.back.restController;


import com.edu.icesi.ci.taller4.back.model.Person;

public interface PersonRestController {
    public Iterable<Person> getPersons();
    Person getPerson(long persId);
}
