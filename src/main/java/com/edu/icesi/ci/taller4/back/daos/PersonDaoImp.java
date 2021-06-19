package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.Person;

@Repository
@Scope("singleton")
public class PersonDaoImp implements PersonDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void Save(Person entity) {
		em.persist(entity);
	}

	@Override
	@Transactional
	public void Delete(Person entity) {
		Person attachedEntity = em.merge(entity);
		em.remove(attachedEntity);		
	}

	@Override
	@Transactional
	public void Edit(Person entity) {
		em.merge(entity);
		
	}

	@Override
	public Person findById(long id) {
		return em.find(Person.class, id);
	}

	@Override
	public List<Person> findByName(String name) {
		String q =  "SELECT p FROM Person p WHERE p.persName = :name";
		Query query = em.createQuery(q);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public List<Person> findAll() {
		String q = "SELECT p FROM Person p";
		return em.createQuery(q).getResultList();
	}
}