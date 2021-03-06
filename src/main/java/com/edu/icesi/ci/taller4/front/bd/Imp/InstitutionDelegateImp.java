package com.edu.icesi.ci.taller4.front.bd.Imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.edu.icesi.ci.taller4.front.bd.interfaces.InstitutionDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.Institution;

@Component
public class InstitutionDelegateImp implements InstitutionDelegate{

	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest/";
	
	@Override
	public Iterable<Institution> getInstitution() {
		Institution[] ins = restTemplate.getForObject(SERVER + "institution/", Institution[].class);
		List<Institution> list;
		try {
			list = Arrays.asList(ins);
			return list;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
