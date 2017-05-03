package se.kth.iv1350.inspectVehicle.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import se.kth.iv1350.inspectVehicle.integration.SubInspection;

public class InspectionTest {
	private Inspection insp;
	private String regNumber = "ABC123";
	SubInspection[] subInspection = { new SubInspection("Brakes", 100), new SubInspection("Tires", 200), new SubInspection("Emission", 300) };
	
	@Before
	public void setUp() {
		insp = new Inspection(regNumber, subInspection);
	}
	
	@After
	public void tearDown() {
		insp = null;
	}

	@Test
	public void summarizePrices() {//Is tested by calling the constructor in @Before.
		Cost cost = insp.getCostObj();
		int expected = 600;		
		int result = cost.getCost();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetSetInspectionPaid() {//Test both the settere and getter
		boolean result = insp.getInspectionPaid();
		assertFalse(result);
		insp.setInspectionPaid(true);
		result = insp.getInspectionPaid();
		assertTrue(result);
	}
	
	@Test
	public void testToString() {
		String expected = "Inspection for register number: " + this.regNumber + "\n" 
						+ "Inspection: Brakes" + "\nInspection Result: " + false + "\nRemark: NO REMARK" + "\n" 
						+ "Inspection: Tires" + "\nInspection Result: " + false + "\nRemark: NO REMARK" + "\n"
						+ "Inspection: Emission" + "\nInspection Result: " + false + "\nRemark: NO REMARK" + "\n";
		
		String result = insp.toString();
		assertEquals("Strings do not match", expected, result);
	}
	
	@Test
	public void testDisplayNextInspection() {
		int i;
		for(i = 0; i < 4; i++) {
			insp.displayNextInspection();
		}
		assertEquals(4, i);
	}
}
