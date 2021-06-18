package com.edu.icesi.ci.taller1pruebasunitariasjuanvalencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.edu.icesi.ci.taller1pruebasjuanvalencia.Taller1PruebasJuanvalenciaApplication;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.Triggerr;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.Triggertype;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggerrRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggertypeRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggerrService;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggerrServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1PruebasJuanvalenciaApplication.class)
public class TriggerTest {

	@Mock
	private TriggertypeRepository triggertrepo;
	
	@Mock
	private TriggerrRepository triggerepo;
	
	@InjectMocks
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
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Local");
			trigger.get().setTrigName("TriggerTest1");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			when(triggerepo.findById((long) 1)).thenReturn(trigger);
			
			assertTrue(triggerservice.saveTriggerr(trigger.get().getTrigId(), 
					trigger.get().getTrigScope(), 
					trigger.get().getTrigName(), 
					0),"The entity could not be saved");
			
			assertEquals(trigger,triggerepo.findById((long) 1),
					"the saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_trigger_valid_test_2")
		private void testSaveTriggerProperly2(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(11);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 11)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(4);
			trigger.get().setTrigScope("Remoto");
			trigger.get().setTrigName("TriggerTest1");
			trigger.get().setTriggertype(triggertrepo.findById((long) 11).get());
			
			when(triggerepo.findById((long) 4)).thenReturn(trigger);
			
			assertTrue(triggerservice.saveTriggerr(trigger.get().getTrigId(), 
					trigger.get().getTrigScope(), 
					trigger.get().getTrigName(), 
					0),"The entity could not be saved");
			
			assertEquals(trigger,triggerepo.findById((long) 4),
					"the saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_trigger_invalid_test_1")
		private void testSaveTriggerImproperly1(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Local");
			trigger.get().setTrigName("");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			assertFalse(triggerservice.saveTriggerr(trigger.get().getTrigId(), 
					trigger.get().getTrigScope(), 
					trigger.get().getTrigName(), 
					0),"The entity was saved even thought improper values were found");
		}
		
		@Test
		@DisplayName("Save_trigger_invalid_test_2")
		private void testSaveTriggerImproperly2(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("");
			trigger.get().setTrigName("TriggerTest3");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			assertFalse(triggerservice.saveTriggerr(trigger.get().getTrigId(), 
					trigger.get().getTrigScope(), 
					trigger.get().getTrigName(), 
					0),"The entity was saved even thought improper values were found");
		}
		
		@Test
		@DisplayName("Save_trigger_invalid_test_3")
		private void testSaveTriggerImproperly3(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Regional");
			trigger.get().setTrigName("TriggerTest4");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			assertFalse(triggerservice.saveTriggerr(trigger.get().getTrigId(), 
					trigger.get().getTrigScope(), 
					trigger.get().getTrigName(), 
					0),"The entity was saved even thought improper values were found");
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
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Local");
			trigger.get().setTrigName("TriggerTest1");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			when(triggerepo.findById((long) 1)).thenReturn(trigger);
			
			assertTrue(triggerservice.editTriggerr(1, "Remoto", "newTriggerTest1"),
					"Could not find the entity to edit");
		}
		
		@Test
		@DisplayName("Edit_trigger_invalid_test1")
		private void testEditTriggerImproperly1(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Local");
			trigger.get().setTrigName("TriggerTest1");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			when(triggerepo.findById((long) 1)).thenReturn(trigger);
			
			assertTrue(triggerservice.editTriggerr(17, "Remoto", "newTriggerTest1"),
					"The entity to edit was found even thought does not supposed to exist");
		}
		
		@Test
		@DisplayName("Edit_trigger_invalid_test2")
		private void testEditTriggerImproperly2(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Local");
			trigger.get().setTrigName("TriggerTest1");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			when(triggerepo.findById((long) 1)).thenReturn(trigger);
			
			assertFalse(triggerservice.editTriggerr(1, "Remoto", ""),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_trigger_invalid_test3")
		private void testEditTriggerImproperly3(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Local");
			trigger.get().setTrigName("TriggerTest1");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			when(triggerepo.findById((long) 1)).thenReturn(trigger);
			
			assertFalse(triggerservice.editTriggerr(1, "", "newTriggerTest2"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_trigger_invalid_test4")
		private void testEditTriggerImproperly4(){
			Triggertype triggert = new Triggertype();
			triggert.setTrigtypeId(0);
			Optional<Triggertype> triggertype = Optional.of(triggert);
			
			when(triggertrepo.findById((long) 0)).thenReturn(triggertype);
			
			Optional<Triggerr> trigger = Optional.of(new Triggerr());
			trigger.get().setTrigId(1);
			trigger.get().setTrigScope("Local");
			trigger.get().setTrigName("TriggerTest1");
			trigger.get().setTriggertype(triggertrepo.findById((long) 0).get());
			
			when(triggerepo.findById((long) 1)).thenReturn(trigger);
			
			assertFalse(triggerservice.editTriggerr(1, "Regional", "newTriggerTest3"),
					"Could not edit entity due to unacceptable values");
		}
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}