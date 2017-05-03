package se.kth.iv1350.inspectVehicle.controller;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.integration.Printer;

public class ControllerTest {
	private Controller cont;
	private String regPass = "ABC123";
	private String regFail = "ZZZ999";
	private CreditCardDTO card = new CreditCardDTO(1234, "1234 5678", "C. Money", "17/09", 333);
	private int cashPayment = 1000;
	
	Printer printer = new Printer();
	ByteArrayOutputStream outContent;

	
	@Before
	public void setUp() {
		cont = new Controller();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	
		
	}
	
	@After
	public void tearDown() {
		cont = null;
		outContent = null;
		System.setOut(null);
	}
	
	@Test 
	public void testCheckForInspection_Success() {
		cont.checkForInspection(regPass);
		String result = outContent.toString();
		String expected = "Total cost: 600";
		assertTrue("Wrong printout.", result.contains(expected));
	
	}
	
	@Test 
	public void testCheckForInspection_Failure() {
		cont.checkForInspection(regFail);
		String result = outContent.toString();
		String expected = "Error message: Register number could not be found, please try again.";
		assertTrue("Wrong printout.", result.contains(expected));
		
	}

	@Test
	public void testPayInspectionCard() {
		cont.checkForInspection("ABC123");
		cont.payInspectionCard(card);
		boolean expected = true;
		boolean result = cont.getPaymentStatus();
//		boolean result = cont.inspectionManager.currentInspection.getInspectionPaid();
		
		assertEquals(expected, result);
	}

	@Test
	public void testPayInspectionCahs() {
		cont.checkForInspection("ABC123");
		cont.payInspectionCash(cashPayment);
		boolean expected = true;
		boolean result = cont.getPaymentStatus();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetInspectionCost() {
		
	}

}
