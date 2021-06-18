package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggertypeService;

@RestController
@RequestMapping("/api-rest/triggerrtype")
public class TriggerTypeRestControllerImp implements TriggerTypeRestController{
	
	@Autowired
	private TriggertypeService triggertypeService;

	@Override
	@GetMapping("/")
	public Iterable<Triggertype> indexTriggerr() {
		return triggertypeService.findAll();
	}

	@Override
	@PostMapping("/save")
	public void saveTriggertype(Triggertype triggerrtype) {
		triggertypeService.save(triggerrtype);
		
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteTriggertype(Triggertype triggertype) throws LogicalException {
		try {
			triggertypeService.delete(triggertype);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@GetMapping("/show/{id}")
	public Triggertype showTriggertype(long id) {
		try {
			return triggertypeService.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	@PutMapping("/edit")
	public void updateTriggertype(Triggertype triggertype) throws LogicalException {
		triggertypeService.editTriggerType(triggertype);
		
	}

}
