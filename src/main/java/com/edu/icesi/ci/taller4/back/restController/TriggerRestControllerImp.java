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
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggerrService;

@RestController
@RequestMapping("/api-rest/triggerr")
public class TriggerRestControllerImp implements TriggerRestController{
	
	@Autowired
	private TriggerrService triggerrService;

	@Override
	@GetMapping("/")
	public Iterable<Triggerr> indexTriggerr() {		
		return triggerrService.findAll();
	}

	@Override
	@PostMapping("/save")
	public void saveTriggerr(Triggerr triggerr) {		
		triggerrService.save(triggerr);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteTriggerr(Triggerr triggerr) throws LogicalException {
		try {
			triggerrService.delete(triggerr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@GetMapping("/show/{id}")
	public Triggerr showTriggerr(long id) {
		try {
			return triggerrService.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@PutMapping("/edit")
	public void updateTriggerr(Triggerr triggerr) throws LogicalException {
		triggerrService.edit(triggerr);
		
	}

}
