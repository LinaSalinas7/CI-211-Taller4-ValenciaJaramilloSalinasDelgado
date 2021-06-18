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

import com.edu.icesi.ci.taller4.front.bd.interfaces.FetInstitutionDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.FevInstitution;

@Component
public class FetInstitutionDelegateImp implements FetInstitutionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/";
	
	public FetInstitutionDelegateImp() {
		this.restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
	}
	
	@Override
	public Iterable<FevInstitution> findAll() {
		FevInstitution[] fev = restTemplate.getForObject(SERVER + "fevInstitution/", FevInstitution[].class);
		List<FevInstitution> list;
		try {
			list = Arrays.asList(fev);
			return list;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
