package com.edu.icesi.ci.taller4.back.service.implementation;

//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.TriggerrDao;
import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.repository.TriggertypeRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggerrService;

@Service
@Transactional
public class TriggerrServiceImp implements TriggerrService{
	
	private TriggerrDao trigDao;
	private TriggertypeRepository triggertyrepo;
	
	@Autowired
	public TriggerrServiceImp(TriggerrDao trigDao,TriggertypeRepository triggertyrepo) {
		this.trigDao = trigDao;
		this.triggertyrepo = triggertyrepo;
	}
	
	@Override
	public boolean saveTriggerr(long id, String scope, String Name, long triggertypeID) {
		try {
			
			Triggertype triggertype = triggertyrepo.findById(triggertypeID).get();					
			Triggerr triggerr = new Triggerr(); 
			
			triggerr.setTrigId(id);
			
			if(scope.equals("") || Name.equals("")) {
				throw new RuntimeException();
			}
			if(scope.equals("Local") || scope.equals("Remoto")) {
				triggerr.setTrigScope(scope);
			}
			else {
				throw new RuntimeException();
			}
			
			triggerr.setTrigName(Name);
			triggerr.setTriggertype(triggertype);	
			trigDao.Save(triggerr);
			return true;
		}
		catch(RuntimeException rte) {
			return false;
		}
	}

	@Override
	public boolean editTriggerr(long id, String newScope, String newName) {		
		try {
			Triggerr trigger = trigDao.findById(id);
			if(trigger != null) {
				Triggerr trigge = trigger;
				if(newScope.equals("") || newName.equals("")) {
					throw new RuntimeException();
				}
				if(newScope.equals("Local") || newScope.equals("Remoto")) {
					trigge.setTrigScope(newScope);
				}
				else {
					throw new RuntimeException();
				}				
				trigge.setTrigName(newName);
				return true;
			}
			else {
				return false;
			}			
		}
		catch(RuntimeException rte) {
			return false;	
		}
	}

	/*@Override
	public Iterable<Triggerr> findAll() {
		return triggerepo.findAll();
	}

	@Override
	public Triggerr save(Triggerr trigger) {
		return triggerepo.save(trigger);
	}

	@Override
	public Optional<Triggerr> findById(long id) {
		return triggerepo.findById(id);
	}

	@Override
	public void delete(Triggerr triggerr) {
		triggerepo.delete(triggerr);
		
	}*/
}
