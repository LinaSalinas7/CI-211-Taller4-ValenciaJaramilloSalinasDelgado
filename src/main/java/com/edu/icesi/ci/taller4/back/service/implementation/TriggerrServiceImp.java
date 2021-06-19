package com.edu.icesi.ci.taller4.back.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.TriggerrDao;
import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggerrService;

@Service
@Transactional
public class TriggerrServiceImp implements TriggerrService{
	
	private TriggerrDao trigDao;
	
	@Autowired
	public TriggerrServiceImp(TriggerrDao trigDao) {
		this.trigDao = trigDao;
	}
	
	@Override
	@Transactional
	public Iterable<Triggerr> findAll() {
		return trigDao.findAll();
	}

	@Override
	@Transactional
	public void save(Triggerr trigger) {
		trigDao.Save(trigger);
	}

	@Override
	@Transactional
	public Triggerr findById(long id) {
		return trigDao.findById(id);
	}

	@Override
	@Transactional
	public void delete(Triggerr triggerr) {
		trigDao.Delete(triggerr);		
	}

	@Override
	@Transactional
	public void edit(long id, Triggerr trigger) {		
		Triggerr trig = trigDao.findById(id);					
		trig.setTrigScope(trigger.getTrigScope());
		trig.setTrigName(trigger.getTrigName());	
		trigDao.Save(trig);
	}
}
