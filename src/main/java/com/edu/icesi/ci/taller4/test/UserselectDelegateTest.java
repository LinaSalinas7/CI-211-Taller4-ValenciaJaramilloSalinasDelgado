//package com.edu.icesi.ci.taller4.test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//import java.util.ArrayList;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.edu.icesi.ci.taller4.front.bd.Imp.UserSelectionDelegateImp;
//import com.edu.icesi.ci.taller4.front.model.clases.Userselect;
//
//import org.junit.jupiter.api.Test;
//
//@SpringBootTest
//class UserselectDelegateTest {
//
//	@Mock
//	UserSelectionDelegateImp usseldelegate;
//	
//	@BeforeAll
//	public static void setUp() {
//		System.out.println("---Start Test---");
//	}
//	
//	@Test
//	public void saveUserSelectTest() {
//		Userselect userselect = new Userselect();
//		userselect.setUsselId(45);
//		when(usseldelegate.findById(45)).thenReturn(userselect);
//		usseldelegate.save(userselect);
//		assertNotNull(usseldelegate.findById(45), "The userSelect should not be null");
//	}
//	
//	@Test
//	public void editUserSelectTest() {
//		Userselect userSelect = new Userselect();
//		userSelect.setUsselId(123);
//		when(usseldelegate.findById(123)).thenReturn(userSelect);
//		userSelect.setUsselId(321);
//		usseldelegate.edit(123,userSelect);
//		assertEquals(userSelect.getUsselId(), usseldelegate.findById(123).getUsselId(),
//				"The userSelect should not be equals");
//	}
//	
//	@Test
//	public void findAllUserSelectTest() {
//		Userselect userSelect = new Userselect();
//		userSelect.setUsselId(99);
//		Userselect userSelect2= new Userselect();
//		userSelect2.setUsselId(88);
//		ArrayList<Userselect> list = new ArrayList<>();
//		list.add(userSelect);
//		list.add(userSelect2);
//		when(usseldelegate.findAll()).thenReturn(list);
//		assertNotNull((usseldelegate.findAll()), "The list should not be null");
//	}
//	
//	@Test
//	public void findByIdUserSelectTest() {
//		Userselect userSelect = new Userselect();
//		userSelect.setUsselId(12);
//		when(usseldelegate.findById(12)).thenReturn(userSelect);
//		assertNotNull(usseldelegate.findById(12), "The userSelect should not be null");
//	}
//	
//	@AfterAll
//	public static void finish() {
//		System.out.println("---Finished test---");
//	}
//
//}
