package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.Person;

@Repository
@Scope("singleton")
public class PersonDaoImp implements PersonDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Person entity) {
		Person attachedEntity = entityManager.merge(entity); 
		entityManager.persist(attachedEntity);
	}

	@Override
	@Transactional
	public void delete(Person entity) {
		entityManager.remove(entity);
	}

	@Override
	@Transactional
	public void edit(Person entity) {
		entityManager.merge(entity);
	}

	@Override
	@Transactional
	public Person findById(long id) {
		return entityManager.find(Person.class, id);
	}

	@Override
	@Transactional
	public List<Person> findAll() {
		String consulta = "SELECT p FROM Person p";
		return entityManager.createQuery(consulta).getResultList();
	}
}
