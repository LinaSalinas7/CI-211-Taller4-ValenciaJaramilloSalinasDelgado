package com.edu.icesi.ci.taller4.front.bd.Imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.edu.icesi.ci.taller4.front.bd.interfaces.TriggerTypeDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Triggertype;

@Component
public class TriggersTypeDelegateImp implements TriggerTypeDelegate{

	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest/";
	
	@Override
	public Iterable<Triggertype> findAll() {
		Triggertype[] triggerType = restTemplate.getForObject(SERVER + "triggerrtype/", Triggertype[].class);
		List<Triggertype> list;
		try {
			list = Arrays.asList(triggerType);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Triggertype save(Triggertype triggertype) {
		return restTemplate.postForEntity(SERVER + "triggerrtype/save", triggertype, Triggertype.class).getBody();
	}

	@Override
	public Triggertype findById(long id) {
		return restTemplate.getForObject(SERVER + "triggerrtype/show" + id, Triggertype.class);
	}

	@Override
	public void delete(Triggertype triggertype) {
		restTemplate.delete(SERVER + "triggerrtype/delete/" + triggertype.getTrigtypeId());
		
	}

	@Override
	public void edit(Triggertype triggertype) {
		restTemplate.put(SERVER + "triggerrtype/edit", triggertype, Triggertype.class);
		
	}
	
	

}
