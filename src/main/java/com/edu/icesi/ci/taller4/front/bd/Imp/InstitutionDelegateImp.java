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

import com.edu.icesi.ci.taller4.front.bd.interfaces.InstitutionDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Institution;

@Component
public class InstitutionDelegateImp implements InstitutionDelegate{

	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest";
	
	public InstitutionDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverters.add(converter);
		this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public List<Institution> institutionFindAll() {
		String url = SERVER + "/institution/";
		Institution[] institution = restTemplate.getForObject(url, Institution[].class);
		List<Institution> result = Arrays.asList(institution);
		return result;
	}

	@Override
	public void institutionSave(Institution institution) {
		String url = SERVER + "/institution/";
		restTemplate.postForObject(url, institution, Institution.class);
	}

	@Override
	public void institutionEdit(Institution institution) {
		String url = SERVER + "/institution/";
		restTemplate.put(url, institution, Institution.class);
	}

	@Override
	public Institution institutionFindById(long id) {
		String url = SERVER + "/institution/" + id;
		Institution institution = restTemplate.getForObject(url, Institution.class);
		return institution;
	}

	@Override
	public void institutionDelete(long id) {
		String url = SERVER + "/institution/" + id;
		restTemplate.delete(url);
	}
}
