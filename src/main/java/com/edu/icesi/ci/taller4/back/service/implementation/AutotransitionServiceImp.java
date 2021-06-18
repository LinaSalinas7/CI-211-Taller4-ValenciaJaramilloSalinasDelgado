package com.edu.icesi.ci.taller4.back.service.implementation;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.AutotransitionDao;
import com.edu.icesi.ci.taller4.back.model.Autotransition;
import com.edu.icesi.ci.taller4.back.repository.AutotransitionRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.AutotransitionService;

@Service
public class AutotransitionServiceImp implements AutotransitionService{

	private AutotransitionDao autotrandao;	

	@Autowired
	public AutotransitionServiceImp(AutotransitionDao autotrandao) {
		this.autotrandao = autotrandao;
	}
	
	@Override
	@Transactional
	public void edit(Autotransition autotrans) {
		autotrandao.Edit(autotrans);
								
	}
	
	@Override
	@Transactional
	public Iterable<Autotransition> findAll(){
		return autotrandao.findAll();
	}
	
	@Override
	@Transactional
	public Autotransition findById(long id) {
		return autotrandao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Autotransition autotransition) {
		autotrandao.Delete(autotransition);;
	}

	@Override
	@Transactional
	public void save(Autotransition autotransition) {
		autotrandao.Save(autotransition);
	}
}