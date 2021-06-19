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

import com.edu.icesi.ci.taller4.back.model.Userselect;
import com.edu.icesi.ci.taller4.back.service.interfaces.UserselectService;

@RestController
@RequestMapping("/api-rest/userselect")
public class UserSelecctionRestControllerImp implements UserSelecctionRestController{

	@Autowired
	private UserselectService userselectService; 

	@Override
	@GetMapping("/")
	public Iterable<Userselect> indexTriggerr() {
		return userselectService.findAll();
	}

	@Override
	@PostMapping
	public void save(@RequestBody Userselect userselect) {
		userselectService.save(userselect);
	}

	@Override
	@DeleteMapping("/{usselId}")
	public void delete(@PathVariable("usselId") long id){
		Userselect userselect = new Userselect();
		userselectService.delete(userselect);
	}

	@Override
	@GetMapping("/{usselId}")
	public Userselect showUserselect(@PathVariable("usselId") long id) {
		return userselectService.findById(id);
	}

	@Override	
	@PutMapping("/{usselId}")
	public void updateUserselect(@PathVariable("usselId") long id, @RequestBody Userselect userselect){
		userselectService.edit(id, userselect);
	}
}