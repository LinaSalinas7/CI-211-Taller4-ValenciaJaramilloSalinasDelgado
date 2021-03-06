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

import com.edu.icesi.ci.taller4.front.model.clases.Autotransition;
import com.edu.icesi.ci.taller4.front.bd.interfaces.AutotransitionDelegate;

@Component
public class AutotransitionDelegateImp implements AutotransitionDelegate {
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest";
	
	public AutotransitionDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public Iterable<Autotransition> findAll() {
		Autotransition[] auto = restTemplate.getForObject(SERVER + "/autotransition/", Autotransition[].class);
		List<Autotransition> list = Arrays.asList(auto);
		return list;		
	}

	@Override
	public Autotransition save(Autotransition autotransition) {
		return restTemplate.postForObject(SERVER + "/autotransition/", autotransition, Autotransition.class);
		
	}

	@Override
	public Autotransition findById(long id) {		
		return restTemplate.getForObject(SERVER + "/autotransition/" + id, Autotransition.class);
	}

	@Override
	public void delete(Autotransition autotran) {
		restTemplate.delete(SERVER + "/autotransition/" + autotran.getAutotranId());
		
	}

	@Override
	public void edit(long id, Autotransition autotransition) {
		restTemplate.put(SERVER + "/autotransition/" + id, autotransition, Autotransition.class);
		
	}

	public void setRestTemplate(RestTemplate restTemplate2) {
		this.restTemplate = restTemplate2;
	}
}
