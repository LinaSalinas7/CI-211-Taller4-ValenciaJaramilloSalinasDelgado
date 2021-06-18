package com.edu.icesi.ci.taller4.back.service.implementation;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.TriggertypeDao;
import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggertypeService;

@Service
@Transactional
public class TriggertypeServiceImp implements TriggertypeService{

	private TriggertypeDao triggertypedao;
	
	@Autowired
	public TriggertypeServiceImp(TriggertypeDao triggertypedao) {
		this.triggertypedao = triggertypedao;
	}

	@Override
	@Transactional
	public void editTriggerType(Triggertype trigtype) {
		triggertypedao.Edit(trigtype);
						
	}

	@Override
	@Transactional
	public Iterable<Triggertype> findAll() {
		return triggertypedao.findAll();
	}

	@Override
	@Transactional
	public void save(Triggertype trigtype) {
		triggertypedao.Save(trigtype);
	}

	@Override
	@Transactional
	public Triggertype findById(long id) {
		return triggertypedao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Triggertype trigtype) {
		triggertypedao.Delete(trigtype);		
	}
}
