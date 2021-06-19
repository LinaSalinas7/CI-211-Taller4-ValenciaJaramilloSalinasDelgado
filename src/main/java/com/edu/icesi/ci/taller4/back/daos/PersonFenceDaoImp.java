package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.icesi.ci.taller4.back.model.PersonFence;

@Repository
@Scope("singleton")
public class PersonFenceDaoImp implements PersonFenceDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(PersonFence entity) {
		entityManager.persist(entity);
	}

	@Override
	@Transactional
	public void delete(PersonFence entity) {
		entityManager.remove(entity);
	}

	@Override
	@Transactional
	public void edit(PersonFence entity) {
		entityManager.merge(entity);
	}

	@Override
	@Transactional
	public PersonFence findById(long id) {
		return entityManager.find(PersonFence.class, id);
	}

	@Override
	@Transactional
	public List<PersonFence> findAll() {
		String consulta = "SELECT p FROM PersonFence p";
		return entityManager.createQuery(consulta).getResultList();
	}
}
