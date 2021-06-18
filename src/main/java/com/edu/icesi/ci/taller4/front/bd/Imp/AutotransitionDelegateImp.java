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
	final String SERVER="http://localhost:8080/api-rest/";
	
	public AutotransitionDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public Iterable<Autotransition> findAll() {
		Autotransition[] auto = restTemplate.getForObject(SERVER + "autotransition/", Autotransition[].class);
		List<Autotransition> list;
		try {
			list = Arrays.asList(auto);
			return list;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Autotransition save(Autotransition autotransition) {
		return restTemplate.postForEntity(SERVER + "autotransition/save", autotransition, Autotransition.class).getBody();
		
	}

	@Override
	public Autotransition findById(long id) {
		
		return restTemplate.getForObject(SERVER + "autotransition/show/" + id, Autotransition.class);
	}

	@Override
	public void delete(Autotransition autotransition) {
		restTemplate.delete(SERVER + "autotransition/delete/" + autotransition.getAutotranId());
		
	}

	@Override
	public void edit(Autotransition autotransition) {
		restTemplate.put(SERVER + "autotransition/edit", autotransition, Autotransition.class);
		
	}

}
