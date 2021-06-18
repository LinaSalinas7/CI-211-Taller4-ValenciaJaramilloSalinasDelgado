package com.edu.icesi.ci.taller4.front.bd.Imp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;

import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Person;

@Component
public class PersonDelegateImp implements PersonDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest/";
	
	public PersonDelegateImp() {
		this.restTemplate = new RestTemplate();
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//		messageConverters.add(converter);
//		this.restTemplate.setMessageConverters(messageConverters);
	}

	@Override
	public Iterable<Person> findAll() {
		Person[] per = restTemplate.getForObject(SERVER + "person/", Person[].class);
		List<Person> list;
		try {
			list = Arrays.asList(per);
			return list;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Person save(Person person) {
		return restTemplate.postForEntity(SERVER + "person/save", person, Person.class).getBody();
	}

	@Override
	public Person findById(long id) {
		return restTemplate.getForObject(SERVER + "person/show"+ id, Person.class);
	}

	@Override
	public void delete(Person person) {
		restTemplate.delete(SERVER + "person/delete/" + person.getPersId());
		
	}

	@Override
	public void edit(Person person) {
		restTemplate.put(SERVER + "person/edit", person, Person.class);
		
	}

}
