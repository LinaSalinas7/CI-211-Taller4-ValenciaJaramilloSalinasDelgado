package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.edu.icesi.ci.taller4.back.model.PersonFence;

@Repository
@Scope("singleton")
public class PersonFenceDaoImp implements PersonFenceDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void Save(PersonFence entity) {
		em.persist(entity);
		
	}

	@Override
	@Transactional
	public void Delete(PersonFence entity) {
		em.remove(entity);
		
	}

	@Override
	@Transactional
	public void Edit(PersonFence entity) {
		em.merge(entity);
	}

	@Override
	@Transactional
	public PersonFence findById(long id) {
		return em.find(PersonFence.class, id);
	}

	@Override
	@Transactional
	public List<PersonFence> findAll() {
		String q = "SELECT p FROM PersonFence p";
		return em.createQuery(q).getResultList();
	}
}
