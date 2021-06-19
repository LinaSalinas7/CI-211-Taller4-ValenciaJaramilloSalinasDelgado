package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.edu.icesi.ci.taller4.back.model.Contactfence;


@Repository
@Scope("singleton")
public class ContactfenceDaoImp implements ContactfenceDao{

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void save(Contactfence entity) {
		entityManager.persist(entity);

	}

	@Override
	public void delete(Contactfence entity) {
		entityManager.remove(entity);

	}

	@Override
	public void edit(Contactfence entity) {
		entityManager.merge(entity);

	}

	@Override
	public Contactfence findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contactfence> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
