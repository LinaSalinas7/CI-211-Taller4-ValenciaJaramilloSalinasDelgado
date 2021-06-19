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
	final String SERVER="http://localhost:8082/api-rest";
	
	public TriggersTypeDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public Iterable<Triggertype> findAll() {
		Triggertype[] triggerType = restTemplate.getForObject(SERVER + "/triggertype/", Triggertype[].class);
		List<Triggertype> list = Arrays.asList(triggerType);				
		return list;
	}

	@Override
	public Triggertype save(Triggertype triggertype) {
		return restTemplate.postForEntity(SERVER + "/triggertype/", triggertype, Triggertype.class).getBody();
	}

	@Override
	public Triggertype findById(long id) {
		return restTemplate.getForObject(SERVER + "/triggertype/" + id, Triggertype.class);
	}

	@Override
	public void delete(Triggertype triggertype) {
		restTemplate.delete(SERVER + "/triggertype/" + triggertype.getTrigtypeId());
		
	}

	@Override
	public void edit(long id, Triggertype triggertype) {
		restTemplate.put(SERVER + "/triggertype/" + id, triggertype, Triggertype.class);
		
	}

	public void setRestTemplate(RestTemplate restTemplate2) {
		 		
	}
}