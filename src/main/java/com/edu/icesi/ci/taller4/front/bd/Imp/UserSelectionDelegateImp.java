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
	final String SERVER="http://localhost:8080/api-rest/";
	
	public UserSelectionDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
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
