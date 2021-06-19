package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.service.interfaces.TriggertypeService;

@RestController
@RequestMapping("/api-rest/triggertype")
public class TriggerTypeRestControllerImp implements TriggerTypeRestController{

	@Autowired
	private TriggertypeService triggertypeService;

	@Override
	@GetMapping("/")
	public Iterable<Triggertype> indexTriggerr() {
		return triggertypeService.findAll();
	}

	@Override
	@PostMapping
	public void saveTriggertype(@RequestBody Triggertype triggerrtype) {
		triggertypeService.save(triggerrtype);		
	}

	@Override
	@DeleteMapping("/{trigtypeId}")
	public void deleteTriggertype(@PathVariable("trigtypeId") long id){
		Triggertype trig = triggertypeService.findById(id);
		triggertypeService.delete(trig);
	}

	@Override
	@GetMapping("/{trigtypeId}")
	public Triggertype showTriggertype(@PathVariable("trigtypeId") long id) {		
		return triggertypeService.findById(id);	
	}

	@Override
	@PutMapping("/{trigtypeId}")
	public void updateTriggertype(@PathVariable("trigtypeId") long id, @RequestBody Triggertype triggertype){
		triggertypeService.edit(id, triggertype);		
	}
}