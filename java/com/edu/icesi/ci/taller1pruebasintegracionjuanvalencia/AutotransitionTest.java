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

	@Autowired
	private AutotransitionRepository autotranrepo; 

	@Autowired
	private FevInstitutionRepository fevinstrepo;

	@Autowired
	private FevEventstatusRepository eventstatrepo;

	@Autowired
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

			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(13);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(20);
			eventstatrepo.save(fevevstat);

			assertTrue(autotransitionservice.saveAutoTransition(2002,"Y","AutotransitionTest","AND", 1, 1),
					"The entity could not be saved");
		}

		@Test
		@DisplayName("Save_autotran_valid_test_2")
		public void testSaveAutoTransitionProperly2() {
			
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(3);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(40);
			eventstatrepo.save(fevevstat);

			assertTrue(autotransitionservice.saveAutoTransition(2002,"Y","AutotransitionTest2","OR", 1, 1),
					"The entity could not be saved");
		}

		@Test
		@DisplayName("Save_autotran_valid_test_3")
		public void testSaveAutoTransitionProperly3() {

			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(21);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(16);
			eventstatrepo.save(fevevstat);

			assertTrue(autotransitionservice.saveAutoTransition(2002,"N","AutotransitionTest3","AND", 1, 1),
					"The entity could not be saved");
		}

		@Test
		@DisplayName("Save_autotran_valid_test_4")
		public void testSaveAutoTransitionProperly4() {

			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(15);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(8);
			eventstatrepo.save(fevevstat);

			assertTrue(autotransitionservice.saveAutoTransition(2002,"N","AutotransitionTest4","OR", 1, 1),
					"The entity could not be saved");			
		}

		@Test
		@DisplayName("Save_autotran_invalid_test_1")
		public void testSaveAutoTransitionImproperly1() {

			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(33);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(10);
			eventstatrepo.save(fevevstat);
			
			assertFalse(autotransitionservice.saveAutoTransition(2002,"Y","","AND", 1, 1),
					"The entity could not be saved");	
		}

		@Test
		@DisplayName("Save_autotran_invalid_test_2")
		public void testSaveAutoTransitionImproperly2() {
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(23);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(0);
			eventstatrepo.save(fevevstat);
			
			assertFalse(autotransitionservice.saveAutoTransition(2002,"F","AutotransitionTest5","OR", 1, 1),
					"The entity could not be saved");	
		}

		@Test
		@DisplayName("Save_autotran_invalid_test_3")
		public void testSaveAutoTransitionImproperly3() {
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(93);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(70);
			eventstatrepo.save(fevevstat);
			
			assertFalse(autotransitionservice.saveAutoTransition(2002,"N","AutotransitionTest6","XOR", 1, 1),
					"The entity could not be saved");	
		}
	}

	@Nested
	@DisplayName("Edit cases")
	class Edit{
		@Test
		@DisplayName("Edit_autotran_valid_test")
		public void testEditAutoTransitionProperly(){
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(13);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(30);
			eventstatrepo.save(fevevstat);
			
			autotransitionservice.saveAutoTransition(200,"Y","AutotransitionTest7","AND", 1, 1);
			
			assertTrue(autotransitionservice.editTransition(1, "N", "NewAutotransitionTest1", "OR"),
					"Could not find the entity to edit");	
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test1")
		public void testEditAutoTransitionImproperly1() {
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(3);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(7);
			eventstatrepo.save(fevevstat);
			
			autotransitionservice.saveAutoTransition(200,"Y","AutotransitionTest7","AND", 1, 1);
			
			assertFalse(autotransitionservice.editTransition(200, "N", "NewAutotransitionTest1", "OR"),
					"Could not find the entity to edit");	
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test2")
		public void testEditAutoTransitionImproperly2() {
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(33);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(77);
			eventstatrepo.save(fevevstat);
			
			autotransitionservice.saveAutoTransition(200,"Y","AutotransitionTest7","AND", 1, 1);
			
			assertFalse(autotransitionservice.editTransition(1, "N", "", "OR"),
					"Could not find the entity to edit");	
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test3")
		public void testEditAutoTransitionImproperly3() {
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(103);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(107);
			eventstatrepo.save(fevevstat);
			
			autotransitionservice.saveAutoTransition(200,"Y","AutotransitionTest7","AND", 1, 1);
			
			assertFalse(autotransitionservice.editTransition(1,"F", "OR", "NewAutotransitionTest2"),
					"Could not find the entity to edit");	
		}
		
		@Test
		@DisplayName("Edit_autotran_invalid_test4")
		public void testEditAutoTransitionImproperly4() {
			FevInstitution fevinstit = new FevInstitution();
			fevinstit.setInstId(103);
			fevinstrepo.save(fevinstit);

			FevEventstatus fevevstat = new FevEventstatus();
			fevevstat.setEvestatId(107);
			eventstatrepo.save(fevevstat);
			
			autotransitionservice.saveAutoTransition(200,"Y","AutotransitionTest7","AND", 1, 1);
			
			assertFalse(autotransitionservice.editTransition(1,"N", "XOR", "NewAutotransitionTest3"),
					"Could not find the entity to edit");	
		}
	}

	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}