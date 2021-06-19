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
	@PostMapping
	public void saveTriggerr(@RequestBody Triggerr triggerr) {		
		triggerrService.save(triggerr);
	}

	@Override
	@DeleteMapping("/{trigId}")
	public void deleteTriggerr(@PathVariable("trigId") long id){
		Triggerr trig = triggerrService.findById(id);
		triggerrService.delete(trig);		
	}

	@Override
	@GetMapping("/{trigId}")
	public Triggerr showTriggerr(@PathVariable("id") long id) {
		return triggerrService.findById(id);
	}

	@Override
	@PutMapping("/{trigId}")
	public void updateTriggerr(@PathVariable("id") long id, @RequestBody Triggerr triggerr) {
		triggerrService.edit(id, triggerr);
		
	}
}