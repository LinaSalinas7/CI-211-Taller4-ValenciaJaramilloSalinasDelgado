package com.edu.icesi.ci.taller4.front.bd.Imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.edu.icesi.ci.taller4.front.bd.interfaces.TriggerTypeDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Triggertype;

@Component
public class TriggersTypeDelegateImp implements TriggerTypeDelegate{

	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/";
	
	public TriggersTypeDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
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
