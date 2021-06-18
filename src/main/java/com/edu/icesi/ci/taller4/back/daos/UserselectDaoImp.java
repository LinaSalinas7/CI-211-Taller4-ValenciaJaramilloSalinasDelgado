package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.Userselect;

@Repository
@Scope("singleton")
public class UserselectDaoImp implements UserselectDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void Save(Userselect entity) {
		em.persist(entity);
	}
	
	@Override
	@Transactional
	public void Delete(Userselect entity) {
		Userselect attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
	}
	
	@Override
	@Transactional
	public void Edit(Userselect entity) {
		em.merge(entity);
	}
	
	@Override
	public Userselect findById(long id) {
		return em.find(Userselect.class, id);
	}

	@Override
	public List<Userselect> findTriggerrById(long id) {
		String q = "SELECT u FROM Userselect u WHERE u.triggerr.trigId = :id";
		Query query = em.createQuery(q);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	@Override
	public List<Userselect> findByName(String name) {
		String q =  "SELECT u FROM Userselect u WHERE u.usselTablename = :name";
		Query query = em.createQuery(q);
		query.setParameter("name", name);
		return query.getResultList();
	}
		
	@Override
	public List<Userselect> findByValueKeyColumn(String valuekeycolumn) {
		String q =  "SELECT u FROM Userselect u WHERE u.usselValuekeycolumn = :valuekeycolumn";
		Query query = em.createQuery(q);
		query.setParameter("valuekeycolumn", valuekeycolumn);
		return query.getResultList();
	}

	@Override
	public List<Userselect> findAll() {
		String q = "SELECT u FROM Userselect u";
		return em.createQuery(q).getResultList();
	}
}
