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
import com.edu.icesi.ci.taller4.back.model.PersonFencePK;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonFenceDelegate;

@Component
public class PersonFenceDelegateImp implements PersonFenceDelegate{

	
	public static final String SERVER = "http://localhost:8082/api-rest";

	private RestTemplate restTemplate;

	
	public PersonFenceDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
		
	@Override
	public List<PersonFence> personFenceFindAll() {
		String url = SERVER + "/personfence/";
		PersonFence[] personFence = restTemplate.getForObject(url, PersonFence[].class);
		List<PersonFence> result = Arrays.asList(personFence);
		return result;
	}

	@Override
	public void personFenceSave(PersonFence personFence) {
		String url = SERVER + "/personfence/";
		restTemplate.postForObject(url, personFence, PersonFence.class);
	}

	@Override
	public void personFenceEdit(PersonFence personFence) {
		String url = SERVER + "/personfence/";
		restTemplate.put(url, personFence, PersonFence.class);
	}

	@Override
	public PersonFence personFenceFindById(PersonFencePK id) {
		String url = SERVER + "/personfence/";
		PersonFence personfence = restTemplate.postForObject(url,id ,PersonFence.class);
		return personfence;
	}

	@Override
	public void personFenceDelete(PersonFence id) {
		String url = SERVER + "/personfence/";		
		restTemplate.delete(url, id, PersonFence.class);
	}	
}