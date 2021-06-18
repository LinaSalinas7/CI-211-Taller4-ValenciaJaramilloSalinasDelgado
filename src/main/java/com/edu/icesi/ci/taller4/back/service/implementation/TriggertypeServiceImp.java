package com.edu.icesi.ci.taller4.back.service.implementation;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.model.FevInstitution;
import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.repository.FevInstitutionRepository;
import com.edu.icesi.ci.taller4.back.repository.TriggertypeRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggertypeService;

@Service
@Transactional
public class TriggertypeServiceImp implements TriggertypeService{

	private TriggertypeRepository triggertyperepo;
	private FevInstitutionRepository fevinstitutionrepo;

	@Autowired
	public TriggertypeServiceImp(TriggertypeRepository triggertyperepo,
			FevInstitutionRepository fevinstitutionrepo) {
		this.triggertyperepo = triggertyperepo;
		this.fevinstitutionrepo = fevinstitutionrepo;
	}

	@Override
	public boolean saveTriggerType(long id, String name, long instId) {
		try {
			FevInstitution fevInst = fevinstitutionrepo.findById(instId).get();

			Triggertype triggertype = new Triggertype();
			triggertype.setTrigtypeId(id);

			if(name.equals("")) {
				throw new RuntimeException();
			}

			triggertype.setTrigtypeName(name);
			triggertype.setFevInstitution(fevInst);
			triggertype.setInstInstId(new BigDecimal(instId));

			triggertyperepo.save(triggertype);
			return true;
		}
		catch(RuntimeException rte) {
			return false;
		}
	}

	@Override
	@Transactional
	public void editTriggerType(long id,Triggertype triggertype) {
		Optional<Triggertype> trigtype = triggertyperepo.findById(id);
		Triggertype triggert = trigtype.get();						
		triggert.setTrigtypeName(triggertype.getTrigtypeName());
		triggertyperepo.save(triggert);					
	}

	@Override
	public Iterable<Triggertype> findAll() {
		return triggertyperepo.findAll();
	}

	@Override
	public Triggertype save(Triggertype trigtype) {
		return triggertyperepo.save(trigtype);
	}

	@Override
	public Optional<Triggertype> findById(long id) {
		return triggertyperepo.findById(id);
	}

	@Override
	public void delete(Triggertype trigtype) {
		triggertyperepo.delete(trigtype);		
	}
}
