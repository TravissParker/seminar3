package se.kth.iv1350.inspectVehicle.integration;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.inspectVehicle.controller.Controller;


public class PrinterTest {
	Printer printer = new Printer();
	ByteArrayOutputStream outContent;
//	Receipt rec = new Receipt(700, 1000, 300);
//	private Inspection insp;
	private String regNumber = "ABC123";
	SubInspection[] subInspection = { new SubInspection("Brakes", 100), new SubInspection("Tires", 200), new SubInspection("Emission", 300) };
	CreditCardDTO CCDTO = new CreditCardDTO(1234, "1234 5678", "C. Money", "17/09", 333);
	Controller controller;
//	PaymentHandler payment;
	
	@Before
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		controller = new Controller();
		controller.checkForInspection("ABC123");
		
	}
	
	@After
	public void cleanUpStreams() {
		outContent = null;
		System.setOut(null);
	}
	
	
	@Test
	public void testPrintReceipt() {		
		controller.payInspectionCard(CCDTO);
		String result = outContent.toString();
		String expected = "\n================================================\nCustomer Receipt:\nAmount due: " + 600 
				+ "\nAmount paid: " + 600 + "\nChange: "+ 0 + "\n================================================\n";
		assertTrue("Wrong printout.", result.contains(expected));
	}
	

	
	@Test
	public void testPrintResult() {

		controller.fetchNextInspection();
		controller.recordResult(true, "Brakes are in good condition.");
		controller.fetchNextInspection();
		controller.recordResult(false, "Pattern on left front tier is too shallow.");
		controller.fetchNextInspection();
		controller.recordResult(false, "Unacceptable emission levels measured.");
		controller.fetchNextInspection();
		
		String result = outContent.toString();
		String expected ="\n================================================\n" 
				+ "Inspection result for register number: " + this.regNumber + "\n\n" 
				+ "Inspection: Brakes" + "\nInspection Result: " + true + "\nRemark: Brakes are in good condition." + "\n\n" 
				+ "Inspection: Tires" + "\nInspection Result: " + false + "\nRemark: Pattern on left front tier is too shallow." + "\n\n"
				+ "Inspection: Emission" + "\nInspection Result: " + false + "\nRemark: Unacceptable emission levels measured." + "\n\n"
				+ "\n================================================\n";
		assertTrue("Wrong printout.", result.contains(expected));
	}
	
}
