package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.Triggertype;


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
	@Transactional
	public Triggertype findById(long id) {
		return em.find(Triggertype.class, id);
	}

	@Override
	@Transactional
	public void Delete(Triggertype entity) {
		Triggertype attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
		
	}

	@Override
	@Transactional
	public void Edit(Triggertype entity) {
		em.merge(entity);
		
	}

	@Override
	public List<Triggertype> findAll() {
		String q = "SELECT t FROM Triggertype t";
		return em.createQuery(q).getResultList();
	}
}
