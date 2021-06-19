package com.edu.icesi.ci.taller4;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.edu.icesi.ci.taller4.back.model.FevInstitution;
import com.edu.icesi.ci.taller4.back.model.Institution;
import com.edu.icesi.ci.taller4.back.model.Person;
import com.edu.icesi.ci.taller4.back.model.PersonFence;
import com.edu.icesi.ci.taller4.back.model.PersonFencePK;
import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.model.Userr;
import com.edu.icesi.ci.taller4.back.model.UserrType;
import com.edu.icesi.ci.taller4.back.model.Userselect;
import com.edu.icesi.ci.taller4.back.service.implementation.AutotransitionServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.FevInstitutionServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.InstitutionServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.PersonFenceServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.PersonServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.TriggerrServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.TriggertypeServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.UserrServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.UserselectServiceImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.AutotransitionDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.FetInstitutionDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.InstitutionDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.PersonDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.PersonFenceDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.TriggerDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.TriggersTypeDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.UserSelectionDelegateImp;
import com.edu.icesi.ci.taller4.back.daos.ContactfenceDaoImp;
import com.edu.icesi.ci.taller4.back.model.Autotransition;
import com.edu.icesi.ci.taller4.back.model.Contactfence;

@SpringBootApplication
@ComponentScan("com.edu.icesi.ci.taller4")
public class Taller4RESTJuanValenciaLinasSalinasApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(Taller4RESTJuanValenciaLinasSalinasApplication.class, args);
		//Cargar users
		UserrServiceImp u = c.getBean(UserrServiceImp.class);
		//Cargar instituciones
		FevInstitutionServiceImp fi = c.getBean(FevInstitutionServiceImp.class);
		AutotransitionServiceImp as = c.getBean(AutotransitionServiceImp.class);
		TriggerrServiceImp ts = c.getBean(TriggerrServiceImp.class);
		TriggertypeServiceImp tts = c.getBean(TriggertypeServiceImp.class);
		UserselectServiceImp us = c.getBean(UserselectServiceImp.class);
		PersonServiceImp ps = c.getBean(PersonServiceImp.class);
		PersonFenceServiceImp pfs = c.getBean(PersonFenceServiceImp.class);
		InstitutionServiceImp is = c.getBean(InstitutionServiceImp.class);
		
		
		//Delegates
		AutotransitionDelegateImp ad = c.getBean(AutotransitionDelegateImp.class);
		FetInstitutionDelegateImp fid = c.getBean(FetInstitutionDelegateImp.class);
		TriggerDelegateImp td = c.getBean(TriggerDelegateImp.class);
		TriggersTypeDelegateImp ttd = c.getBean(TriggersTypeDelegateImp.class);
		UserSelectionDelegateImp ussd = c.getBean(UserSelectionDelegateImp.class);
		PersonDelegateImp pd = c.getBean(PersonDelegateImp.class);
		PersonFenceDelegateImp pfd = c.getBean(PersonFenceDelegateImp.class);
		InstitutionDelegateImp id = c.getBean(InstitutionDelegateImp.class);
		
		ContactfenceDaoImp cfdao = c.getBean(ContactfenceDaoImp.class);
		
		FevInstitution inst1 = new FevInstitution();
		inst1.setInstName("Universidad Icesi");	
		fi.save(inst1);
		
		FevInstitution inst2 = new FevInstitution();
		inst2.setInstName("Universidad del norte");
		fi.save(inst2);
		
		FevInstitution inst3 = new FevInstitution();
		inst3.setInstName("Universidad San buenaventura");
		fi.save(inst3);
		
		Autotransition aut1 = new Autotransition();
		aut1.setAutotranName("Aut1");
		aut1.setAutotranLogicaloperand("AND");
		aut1.setAutotranIsactive("Y");
		aut1.setInstInstId(BigDecimal.valueOf(0));
		as.save(aut1);
		
		Autotransition aut2 = new Autotransition();
		aut2.setAutotranName("Aut2");
		aut2.setAutotranLogicaloperand("OR");
		aut2.setAutotranIsactive("N");
		aut2.setInstInstId(BigDecimal.valueOf(1));
		as.save(aut2);
						
		Institution i1 = new Institution();
		i1.setInstName("ICESI");
		i1.setInstAcademicserverurl("icesi.edu.co");
		i1.setInstAcadloginusername("icesi");
		i1.setInstAcadloginpassword("icesi");
		is.save(i1);
		
		Institution i2 = new Institution();
		i2.setInstName("SENA");
		i2.setInstAcademicserverurl("sena.com");
		i2.setInstAcadloginusername("sena");
		i2.setInstAcadloginpassword("sena");
		is.save(i2);
		
		Person p1 = new Person();
		p1.setPersName("Lina");
		p1.setPersLastname("Salinas");
		p1.setPersAddress("Pance");
		p1.setPersContactnumber("1234567899");
		p1.setPersEmail("linas7@example.com");	
		p1.setPersIsactive("Active");
		p1.setInstitution(i2);
		ps.save(p1);
		
//		Person p = new Person();		
//		p.setPersName("María josé");
//		p.setInstitution(i2);
//		ps.save(p);
//					
//		Contactfence cf = new Contactfence();
//		cf.setPerson(p);		
//		cfdao.save(cf);
//				
//		PersonFencePK pfpk = new PersonFencePK();
//		pfpk.setPersPersId(1);
//		pfpk.setContfenContfenId(1);
//		
//		PersonFence pf = new PersonFence();
//		pf.setDumy("Dumy1");
//		pf.setId(pfpk);
//		pf.setPerson(p);
//		pf.setContactfence(cf);
//		pfs.save(pf);
						
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