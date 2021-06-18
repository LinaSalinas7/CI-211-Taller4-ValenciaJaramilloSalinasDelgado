package com.edu.icesi.ci.taller1pruebasunitariasjuanvalencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.FevInstitution;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.Triggertype;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.FevInstitutionRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggertypeRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggertypeService;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.TriggertypeServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1PruebasJuanvalenciaApplication.class)
public class TriggertypeTest {

	@Mock 
	private TriggertypeRepository triggertrepo;

	@Mock 
	private FevInstitutionRepository fevinstrepo;

	@InjectMocks
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
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(99);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);
			
			when(fevinstrepo.findById((long) 99)).thenReturn(fevinst);
			
			Optional<Triggertype> triggertype = Optional.of(new Triggertype());
			triggertype.get().setTrigtypeId(25);
			triggertype.get().setTrigtypeName("TriggertypeTest1");
			triggertype.get().setFevInstitution(fevinstrepo.findById((long) 99).get());
			triggertype.get().setInstInstId(new BigDecimal(99));
			
			when(triggertrepo.findById((long) 25)).thenReturn(triggertype);
			
			assertTrue(triggertservice.saveTriggerType(triggertype.get().getTrigtypeId(), 
					triggertype.get().getTrigtypeName(), 99),"The entity could not be saved");
			
			assertEquals(triggertrepo.findById((long) 25),triggertype,
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_triigerty_invalid_test")
		public void testSaveTriggerTypeImproperly() {
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(99);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);
			
			when(fevinstrepo.findById((long) 99)).thenReturn(fevinst);
			
			Optional<Triggertype> triggertype = Optional.of(new Triggertype());
			triggertype.get().setTrigtypeId(25);
			triggertype.get().setTrigtypeName("");
			triggertype.get().setFevInstitution(fevinstrepo.findById((long) 99).get());
			triggertype.get().setInstInstId(new BigDecimal(99));
			
			assertFalse(triggertservice.saveTriggerType(triggertype.get().getTrigtypeId(), 
					triggertype.get().getTrigtypeName(), 99),
					"The entity was saved even thought improper values were found");			
		}
	}
	
	@Nested
	@DisplayName("Edit cases")
	class Edit{
		@Test
		@DisplayName("Edit_triggerty_valid_test")
		public void testEditAutoTransitionProperly(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(111);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);
			
			when(fevinstrepo.findById((long) 111)).thenReturn(fevinst);
			
			Optional<Triggertype> triggertype = Optional.of(new Triggertype());
			triggertype.get().setTrigtypeId(5);
			triggertype.get().setTrigtypeName("TriggertypeTest1");
			triggertype.get().setFevInstitution(fevinstrepo.findById((long) 111).get());
			triggertype.get().setInstInstId(new BigDecimal(111));
			
			when(triggertrepo.findById((long) 5)).thenReturn(triggertype);
			
			assertTrue(triggertservice.editTriggerType(5, "newTriggerTypeTest"),
					"Could not find the entity to edit");
		}
		
		@Test
		@DisplayName("Edit_triggerty_invalid_test1")
		public void testEditAutoTransitionImproperly1(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(111);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);
			
			when(fevinstrepo.findById((long) 111)).thenReturn(fevinst);
			
			Optional<Triggertype> triggertype = Optional.of(new Triggertype());
			triggertype.get().setTrigtypeId(5);
			triggertype.get().setTrigtypeName("TriggertypeTest1");
			triggertype.get().setFevInstitution(fevinstrepo.findById((long) 111).get());
			triggertype.get().setInstInstId(new BigDecimal(111));
			
			when(triggertrepo.findById((long) 5)).thenReturn(triggertype);
			
			assertFalse(triggertservice.editTriggerType(25, "newTriggerTypeTest"),
					"The entity to edit was found even thought does not supposed to exist");
		}
		
		@Test
		@DisplayName("Edit_triggerty_invalid_test2")
		public void testEditAutoTransitionImproperly2(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(111);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);
			
			when(fevinstrepo.findById((long) 111)).thenReturn(fevinst);
			
			Optional<Triggertype> triggertype = Optional.of(new Triggertype());
			triggertype.get().setTrigtypeId(5);
			triggertype.get().setTrigtypeName("TriggertypeTest1");
			triggertype.get().setFevInstitution(fevinstrepo.findById((long) 111).get());
			triggertype.get().setInstInstId(new BigDecimal(111));
			
			when(triggertrepo.findById((long) 5)).thenReturn(triggertype);
			
			assertFalse(triggertservice.editTriggerType(5, ""),
					"Could not edit entity due to unacceptable values");
		}
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
