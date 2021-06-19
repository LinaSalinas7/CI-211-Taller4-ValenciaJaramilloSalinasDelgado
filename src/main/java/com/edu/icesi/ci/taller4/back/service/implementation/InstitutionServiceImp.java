package com.edu.icesi.ci.taller4.back.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.InstitutionDao;
import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.back.service.interfaces.InstitutionService;


@Service
public class InstitutionServiceImp implements InstitutionService{
	
	private InstitutionDao institutionDao;
	
	@Autowired
	public InstitutionServiceImp(InstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}
	
	@Override
	public void save(Institution entity) {
		institutionDao.save(entity);
	}

	@Override
	public void delete(Institution entity) {
		institutionDao.delete(entity);
	}

	@Override
	public void edit(Institution entity) {
		institutionDao.edit(entity);
	}

	@Override
	public Institution findById(long id) {
		return institutionDao.findById(id);
	}

	@Override
	public List<Institution> findAll() {
		return institutionDao.findAll();
	}
}
