package com.edu.icesi.ci.taller4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.edu.icesi.ci.taller4.Taller4RESTJuanValenciaLinasSalinasApplication;
import com.edu.icesi.ci.taller4.front.bd.Imp.TriggersTypeDelegateImp;
import com.edu.icesi.ci.taller4.front.model.clases.Triggertype;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller4RESTJuanValenciaLinasSalinasApplication.class)
class TriggertypeDelegateTest {
	
	@Mock
	TriggersTypeDelegateImp trigtydelegate;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("---Start Test---");
	}
	
	@Test
	public void saveTriggerTypeTest() {
		Triggertype triggerType = new Triggertype();
		triggerType.setTrigtypeId(34);
		when(trigtydelegate.findById(34)).thenReturn(triggerType);
		trigtydelegate.save(triggerType);
		assertNotNull(trigtydelegate.findById(34), "The triggerType should not be null");
	}
	
	@Test
	public void editTriggerrTypeTest() {
		Triggertype triggerrType = new Triggertype();
		triggerrType.setTrigtypeId(123);
		when(trigtydelegate.findById(123)).thenReturn(triggerrType);
		triggerrType.setTrigtypeId(321);
		trigtydelegate.edit(123,triggerrType);
		assertEquals(triggerrType.getTrigtypeId(), trigtydelegate.findById(123).getTrigtypeId(),
				"The triggerrType should not be equals");
	}
	
	@Test
	public void findAllTriggerTypeTest() {
		Triggertype triggerrType = new Triggertype();
		triggerrType.setTrigtypeId(99);
		Triggertype triggerrType2 = new Triggertype();
		triggerrType2.setTrigtypeId(88);
		ArrayList<Triggertype> list = new ArrayList<>();
		list.add(triggerrType);
		list.add(triggerrType2);
		when(trigtydelegate.findAll()).thenReturn(list);
		assertNotNull((trigtydelegate.findAll()), "The list should not be null");
	}
	
	@Test
	public void findByIdTriggerTypeTest() {
		Triggertype triggerrType = new Triggertype();
		triggerrType.setTrigtypeId(12);
		when(trigtydelegate.findById(12)).thenReturn(triggerrType);
		assertNotNull(trigtydelegate.findById(12), "The triggerType should not be null");
	}
	
	@AfterAll
	public static void finish() {
		System.out.println("---Finished test---");
	}
}
