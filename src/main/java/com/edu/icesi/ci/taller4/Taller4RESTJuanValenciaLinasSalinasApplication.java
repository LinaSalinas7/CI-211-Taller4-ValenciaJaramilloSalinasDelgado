package com.edu.icesi.ci.taller4;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.edu.icesi.ci.taller4.back.model.FevInstitution;
import com.edu.icesi.ci.taller4.back.model.Triggerr;
import com.edu.icesi.ci.taller4.back.model.Triggertype;
import com.edu.icesi.ci.taller4.back.model.Userr;
import com.edu.icesi.ci.taller4.back.model.UserrType;
import com.edu.icesi.ci.taller4.back.model.Userselect;
import com.edu.icesi.ci.taller4.back.service.implementation.AutotransitionServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.FevInstitutionServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.TriggerrServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.TriggertypeServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.UserrServiceImp;
import com.edu.icesi.ci.taller4.back.service.implementation.UserselectServiceImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.AutotransitionDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.FetInstitutionDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.PersonDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.TriggerDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.TriggersTypeDelegateImp;
import com.edu.icesi.ci.taller4.front.bd.Imp.UserSelectionDelegateImp;
import com.edu.icesi.ci.taller4.back.model.Autotransition;

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
		
		
		//Delegates
		AutotransitionDelegateImp ad = c.getBean(AutotransitionDelegateImp.class);
		FetInstitutionDelegateImp fid = c.getBean(FetInstitutionDelegateImp.class);
		TriggerDelegateImp td = c.getBean(TriggerDelegateImp.class);
		TriggersTypeDelegateImp ttd = c.getBean(TriggersTypeDelegateImp.class);
		UserSelectionDelegateImp ussd = c.getBean(UserSelectionDelegateImp.class);
		PersonDelegateImp pd = c.getBean(PersonDelegateImp.class);
		
		
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
		
		Triggertype trigt1 = new Triggertype();
		trigt1.setTrigtypeName("trigt1");
		trigt1.setFevInstitution(inst3);
		tts.save(trigt1);
		
		Triggerr trig1 = new Triggerr();
		trig1.setTrigName("trig1");
		trig1.setTrigScope("Regional");
		trig1.setTriggertype(trigt1);
		ts.save(trig1);
		
		Triggerr trig2 = new Triggerr();
		trig2.setTrigName("trig2");
		trig2.setTrigScope("Local");
		trig2.setTriggertype(trigt1);
		ts.save(trig2);
				
		Userselect ussel1 = new Userselect();
		ussel1.setUsselTablename("Test");
		ussel1.setUsselValuekeycolumn("PK");
		ussel1.setUsselValueusercolumn("Codigo");
		ussel1.setUsselWherestatement("WHEN");
		ussel1.setTriggerr(trig2);
		us.save(ussel1);
		
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