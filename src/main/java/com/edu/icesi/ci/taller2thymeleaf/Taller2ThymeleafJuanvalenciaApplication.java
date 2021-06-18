package com.edu.icesi.ci.taller2thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.edu.icesi.ci.taller4.back.model.FevInstitution;
import com.edu.icesi.ci.taller4.back.model.Userr;
import com.edu.icesi.ci.taller4.back.model.UserrType;
import com.edu.icesi.ci.taller4.back.service.implementation.FevInstitutionServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.UserrServiceImp;

@SpringBootApplication
public class Taller2ThymeleafJuanvalenciaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(Taller2ThymeleafJuanvalenciaApplication.class, args);
		UserrServiceImp u = c.getBean(UserrServiceImp.class);
		FevInstitutionServiceImp fi = c.getBean(FevInstitutionServiceImp.class);
		
		FevInstitution inst1 = new FevInstitution();
		inst1.setInstName("Universidad Icesi");	
		fi.save(inst1);
		
		FevInstitution inst2 = new FevInstitution();
		inst2.setInstName("Universidad del norte");
		fi.save(inst2);
		
		FevInstitution inst3 = new FevInstitution();
		inst3.setInstName("Universidad San buenaventura");
		fi.save(inst3);
		
		Userr user1 = new Userr();		
		user1.setUsertype(UserrType.administrador);
		user1.setUserName("admin");
		user1.setUserPassword("{noop}admin");
		u.save(user1);	
		
		Userr user2 = new Userr();		
		user2.setUsertype(UserrType.operador);
		user2.setUserName("oper");		
		user2.setUserPassword("{noop}oper");
		u.save(user2);	
		
		Userr user3 = new Userr();
		user3.setUsertype(UserrType.administrador);
		user3.setUserName("admin2");
		user3.setUserPassword("{noop}admin2");
		u.save(user3);
		
		Userr user4 = new Userr();
		user4.setUsertype(UserrType.operador);
		user4.setUserName("oper2");
		user4.setUserPassword("{noop}oper2");
		u.save(user4);		
	}
}