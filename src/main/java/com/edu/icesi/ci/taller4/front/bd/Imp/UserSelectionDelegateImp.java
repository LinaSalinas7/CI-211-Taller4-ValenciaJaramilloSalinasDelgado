package com.edu.icesi.ci.taller4.front.bd.Imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.edu.icesi.ci.taller4.front.model.clases.Userselect;
import com.edu.icesi.ci.taller4.front.bd.interfaces.UserSelectionDelegate;

@Component
public class UserSelectionDelegateImp implements UserSelectionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest/";

	@Override
	public Iterable<Userselect> findAll() {
		Userselect[] userS = restTemplate.getForObject(SERVER + "userselect/", Userselect[].class);
		List<Userselect> list;
		try {
			list = Arrays.asList(userS);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Userselect save(Userselect userselect) {
		return restTemplate.postForEntity(SERVER + "userselect/save", userselect, Userselect.class).getBody();
	}

	@Override
	public Userselect findById(long id) {
		return restTemplate.getForObject(SERVER + "userselect/show" + id, Userselect.class);
	}

	@Override
	public void delete(Userselect userselect) {
		restTemplate.delete(SERVER + "userselect/delete" + userselect.getUsselId());;
		
	}

	@Override
	public void edit(Userselect userselect) {
		restTemplate.put(SERVER + "userselect/edit", userselect, Userselect.class);	
	}

}
