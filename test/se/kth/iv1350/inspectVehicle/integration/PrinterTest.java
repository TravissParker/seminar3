package se.kth.iv1350.inspectVehicle.integration;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.inspectVehicle.model.Inspection;
import se.kth.iv1350.inspectVehicle.model.Receipt;

public class PrinterTest {
	Printer printer = new Printer();
	ByteArrayOutputStream outContent;
	Receipt rec = new Receipt(700, 1000, 300);
	private Inspection insp;
	private String regNumber = "ABC123";
	SubInspection[] subInspection = { new SubInspection("Brakes", 100), new SubInspection("Tires", 200), new SubInspection("Emission", 300) };
	
	@Before
	public void setUpStreams() {
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
		outContent = null;
		System.setOut(null);
	}
	
	@Test
	public void testPrintReceipt() {
		printer.printReceipt(rec.toString());
		String result = outContent.toString();
		String expected = "\n================================================\nCustomer Receipt:\nAmount due: " + 700 
				+ "\nAmount paid: " + 1000 + "\nChange: "+ 300 + "\n================================================\n";
		assertTrue("Wrong printout.", result.contains(expected));
	}
	
	@Test
	public void testPrintResult() {
		insp = new Inspection(regNumber, subInspection);
		String result = insp.toString();
		printer.printResult(result);
		String expected ="Inspection result for register number: " + this.regNumber + "\n\n" 
				+ "Inspection: Brakes" + "\nInspection Result: " + false + "\nRemark: NO REMARK" + "\n\n" 
				+ "Inspection: Tires" + "\nInspection Result: " + false + "\nRemark: NO REMARK" + "\n\n"
				+ "Inspection: Emission" + "\nInspection Result: " + false + "\nRemark: NO REMARK" + "\n\n";
//		assertTrue("Wrong printout.", result.contains(expected));
		assertEquals("Strings do not match", expected, result);
		
		insp = null;
	}
	
}
