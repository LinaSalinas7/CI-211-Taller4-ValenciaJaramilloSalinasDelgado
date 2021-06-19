package com.edu.icesi.ci.taller4.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import com.edu.icesi.ci.taller4.front.bd.Imp.AutotransitionDelegateImp;
import com.edu.icesi.ci.taller4.front.model.clases.Autotransition;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller4RESTJuanValenciaLinasSalinasApplication.class)
class AutotransitionDelegateTest {

	@Mock
	AutotransitionDelegateImp autotrandelegate;

	@BeforeAll
	public static void setUp() {
		System.out.println("---Start Test---");
	}

	@Test
	public void saveAutotransitionTest() {
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(1);
		when(autotrandelegate.findById(1)).thenReturn(autotransition);
		autotransition.setAutotranIsactive("Y");
		autotransition.setAutotranLogicaloperand("OR");
		autotransition.setAutotranName("Lina");
		autotrandelegate.save(autotransition);
		assertEquals(autotrandelegate.findById(1).getAutotranId(), autotransition.getAutotranId(),
				"The ID should be 10");
	}

	@Test
	public void editAutotransitionTest() throws Exception {
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(777);
		autotransition.setAutotranName("pepesan");
		when(autotrandelegate.findById(777)).thenReturn(autotransition);
		autotrandelegate.save(autotransition);
		autotrandelegate.edit(777,autotransition);
		assertNotEquals("pepe san", autotrandelegate.findById(777).getAutotranName(),
				"The name should no be the same");
	}

	@Test
	public void findAllAutotransitionTest() {
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(143214132);
		autotransition.setAutotranName("lucho");
		autotransition.setAutotranLogicaloperand("AND");
		Autotransition autotransition2 = new Autotransition();
		autotransition.setAutotranId(12341324);
		autotransition.setAutotranName("lucho");
		autotransition.setAutotranLogicaloperand("AND");
		ArrayList<Autotransition> list = new ArrayList<Autotransition>();
		list.add(autotransition);
		list.add(autotransition2);
		when(autotrandelegate.findAll()).thenReturn(list);
		assertNotNull(autotrandelegate.findAll(), "The list should not be null");
	}
	
	@Test
	public void findByIdAutotransitionTest() {
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(9999999);
		autotransition.setAutotranName("yummy");
		autotransition.setAutotranLogicaloperand("OR");
		when(autotrandelegate.findById(9999999)).thenReturn(autotransition);
		assertEquals(autotransition, autotrandelegate.findById(9999999), "The object is different");
	}
	
	@AfterAll
	public static void finish() {
		System.out.println("---Finished test---");
	}
}