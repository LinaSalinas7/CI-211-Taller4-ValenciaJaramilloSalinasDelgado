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
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.Triggertype;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggerrRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggertypeRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggerrService;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggerrServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1PruebasJuanvalenciaApplication.class)
public class TriggerTest {

	@Autowired
	private TriggertypeRepository triggertrepo;
	
	@Autowired
	private TriggerrRepository triggerepo;
	
	@Autowired
	private TriggerrService triggerservice;
	
	@Autowired
	public TriggerTest() {
		this.triggerservice = new TriggerrServiceImp(triggerepo,triggertrepo);
	}
	
	@BeforeAll
	public static void setUp() {	
		System.out.println("-----> SETUP <-----");
	}
	
	@Nested
	@DisplayName("Save cases")
	class Save{
		
		@Test
		@DisplayName("Save_trigger_valid_test_1")
		private void testSaveTriggerProperly1(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			triggertrepo.save(triggert);
			
			assertTrue(triggerservice.saveTriggerr(20, "Local", "TriggerTest1", 1),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Save_trigger_valid_test_2")
		private void testSaveTriggerProperly2(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(30);
			triggertrepo.save(triggert);
			
			assertTrue(triggerservice.saveTriggerr(13, "Remote", "TriggerTest2", 1),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Save_trigger_invalid_test_1")
		private void testSaveTriggerImproperly1(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(15);
			triggertrepo.save(triggert);
			
			assertTrue(triggerservice.saveTriggerr(3, "Remote", "", 1),
					"The entity was saved even thought improper values were found");
		}
		
		@Test
		@DisplayName("Save_trigger_invalid_test_2")
		private void testSaveTriggerImproperly2(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(20);
			triggertrepo.save(triggert);
			
			assertTrue(triggerservice.saveTriggerr(63, "", "TriggerTest3", 1),
					"The entity was saved even thought improper values were found");
		}
		
		@Test
		@DisplayName("Save_trigger_invalid_test_3")
		private void testSaveTriggerImproperly3(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(100);
			triggertrepo.save(triggert);
			
			assertTrue(triggerservice.saveTriggerr(10, "Regional", "TriggerTest4", 1),
					"The entity was saved even thought improper values were found");
		}
	}
	
	@Nested
	@DisplayName("Edit cases")
	class Edit{
		
		@Test
		@DisplayName("Edit_trigger_valid_test")
		private void testEditTriggerProperly(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			triggertrepo.save(triggert);
			
			triggerservice.saveTriggerr(20, "Local", "TriggerTest1", 1);
			
			assertTrue(triggerservice.editTriggerr(1, "Remoto", "newTriggerTest1"),
					"Could not find the entity to edit");
		}
		
		@Test
		@DisplayName("Edit_trigger_invalid_test1")
		private void testEditTriggerImproperly1(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			triggertrepo.save(triggert);
			
			triggerservice.saveTriggerr(20, "Local", "TriggerTest1", 1);
			
			assertTrue(triggerservice.editTriggerr(17, "Remoto", "newTriggerTest1"),
					"The entity to edit was found even thought does not supposed to exist");
		}
		
		@Test
		@DisplayName("Edit_trigger_invalid_test2")
		private void testEditTriggerImproperly2(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			triggertrepo.save(triggert);
			
			triggerservice.saveTriggerr(20, "Local", "TriggerTest1", 1);
			
			assertFalse(triggerservice.editTriggerr(1, "Remoto", ""),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_trigger_invalid_test3")
		private void testEditTriggerImproperly3(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			triggertrepo.save(triggert);
			
			triggerservice.saveTriggerr(20, "Local", "TriggerTest1", 1);
			
			assertFalse(triggerservice.editTriggerr(1, "", "newTriggerTest2"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_trigger_invalid_test4")
		private void testEditTriggerImproperly4(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			triggertrepo.save(triggert);
			
			triggerservice.saveTriggerr(20, "Local", "TriggerTest1", 1);
			
			assertFalse(triggerservice.editTriggerr(1, "Regional", "newTriggerTest3"),
					"Could not edit entity due to unacceptable values");
		}
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}