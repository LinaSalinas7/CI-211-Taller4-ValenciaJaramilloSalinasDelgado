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

import com.edu.icesi.ci.taller4.back.service.interfaces.AutotransitionService;
import com.edu.icesi.ci.taller4.back.model.Autotransition;

@RestController
@RequestMapping("/api-rest/autotransition")
public class AutotransitionRestControllerImp implements AutransitionRestController{
	
	@Autowired
	private AutotransitionService autotransitionService; 

	@Override
	@GetMapping("/")
	public Iterable<Autotransition> indexAutotransition() {
		return autotransitionService.findAll();
	}

	@Override
	@PostMapping("/save")
	public void saveAutotransition(@RequestBody Autotransition autotransition) {
		autotransitionService.save(autotransition);
	}

	@Override
	@DeleteMapping("/delete/{autotranId}")
	public void deleteAutotransition(@PathVariable("autotranId") long id){
		Autotransition auto = autotransitionService.findById(id);
		autotransitionService.delete(auto);
	}

	@Override
	@GetMapping("/show/{autotranId}")
	public Autotransition showAutotransition(@PathVariable("autotranId") long id) {
		try {
			return autotransitionService.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@PutMapping("/edit")
	public void updateAutotransition(@RequestBody Autotransition autotransition){
		autotransitionService.edit(autotransition);
		
	}	
}
