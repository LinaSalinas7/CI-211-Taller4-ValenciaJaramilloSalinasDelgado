package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Triggertype;

@Repository
@Scope("singleton")
public class TriggerrDaoImp implements TriggerrDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void Save(Triggerr entity) {
		em.persist(entity);
	}
	
	@Override
	@Transactional
	public void Delete(Triggerr entity) {
		Triggerr attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
	}
	
	@Override
	@Transactional
	public void Edit(Triggerr entity) {
		em.merge(entity);
	}
	
	@Override
	public Triggerr findById(long id) {
		return em.find(Triggerr.class, id);
	}
	
	@Override
	public List<Triggerr> findByName(String name) {
		String q =  "SELECT t FROM Triggerr t WHERE t.trigName = :name";
		Query query = em.createQuery(q);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	@Override
	public List<Triggerr> findByScope(String scope) {
		String q =  "SELECT t FROM Triggerr t WHERE t.trigScope = :scope";
		Query query = em.createQuery(q);
		query.setParameter("scope", scope);
		return query.getResultList();
	}
	
	@Override
	public List<Triggerr> findByTriggerType(Triggertype triggertype) {
		long id = triggertype.getTrigtypeId(); 
		String q =  "SELECT t FROM Triggerr t WHERE t.triggertype.trigtypeId = :id";
		Query query = em.createQuery(q);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	@Override
	public List<Triggertype> findIfLocalScope(){		
		String q = "SELECT t.triggertype.trigtypeName, SUM(t.trigId) " +
				   "FROM Triggerr t " + 
				   "WHERE t.trigScope = Local " + 
				   "GROUP BY t.triggertype.trigtypeName";
		Query query = em.createQuery(q);
		return query.getResultList();
	}
	
	@Override
	public List<Triggertype> findIfUserSelectValueIsOne(){		
		String q = "";
		Query query = em.createQuery(q);
		return query.getResultList();
	}

	@Override
	public List<Triggerr> findAll() {
		String q = "SELECT t FROM Triggerr t";
		return em.createQuery(q).getResultList();
	}
}
