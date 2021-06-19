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

import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonFenceDelegate;

@Component
public class PersonFenceDelegateImp implements PersonFenceDelegate{

	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest/";
	
	public PersonFenceDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public Iterable<PersonFence> findAll() {
		PersonFence[] pers = restTemplate.getForObject(SERVER + "personFence/", PersonFence[].class);
		List<PersonFence> list;
		try {
			list = Arrays.asList(pers);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public PersonFence save(PersonFence personFence) {
		return restTemplate.postForEntity(SERVER + "personFence/save", personFence, PersonFence.class).getBody();
	}

	@Override
	public PersonFence findById(long id) {
		return restTemplate.getForObject(SERVER + "personFence/show/"+ id, PersonFence.class);
	}

	@Override
	public void delete(PersonFence personFence) {
		restTemplate.delete(SERVER + "personFence/delete/"+ personFence.getId());
		
	}

	@Override
	public void edit(PersonFence personFence) {
		restTemplate.put(SERVER + "personFence/edit", personFence, PersonFence.class);
	}

}
