package com.edu.icesi.ci.taller4.back.service.implementation;

//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.UserselectDao;
import com.edu.icesi.ci.taller4.back.model.Userselect;
import com.edu.icesi.ci.taller4.back.service.interfaces.UserselectService;

@Service
public class UserselectServiceImp implements UserselectService{
	
	private UserselectDao usseldao;
	
	@Autowired
	public UserselectServiceImp(UserselectDao usseldao) {
		this.usseldao = usseldao;
	}
	
	
	@Override
	@Transactional
	public Iterable<Userselect> findAll() {
		return usseldao.findAll();
	}

	@Override
	@Transactional
	public void save(Userselect userselect) {
		usseldao.Save(userselect);
	}

	@Override
	@Transactional
	public Userselect findById(long id) {
		return usseldao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Userselect ussel) {
		usseldao.Delete(ussel);		
	}

	@Override
	@Transactional
	public void editUserSelect(Userselect userselect) {
		usseldao.Edit(userselect);
		
	}
}