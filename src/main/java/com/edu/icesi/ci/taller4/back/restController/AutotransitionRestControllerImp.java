package com.edu.icesi.ci.taller4.back.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
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
	public Autotransition saveAutotransition(Autotransition autotransition) {
		return autotransitionService.save(autotransition);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteAutotransition(Autotransition autotransition) throws LogicalException {
		try {
			autotransitionService.delete(autotransition);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@GetMapping("/show/{id}")
	public Autotransition showAutotransition(long id) {
		try {
			return autotransitionService.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@PutMapping("/edit")
	public void updateAutotransition(Autotransition autotransition) throws LogicalException {
		autotransitionService.edit(autotransition.getAutotranId(), autotransition);
		
	}

	
}
