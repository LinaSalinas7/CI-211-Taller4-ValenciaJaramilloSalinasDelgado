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
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.Autotransition;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.FevEventstatus;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.FevInstitution;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.AutotransitionRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.FevEventstatusRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.FevInstitutionRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.AutotransitionService;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.AutotransitionServiceImp;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1PruebasJuanvalenciaApplication.class)
public class AutotransitionTest {

	@Mock
	private AutotransitionRepository autotranrepo; 
	
	@Mock
	private FevInstitutionRepository fevinstrepo;
	
	@Mock
	private FevEventstatusRepository eventstatrepo;
	
	@InjectMocks
	private AutotransitionService autotransitionservice;
	
	@Autowired
	public AutotransitionTest() {
		this.autotransitionservice = new AutotransitionServiceImp(autotranrepo,fevinstrepo, eventstatrepo);
	}
	
	@BeforeAll
	public static void setUp() {	
		System.out.println("-----> SETUP <-----");
	}
	
	@Nested
	@DisplayName("Save Cases")
	class Save{
		@Test
		@DisplayName("Save_autotran_valid_test_1")
		public void testSaveAutoTransitionProperly1() {
			
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(13);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 13)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(20);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 20)).thenReturn(fevevst);
		
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(2002);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("AND");
			autotransition.get().setAutotranName("AutotransitionTest");
			
			autotransition.get().setFevInstitution(fevinstrepo.findById((long) 13).get());
			autotransition.get().setFevEventStatus(eventstatrepo.findById((long) 20).get());
							
			when(autotranrepo.findById((long) 2002)).thenReturn(autotransition);
						
			assertTrue(autotransitionservice.saveAutoTransition(autotransition.get().getAutotranId(), 
					autotransition.get().getAutotranIsactive(), 
					autotransition.get().getAutotranName(), 
					autotransition.get().getAutotranLogicaloperand(), 
					13, 20),"The entity could not be saved");
			
			assertEquals(autotransition,autotranrepo.findById((long) 2002),
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_autotran_valid_test_2")
		public void testSaveAutoTransitionProperly2() {
			
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(18);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 18)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(8);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 8)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(28);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("OR");
			autotransition.get().setAutotranName("AutotransitionTest2");
			
			autotransition.get().setFevInstitution(fevinstrepo.findById((long) 18).get());
			autotransition.get().setFevEventStatus(eventstatrepo.findById((long) 8).get());
			
			when(autotranrepo.findById((long) 28 )).thenReturn(autotransition);
			
			assertTrue(autotransitionservice.saveAutoTransition(autotransition.get().getAutotranId(), 
					autotransition.get().getAutotranIsactive(), 
					autotransition.get().getAutotranName(), 
					autotransition.get().getAutotranLogicaloperand(), 
					18, 8),"The entity could not be saved");
			
			assertEquals(autotransition,autotranrepo.findById((long) 28),
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_autotran_valid_test_3")
		public void testSaveAutoTransitionProperly3() {
			
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(22);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 22)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(2);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 2)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(18);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("AND");
			autotransition.get().setAutotranName("AutotransitionTest3");
			
			autotransition.get().setFevInstitution(fevinstrepo.findById((long) 22).get());
			autotransition.get().setFevEventStatus(eventstatrepo.findById((long) 2).get());
			
			when(autotranrepo.findById((long) 18 )).thenReturn(autotransition);
			
			assertTrue(autotransitionservice.saveAutoTransition(autotransition.get().getAutotranId(), 
					autotransition.get().getAutotranIsactive(), 
					autotransition.get().getAutotranName(), 
					autotransition.get().getAutotranLogicaloperand(), 
					22, 2),"The entity could not be saved");			
			
			assertEquals(autotransition,autotranrepo.findById((long) 18),
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_autotran_valid_test_4")
		public void testSaveAutoTransitionProperly4() {
			
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(17);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 17)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(7);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 7)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(8);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("OR");
			autotransition.get().setAutotranName("AutotransitionTest4");
			
			autotransition.get().setFevInstitution(fevinstrepo.findById((long) 17).get());
			autotransition.get().setFevEventStatus(eventstatrepo.findById((long) 7).get());
			
			when(autotranrepo.findById((long) 8 )).thenReturn(autotransition);
			
			assertTrue(autotransitionservice.saveAutoTransition(autotransition.get().getAutotranId(), 
					autotransition.get().getAutotranIsactive(), 
					autotransition.get().getAutotranName(), 
					autotransition.get().getAutotranLogicaloperand(), 
					17, 7),"The entity could not be saved");
			
			assertEquals(autotransition,autotranrepo.findById((long) 8),
					"The saved entity was not the expected one");
		}
				
		@Test
		@DisplayName("Save_autotran_invalid_test_1")
		public void testSaveAutoTransitionImproperly1() {

			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(21);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 21)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(1);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 1)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(48);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("AND");
			autotransition.get().setAutotranName("");
			
			autotransition.get().setFevInstitution(fevinstrepo.findById((long) 21).get());
			autotransition.get().setFevEventStatus(eventstatrepo.findById((long) 1).get());
									
			assertFalse(autotransitionservice.saveAutoTransition(autotransition.get().getAutotranId(), 
					autotransition.get().getAutotranIsactive(), 
					autotransition.get().getAutotranName(), 
					autotransition.get().getAutotranLogicaloperand(), 
					21, 1), "The entity was saved even thought improper values were found");
			
		}
		
		@Test
		@DisplayName("Save_autotran_invalid_test_2")
		public void testSaveAutoTransitionImproperly2() {
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(7);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 7)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(40);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 40)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(8);
			autotransition.get().setAutotranIsactive("F");
			autotransition.get().setAutotranLogicaloperand("OR");
			autotransition.get().setAutotranName("AutrotransitionTest5");
			
			autotransition.get().setFevInstitution(fevinstrepo.findById((long) 7).get());
			autotransition.get().setFevEventStatus(eventstatrepo.findById((long) 40).get());
			
			when(autotranrepo.findById((long) 8 )).thenReturn(autotransition);
			
			assertFalse(autotransitionservice.saveAutoTransition(autotransition.get().getAutotranId(), 
					autotransition.get().getAutotranIsactive(), 
					autotransition.get().getAutotranName(), 
					autotransition.get().getAutotranLogicaloperand(), 
					7, 40), "The entity was saved even thought improper values were found");
		}
		
		@Test
		@DisplayName("Save_autotran_invalid_test_3")
		public void testSaveAutoTransitionImproperly3() {
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(19);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 19)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(9);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 9)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(12);
			autotransition.get().setAutotranIsactive("N");
			autotransition.get().setAutotranLogicaloperand("XOR");
			autotransition.get().setAutotranName("AutotransitionTest6");
			
			autotransition.get().setFevInstitution(fevinstrepo.findById((long) 19).get());
			autotransition.get().setFevEventStatus(eventstatrepo.findById((long) 9).get());
			
			when(autotranrepo.findById((long) 12 )).thenReturn(autotransition);
			
			assertFalse(autotransitionservice.saveAutoTransition(autotransition.get().getAutotranId(), 
					autotransition.get().getAutotranIsactive(), 
					autotransition.get().getAutotranName(), 
					autotransition.get().getAutotranLogicaloperand(), 
					19, 9), "The entity was saved even thought improper values were found");
		}
	}
	
	@Nested
	@DisplayName("Edit cases")
	class Edit{
		@Test
		@DisplayName("Edit_autotran_valid_test")
		public void testEditAutoTransitionProperly(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(29);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 29)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(3);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 3)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(1);
			autotransition.get().setAutotranIsactive("N");
			autotransition.get().setAutotranLogicaloperand("OR");
			autotransition.get().setAutotranName("AutotransitionTest7");
			
			when(autotranrepo.findById((long) 1)).thenReturn(autotransition);
			
			assertTrue(autotransitionservice.editTransition(1, "Y", "NewAutotransitionTest1", "AND"), 
					"Could not find the entity to edit");
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test1")
		public void testEditAutoTransitionImproperly1(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(29);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 29)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(3);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 3)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(1);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("AND");
			autotransition.get().setAutotranName("AutotransitionTest7");
			
			when(autotranrepo.findById((long) 1)).thenReturn(autotransition);
			
			assertFalse(autotransitionservice.editTransition(15, "N", "OR", "NewAutotransitionTest1"), 
					"The entity to edit was found even thought does not supposed to exist");
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test2")
		public void testEditAutoTransitionImproperly2(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(29);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 29)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(3);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 3)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(1);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("AND");
			autotransition.get().setAutotranName("AutotransitionTest7");
			
			when(autotranrepo.findById((long) 1)).thenReturn(autotransition);
			
			assertFalse(autotransitionservice.editTransition(1, "N", "OR", ""), 
					"Could not edit entity due to unacceptable values");
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test3")
		public void testEditAutoTransitionImproperly3(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(29);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 29)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(3);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 3)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(1);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("AND");
			autotransition.get().setAutotranName("AutotransitionTest7");
			
			when(autotranrepo.findById((long) 1)).thenReturn(autotransition);
			
			assertFalse(autotransitionservice.editTransition(15, "F", "OR", "NewAutotransitionTest2"), 
					"Could not edit entity due to unacceptable values");
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test4")
		public void testEditAutoTransitionImproperly4(){
			//Dummy object para fevinstitution		
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(29);
			Optional<FevInstitution>fevinst = Optional.of(fevinstit);					
			
			when(fevinstrepo.findById((long) 29)).thenReturn(fevinst);
			
			//Dummy object para feveventstatus
			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(3);
			Optional<FevEventstatus>fevevst = Optional.of(fevevstat);	
			
			when(eventstatrepo.findById((long) 3)).thenReturn(fevevst);
			
			//Dummy object para autotransition
			Optional<Autotransition> autotransition = Optional.of(new Autotransition());
			autotransition.get().setAutotranId(1);
			autotransition.get().setAutotranIsactive("Y");
			autotransition.get().setAutotranLogicaloperand("AND");
			autotransition.get().setAutotranName("AutotransitionTest7");
			
			when(autotranrepo.findById((long) 1)).thenReturn(autotransition);
			
			assertFalse(autotransitionservice.editTransition(1, "N", "XOR", "NewAutotransitionTest3"), 
					"Could not edit entity due to unacceptable values");
		}
		
	}
		
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}