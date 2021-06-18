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
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.Triggerr;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggerrRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.UserselectRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.UserselectService;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.UserselectServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1PruebasJuanvalenciaApplication.class)
class UserselectTest {

	@Autowired
	private TriggerrRepository triggerepo;
	
	@Autowired
	private UserselectRepository userselectrepo;
	
	@Autowired
	private UserselectService userselectservice;
	
	@Autowired
	public UserselectTest() {
		this.userselectservice = new UserselectServiceImp(userselectrepo,triggerepo);
	}
	
	@BeforeAll
	public static void setUp() {	
		System.out.println("-----> SETUP <-----");
	}
	
	@Nested
	@DisplayName("Save cases")
	class Save{
		@Test
		@DisplayName("Save_usersel_valid_test1")
		private void testSaveUserSelectProperly1() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			triggerepo.save(trig);
			
			assertTrue(userselectservice.saveUserSelect(25, "","PK","TestUser1","When",1),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Save_usersel_valid_test2")
		private void testSaveUserSelectProperly2() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(24);
			triggerepo.save(trig);
			
			assertTrue(userselectservice.saveUserSelect(25, "Students","","TestUser2","If",1),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Save_usersel_valid_test3")
		private void testSaveUserSelectProperly3() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(44);
			triggerepo.save(trig);
			
			assertTrue(userselectservice.saveUserSelect(25, "","","TestUser3","If only if",1),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Save_usersel_valid_test4")
		private void testSaveUserSelectProperly4() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(34);
			triggerepo.save(trig);
			
			assertTrue(userselectservice.saveUserSelect(25, "Guesses","FK","TestUser4","Else",1),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test1")
		private void testSaveUserSelectImproperly1() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(34);
			triggerepo.save(trig);
			
			assertFalse(userselectservice.saveUserSelect(25, "Students Uni","PK","TestUser5","Only",1),
					"The entity was saved");
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test2")
		private void testSaveUserSelectImproperly2() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(34);
			triggerepo.save(trig);
			
			assertFalse(userselectservice.saveUserSelect(25, "Collaborators","F PK","TestUser6","While",1),
					"The entity was saved");
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test3")
		private void testSaveUserSelectImproperly3() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(34);
			triggerepo.save(trig);
			
			assertFalse(userselectservice.saveUserSelect(25, "Teachers","FK","","For",1),
					"The entity was saved");
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test4")
		private void testSaveUserSelectImproperly4() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(34);
			triggerepo.save(trig);
			
			assertFalse(userselectservice.saveUserSelect(25, "Buildings","FPK","TestUser7","",1),
					"The entity was saved");
		}
	}
	
	@Nested
	@DisplayName("Edit cases")
	class Edit{
		@Test
		@DisplayName("Edit_usersel_valid_test")
		private void testEditUserSelectProperly() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			triggerepo.save(trig);
			
			userselectservice.saveUserSelect(25, "","PK","TestUser1","When",1);
			
			assertTrue(userselectservice.editUserSelect(1, "newTableName1", "FK", "newTestUser1", "For"),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Edit_usersel_invalid_test1")
		private void testEditUserSelectImproperly1(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			triggerepo.save(trig);
			
			userselectservice.saveUserSelect(25, "","PK","TestUser1","When",1);
			
			assertFalse(userselectservice.editUserSelect(8, "newTableName1", "FK", "newTestUser1", "For"),
					"The entity to edit was found even thought does not supposed to exist");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test2")
		private void testEditUserSelectImproperly2(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			triggerepo.save(trig);
			
			userselectservice.saveUserSelect(25, "","PK","TestUser1","When",1);
			
			assertFalse(userselectservice.editUserSelect(28, "new TableName", "FK", "newTestUser1", "For"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test3")
		private void testEditUserSelectImproperly3(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			triggerepo.save(trig);
			
			userselectservice.saveUserSelect(25, "","PK","TestUser1","When",1);
			
			assertFalse(userselectservice.editUserSelect(28, "newTableName2", "F PK", "newTestUser2", "For"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test4")
		private void testEditUserSelectImproperly4(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			triggerepo.save(trig);
			
			userselectservice.saveUserSelect(25, "","PK","TestUser1","When",1);
			
			assertFalse(userselectservice.editUserSelect(28, "newTableName3", "FK", "", "For"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test5")
		private void testEditUserSelectImproperly5(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			triggerepo.save(trig);
			
			userselectservice.saveUserSelect(25, "","PK","TestUser1","When",1);
			
			assertFalse(userselectservice.editUserSelect(28, "newTableName3", "FPK", "newTestUser3", ""),
					"Could not edit entity due to unacceptable values");
		}
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
