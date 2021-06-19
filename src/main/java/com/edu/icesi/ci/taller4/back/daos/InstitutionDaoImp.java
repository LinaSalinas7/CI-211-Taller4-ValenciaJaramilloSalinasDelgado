package com.edu.icesi.ci.taller4.back.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.edu.icesi.ci.taller4.back.model.Institution;

@Repository
@Scope("singleton")
public class InstitutionDaoImp implements InstitutionDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Institution entity) {
		entityManager.persist(entity);
	}

	@Override
	@Transactional
	public void delete(Institution entity) {
		entityManager.remove(entity);
	}

	@Override
	@Transactional
	public void edit(Institution entity) {
		entityManager.merge(entity);
	}

	@Override
	@Transactional
	public Institution findById(long id) {
		return entityManager.find(Institution.class, id);
	}

	@Override
	@Transactional
	public List<Institution> findAll() {
		String consulta= "SELECT i FROM Institution i";
		return entityManager.createQuery(consulta).getResultList();
	}

}
