package com.edu.icesi.ci.taller4.front.bd.Imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.edu.icesi.ci.taller4.front.bd.interfaces.FetInstitutionDelegate;
import com.edu.icesi.ci.taller4.front.model.clases.FevInstitution;

@Component
public class FetInstitutionDelegateImp implements FetInstitutionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8082/api-rest/";
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
