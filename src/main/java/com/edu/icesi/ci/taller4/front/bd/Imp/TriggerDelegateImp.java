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

import com.edu.icesi.ci.taller4.front.bd.interfaces.TriggerDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Triggerr;

@Component
public class TriggerDelegateImp implements TriggerDelegate{

	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest";
	
	public TriggerDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public Iterable<Triggerr> findAll() {
		Triggerr[] trigger = restTemplate.getForObject(SERVER + "/triggerr/", Triggerr[].class);
		List<Triggerr> list = Arrays.asList(trigger); 				
		return list;
	}

	@Override
	public Triggerr save(Triggerr triggerr) {
		return restTemplate.postForEntity(SERVER + "/triggerr/", triggerr, Triggerr.class).getBody();
	}

	@Override
	public Triggerr findById(long id) {
		return restTemplate.getForObject(SERVER + "/triggerr/" + id, Triggerr.class);
	}

	@Override
	public void delete(Triggerr triggerr) {
		restTemplate.delete(SERVER + "/triggerr/" + triggerr.getTrigId());
		
	}

	@Override
	public void edit(long id, Triggerr triggerr) {
		restTemplate.put(SERVER + "/triggerr/" + id, triggerr, Triggerr.class);
		
	}

	public void setRestTemplate(RestTemplate restTemplate2) {
		this.restTemplate = restTemplate2;		
	}
}
