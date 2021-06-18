package com.edu.icesi.ci.taller4.front.bd.Imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.edu.icesi.ci.taller4.front.bd.interfaces.TriggerDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Triggerr;

@Component
public class TriggerDelegateImp implements TriggerDelegate{

	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest/";
	
	@Override
	public Iterable<Triggerr> findAll() {
		Triggerr[] trigger = restTemplate.getForObject(SERVER + "triggerr/", Triggerr[].class);
		List<Triggerr> list;
		try {
			list = Arrays.asList(trigger);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Triggerr save(Triggerr Triggerr) {
		return restTemplate.postForEntity(SERVER + "triggerr/save", Triggerr, Triggerr.getClass()).getBody();
	}

	@Override
	public Triggerr findById(long id) {
		return restTemplate.getForObject(SERVER + "triggerr/show" + id, Triggerr.class);
	}

	@Override
	public void delete(Triggerr triggerr) {
		restTemplate.delete(SERVER + "triggerr/delete/" + triggerr.getTrigId());
		
	}

	@Override
	public void edit(long id, Triggerr triggerr) {
		restTemplate.put(SERVER + "triggerr/edit", triggerr, Triggerr.class);
		
	}

}
