package com.edu.icesi.ci.taller1pruebasintegracionjuanvalencia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.edu.icesi.ci.taller1pruebasjuanvalencia.Taller1PruebasJuanvalenciaApplication;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.FevInstitution;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.FevInstitutionRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggertypeRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggertypeService;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggertypeServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1PruebasJuanvalenciaApplication.class)
public class TriggertypeTest {

	@Autowired
	private TriggertypeRepository triggertrepo;

	@Autowired 
	private FevInstitutionRepository fevinstrepo;

	@Autowired
	private TriggertypeService triggertservice;

	@Autowired
	public TriggertypeTest() {
		this.triggertservice = new TriggertypeServiceImp(triggertrepo,fevinstrepo);
	}
	
	@BeforeAll
	public static void setUp() {	
		System.out.println("-----> SETUP <-----");
	}
	
	@Nested
	@DisplayName("Save cases")
	class Save{
		@Test
		@DisplayName("Save_triggerty_valid_test")
		public void testSaveTriggerTypeProperly1(){
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(99);
			fevinstrepo.save(fevinstit);
			
			assertTrue(triggertservice.saveTriggerType(25,"TriggertypeTest1",1),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Save_triigerty_invalid_test")
		public void testSaveTriggerTypeImproperly() {
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(99);
			fevinstrepo.save(fevinstit);
			
			assertFalse(triggertservice.saveTriggerType(25,"",1),
					"The entity could not be saved");
		}
	}
	
	@Nested
	@DisplayName("Edit cases")
	class Edit{
		@Test
		@DisplayName("Edit_triggerty_valid_test")
		public void testEditAutoTransitionProperly(){
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(99);
			fevinstrepo.save(fevinstit);
			
			triggertservice.saveTriggerType(25,"TriggertypeTest1",1);
			assertTrue(triggertservice.editTriggerType(1, "newTriggerTypeTest"),
					"Could not find the entity to edit");
		}
		
		@Test
		@DisplayName("Edit_triggerty_invalid_test1")
		public void testEditAutoTransitionImproperly1(){
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(99);
			fevinstrepo.save(fevinstit);
			
			triggertservice.saveTriggerType(25,"TriggertypeTest1",1);
			assertFalse(triggertservice.editTriggerType(25, "newTriggerTypeTest"),
					"The entity to edit was found even thought does not supposed to exist");
		}
		
		@Test
		@DisplayName("Edit_triggerty_invalid_test2")
		public void testEditAutoTransitionImproperly2(){
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(99);
			fevinstrepo.save(fevinstit);
			
			assertFalse(triggertservice.editTriggerType(1, ""),
					"Could not edit entity due to unacceptable values");
		}
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
