package com.edu.icesi.ci.taller4.front.bd.Imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.front.bd.interfaces.PersonDelegate;

public class PersonDelegateImp implements PersonDelegate{

	public static final String SERVER = "http://localhost:8082/api-rest";

	private RestTemplate restTemplate;

	
	public PersonDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Person> personFindAll() {
		String url = SERVER + "/person/";
		Person[] person = restTemplate.getForObject(url, Person[].class);
		List<Person> result = Arrays.asList(person);
		return result;
	}

	@Override
	public void personSave(Person person) {
		String url = SERVER + "/person/";
		restTemplate.postForObject(url, person, Person.class);
	}

	@Override
	public void personEdit(Person person) {
		String url = SERVER + "/person/";
		restTemplate.put(url, person, Person.class);
	}

	@Override
	public Person personFindById(long id) {
		String url = SERVER + "/person/" + id;
		Person person = restTemplate.getForObject(url, Person.class);
		return person;
	}

	@Override
	public void personDelete(long id) {
		String url = SERVER + "/person/del/" + id;
		restTemplate.delete(url);
	}


}
