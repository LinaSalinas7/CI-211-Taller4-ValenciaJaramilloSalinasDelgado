package com.edu.icesi.ci.taller4.back.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller3persistencia.model.Triggertype;


@Repository
@Scope("singleton")
public class TriggertypeDaoImp implements TriggertypeDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void Save(Triggertype entity) {
		em.persist(entity);
	}
	
	@Override
	public Triggertype findById(long id) {
		return em.find(Triggertype.class, id);
	}
}
