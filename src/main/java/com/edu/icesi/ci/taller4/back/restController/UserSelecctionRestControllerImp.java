package com.edu.icesi.ci.taller4.back.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.icesi.ci.taller4.back.exception.LogicalException;
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
	@PostMapping("/save")
	public void save(Userselect userselect) {
		userselectService.save(userselect);
		
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public void delete(Userselect userselect) throws LogicalException {
		try {
			userselectService.delete(userselect);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	@GetMapping("/show/{id}")
	public Userselect showUserselect(long id) {
		try {
			return userselectService.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@PutMapping("/edit")
	public void updateUserselect(Userselect userselect) throws LogicalException {
		userselectService.editUserSelect(userselect);
		
	}

}
