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
import com.edu.icesi.ci.taller1pruebasjuanvalencia.model.Userselect;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.TriggerrRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.repository.UserselectRepository;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.UserselectService;
import com.edu.icesi.ci.taller1pruebasjuanvalencia.service.UserselectServiceImp;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1PruebasJuanvalenciaApplication.class)
class UserselectTest {

	@Mock
	private TriggerrRepository triggerepo;
	
	@Mock
	private UserselectRepository userselectrepo;
	
	@InjectMocks
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
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 14)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser1");
			userselect.get().setUsselWherestatement("When");
			
			when(userselectrepo.findById((long) 28)).thenReturn(userselect);
			
			assertTrue(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					14),"The entity could not be saved");
			
			assertEquals(userselect, userselectrepo.findById((long)28),
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_usersel_valid_test2")
		private void testSaveUserSelectProperly2() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(98);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 98)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(16);
			userselect.get().setUsselTablename("Students");
			userselect.get().setUsselValuekeycolumn("");
			userselect.get().setUsselValueusercolumn("TestUser2");
			userselect.get().setUsselWherestatement("If");
			
			when(userselectrepo.findById((long) 16)).thenReturn(userselect);
			
			assertTrue(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					98),"The entity could not be saved");
			
			assertEquals(userselect, userselectrepo.findById((long)16),
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_usersel_valid_test3")
		private void testSaveUserSelectProperly3() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(34);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 34)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(68);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("");
			userselect.get().setUsselValueusercolumn("TestUser3");
			userselect.get().setUsselWherestatement("If only if");
			
			when(userselectrepo.findById((long) 68)).thenReturn(userselect);
			
			assertTrue(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					34),"The entity could not be saved");
			
			assertEquals(userselect, userselectrepo.findById((long) 68),
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_usersel_valid_test4")
		private void testSaveUserSelectProperly4() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(44);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 44)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(78);
			userselect.get().setUsselTablename("Guesses");
			userselect.get().setUsselValuekeycolumn("FK");
			userselect.get().setUsselValueusercolumn("TestUser4");
			userselect.get().setUsselWherestatement("Else");
			
			when(userselectrepo.findById((long) 78)).thenReturn(userselect);
			
			assertTrue(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					44),"The entity could not be saved");
			
			assertEquals(userselect, userselectrepo.findById((long) 78),
					"The saved entity was not the expected one");
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test1")
		private void testSaveUserSelectImproperly1() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(41);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 41)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("Students uni");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser5");
			userselect.get().setUsselWherestatement("Only");
			
			assertFalse(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					41),"The entity was saved");		
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test2")
		private void testSaveUserSelectImproperly2() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(102);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 102)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(66);
			userselect.get().setUsselTablename("Collaborators");
			userselect.get().setUsselValuekeycolumn("F PK");
			userselect.get().setUsselValueusercolumn("TestUser6");
			userselect.get().setUsselWherestatement("While");
			
			assertFalse(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					102),"The entity was saved");		
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test3")
		private void testSaveUserSelectImproperly3() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(88);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 88)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(95);
			userselect.get().setUsselTablename("Teachers");
			userselect.get().setUsselValuekeycolumn("FK");
			userselect.get().setUsselValueusercolumn("");
			userselect.get().setUsselWherestatement("For");
			
			assertFalse(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					88),"The entity was saved");		
		}
		
		@Test
		@DisplayName("Save_usersel_invalid_test4")
		private void testSaveUserSelectImproperly4() {
			Triggerr trig = new Triggerr();
			trig.setTrigId(51);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 51)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(702);
			userselect.get().setUsselTablename("Buildings");
			userselect.get().setUsselValuekeycolumn("FPK");
			userselect.get().setUsselValueusercolumn("TestUser7");
			userselect.get().setUsselWherestatement("");
			
			assertFalse(userselectservice.saveUserSelect(userselect.get().getUsselId(), 
					userselect.get().getUsselTablename(), 
					userselect.get().getUsselValuekeycolumn(),
					userselect.get().getUsselValueusercolumn(), 
					userselect.get().getUsselWherestatement(), 
					51),"The entity was saved");		
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
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 14)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser1");
			userselect.get().setUsselWherestatement("When");
			
			when(userselectrepo.findById((long) 28)).thenReturn(userselect);
			
			assertTrue(userselectservice.editUserSelect(28, "newTableName1", "FK", "newTestUser1", "For"),
					"The entity could not be saved");
		}
		
		@Test
		@DisplayName("Edit_usersel_invalid_test1")
		private void testEditUserSelectImproperly1(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 14)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser1");
			userselect.get().setUsselWherestatement("When");
			
			when(userselectrepo.findById((long) 28)).thenReturn(userselect);
			
			assertFalse(userselectservice.editUserSelect(8, "newTableName1", "FK", "newTestUser1", "For"),
					"The entity to edit was found even thought does not supposed to exist");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test2")
		private void testEditUserSelectImproperly2(){
			
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 14)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser1");
			userselect.get().setUsselWherestatement("When");
			
			when(userselectrepo.findById((long) 28)).thenReturn(userselect);
			
			assertFalse(userselectservice.editUserSelect(28, "new TableName", "FK", "newTestUser1", "For"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test3")
		private void testEditUserSelectImproperly3(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 14)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser1");
			userselect.get().setUsselWherestatement("When");
			
			when(userselectrepo.findById((long) 28)).thenReturn(userselect);
			
			assertFalse(userselectservice.editUserSelect(28, "newTableName2", "F PK", "newTestUser2", "For"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test4")
		private void testEditUserSelectImproperly4(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 14)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser1");
			userselect.get().setUsselWherestatement("When");
			
			when(userselectrepo.findById((long) 28)).thenReturn(userselect);
			
			assertFalse(userselectservice.editUserSelect(28, "newTableName3", "FK", "", "For"),
					"Could not edit entity due to unacceptable values");
		}
		@Test
		@DisplayName("Edit_usersel_invalid_test5")
		private void testEditUserSelectImproperly5(){
			Triggerr trig = new Triggerr();
			trig.setTrigId(14);
			Optional<Triggerr> trigger = Optional.of(trig);
			
			when(triggerepo.findById((long) 14)).thenReturn(trigger);
			
			Optional<Userselect> userselect = Optional.of(new Userselect());
			userselect.get().setUsselId(28);
			userselect.get().setUsselTablename("");
			userselect.get().setUsselValuekeycolumn("PK");
			userselect.get().setUsselValueusercolumn("TestUser1");
			userselect.get().setUsselWherestatement("When");
			
			when(userselectrepo.findById((long) 28)).thenReturn(userselect);
			
			assertFalse(userselectservice.editUserSelect(28, "newTableName3", "FPK", "newTestUser3", ""),
					"Could not edit entity due to unacceptable values");
		}
	}
	
	@AfterAll
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
