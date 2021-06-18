package com.edu.icesi.ci.taller4.back.service.implementation;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.icesi.ci.taller4.back.daos.AutotransitionDao;
import com.edu.icesi.ci.taller4.back.model.Autotransition;
import com.edu.icesi.ci.taller4.back.model.FevEventstatus;
import com.edu.icesi.ci.taller4.back.model.FevInstitution;
import com.edu.icesi.ci.taller4.back.repository.AutotransitionRepository;
import com.edu.icesi.ci.taller4.back.repository.FevEventstatusRepository;
import com.edu.icesi.ci.taller4.back.repository.FevInstitutionRepository;
import com.edu.icesi.ci.taller4.back.service.interfaces.AutotransitionService;

@Service
public class AutotransitionServiceImp implements AutotransitionService{

	private AutotransitionDao autotrandao;
	private AutotransitionRepository autotransitionrepo;
	private FevInstitutionRepository fevinstitutionrepo;
	private FevEventstatusRepository feveventstatusrepo;

	@Autowired
	public AutotransitionServiceImp(AutotransitionDao autotrandao, AutotransitionRepository autotransitionrepo,
			FevInstitutionRepository fevinstitutionrepo, 
			FevEventstatusRepository feveventstatusrepo) {
		this.autotrandao = autotrandao;
		this.fevinstitutionrepo = fevinstitutionrepo;
		this.feveventstatusrepo = feveventstatusrepo;
	}

	public boolean saveAutoTransition(long id, String active, String name, String operand, long instId,
			long eventStatusId){
		try {			
			FevInstitution fevInst = fevinstitutionrepo.findById(instId).get();
			FevEventstatus fevEvst = feveventstatusrepo.findById(eventStatusId).get();
			
			Autotransition autotransition = new Autotransition();
			autotransition.setAutotranId(id);			
			
			if(name.equals("")) {
				throw new RuntimeException();
			}
			if(active.equals("Y") || active.equals("N")){
				autotransition.setAutotranIsactive(active);
			}
			else {
				throw new RuntimeException();
			}
			if(operand.equals("AND") || operand.equals("OR")) {
				autotransition.setAutotranLogicaloperand(operand);
			}
			else {
				throw new RuntimeException();
			}
						
			autotransition.setAutotranName(name);
			autotransition.setFevInstitution(fevInst);
			autotransition.setInstInstId(new BigDecimal(instId));
			autotransition.setFevEventStatus(fevEvst);
			
			autotrandao.Save(autotransition); 
			return true;
		}
		catch(RuntimeException rte) {
			return false;
		}				
	}
	
	@Override
	@Transactional
	public boolean editTransition(long id, String newActive, String newName, String newOperand) {
		try {
			Autotransition autotransition = autotrandao.findById(id);
			if(autotransition != null) {
				Autotransition autotrans = autotransition;
				System.out.println("Si existe la transition");
				if(newName.equals("")) {
					throw new RuntimeException();
				}
				if(newActive.equals("Y") || newActive.equals("N")){
					autotrans.setAutotranIsactive(newActive);
				}
				else {
					throw new RuntimeException();
				}
				if(newOperand.equals("AND") || newOperand.equals("OR")) {
					autotrans.setAutotranLogicaloperand(newOperand);
				}
				else {
					throw new RuntimeException();
				}				
				autotrans.setAutotranName(newName);
				autotrandao.Save(autotrans);				
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
	
	@Override
	@Transactional
	public void edit(long id, Autotransition autotrans) {
		Optional<Autotransition> autotransition = autotransitionrepo.findById(id);			
		Autotransition autotran = autotransition.get();							
		autotran.setAutotranIsactive(autotrans.getAutotranIsactive());			
		autotran.setAutotranLogicaloperand(autotrans.getAutotranLogicaloperand());
		autotran.setAutotranName(autotrans.getAutotranName());
		autotransitionrepo.save(autotran);							
	}
	
	@Override
	public Iterable<Autotransition> findAll(){
		return autotrandao.findAll();
	}
	

	@Override
	public Autotransition findById(long id) {
		return autotrandao.findById(id);
	}

	@Override
	public void delete(Autotransition autotransition) {
		autotransitionrepo.delete(autotransition);;
	}

	@Override
	public Autotransition save(Autotransition autotransition) {

		return autotransitionrepo.save(autotransition);
	}
}