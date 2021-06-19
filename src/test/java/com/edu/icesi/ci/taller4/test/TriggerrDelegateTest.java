package com.edu.icesi.ci.taller4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.icesi.ci.taller4.front.bd.Imp.TriggerDelegateImp;
import com.edu.icesi.ci.taller4.front.model.clases.Triggerr;

@SpringBootTest
class TriggerrDelegateTest {
	
	@Mock
	TriggerDelegateImp trigdelegate;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("---Start Test---");
	}
	
	@Test
	public void saveTriggerrTest() {
		Triggerr triggerr = new Triggerr();
		triggerr.setTrigId(23);
		when(trigdelegate.findById(23L)).thenReturn(triggerr);
		trigdelegate.save(triggerr);
		assertNotNull(trigdelegate.findById(23L), "The triggerr should not be null");
	}
	
	@Test
	public void editTriggerrTest() {
		Triggerr triggerr = new Triggerr();
		triggerr.setTrigId(123);
		when(trigdelegate.findById(123)).thenReturn(triggerr);
		triggerr.setTrigId(321);
		trigdelegate.edit(123,triggerr);
		assertEquals(triggerr.getTrigId(), trigdelegate.findById(123).getTrigId(),
				"The triggerr should not be equals");
	}
	
	@Test
	public void findAllTriggerrTest() {
		Triggerr triggerr = new Triggerr();
		triggerr.setTrigId(99);
		Triggerr triggerr2 = new Triggerr();
		triggerr2.setTrigId(88);
		ArrayList<Triggerr> list = new ArrayList<>();
		list.add(triggerr);
		list.add(triggerr2);
		when(trigdelegate.findAll()).thenReturn(list);
		assertNotNull((trigdelegate.findAll()), "The list should not be null");
	}
	
	@Test
	public void findByIdTriggerrTest() {
		Triggerr triggerr = new Triggerr();
		triggerr.setTrigId(12);
		when(trigdelegate.findById(12)).thenReturn(triggerr);
		assertNotNull(trigdelegate.findById(12), "The trigger should not be null");
	}
	
	@AfterAll
	public static void finish() {
		System.out.println("---Finished test---");
	}

}
