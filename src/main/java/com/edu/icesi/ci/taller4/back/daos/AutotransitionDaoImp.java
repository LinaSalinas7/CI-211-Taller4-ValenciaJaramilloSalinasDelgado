package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.Autotransition;

@Repository
@Scope("singleton")
public class AutotransitionDaoImp implements AutotransitionDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void Save(Autotransition entity) {
		em.persist(entity);
	}
	
	@Override	
	@Transactional
	public void Delete(Autotransition entity) {
		Autotransition attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
	}
	
	@Override	
	@Transactional
	public void Edit(Autotransition entity) {
		em.merge(entity);
	}
	
	@Override
	public Autotransition findById(long id) {
		return em.find(Autotransition.class, id);
	}
	
	@Override
	public List<Autotransition> findByName(String name) {
		String q =  "SELECT auto FROM Autotransition auto WHERE auto.autotranName = :name";
		Query query = em.createQuery(q);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	@Override
	public List<Autotransition> findByActive(String active) {
		String q =  "SELECT auto FROM Autotransition auto WHERE auto.autotranIsactive = :active";
		Query query = em.createQuery(q);
		query.setParameter("active", active);
		return query.getResultList();
	}
	
	@Override
	public List<Autotransition> findAll(){
		String q = "SELECT auto FROM Autotransition auto";
		return em.createQuery(q).getResultList();
	}
}
