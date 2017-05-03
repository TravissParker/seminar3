package se.kth.iv1350.inspectVehicle.integration;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubInspectionTest {
	private SubInspection sub;
	private String name;
	private int price;
	private boolean result;
	private String remark = "NO REMARK";
	
	@Before
	public void setUp() {
		name = "Lights";
		price = 499;
		sub = new SubInspection(name, price);
	}
	
	@Test
	public void testToString() {
		String expected = "Inspection: " + name + "\nInspection Result: " + result + "\nRemark: " + remark;;
		String result = sub.toString();
		assertEquals("String representations do not match.", expected, result);
	}
	
	@Test
	public void testGetPrice() {
		int expected = price;
		int result = sub.getPrice();
		
		assertEquals("The variable price and getPrice() do not match.", expected, result);
	}
	
	@Test
	public void testRecordResult() {
		
	}
	
//	@Test
//	public void testSetters() {
//		
//		sub.setRemark("Lights are OK.");
//		sub.setResult(true);
//		String expectedString = "Lights are OK.";
//		boolean expectedBoolean = true;
//		String resultString = sub.getRemark();
//		boolean resultBoolean = sub.getResult();
//		assertEquals("Gotten string do not match expected values.", expectedString, resultString);
//		assertEquals("Gotten boolean do not mathc expected values.", expectedBoolean, resultBoolean);
//		
//	}


}
