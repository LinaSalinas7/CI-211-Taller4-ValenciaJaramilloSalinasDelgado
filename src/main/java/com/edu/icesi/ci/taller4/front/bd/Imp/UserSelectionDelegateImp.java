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

import com.edu.icesi.ci.taller4.front.model.clases.Userselect;
import com.edu.icesi.ci.taller4.front.bd.interfaces.UserSelectionDelegate;

@Component
public class UserSelectionDelegateImp implements UserSelectionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest";
	
	public UserSelectionDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public Iterable<Userselect> findAll() {
		Userselect[] userS = restTemplate.getForObject(SERVER + "/userselect/", Userselect[].class);
		List<Userselect> list = Arrays.asList(userS);		
		return list;
	}

	@Override
	public Userselect save(Userselect userselect) {
		return restTemplate.postForEntity(SERVER + "/userselect/", userselect, Userselect.class).getBody();
	}

	@Override
	public Userselect findById(long id) {
		return restTemplate.getForObject(SERVER + "/userselect/" + id, Userselect.class);
	}

	@Override
	public void delete(Userselect userselect) {
		restTemplate.delete(SERVER + "/userselect/" + userselect.getUsselId());;
		
	}

	@Override
	public void edit(long id, Userselect userselect) {
		restTemplate.put(SERVER + "/userselect/" + id, userselect, Userselect.class);	
	}
}