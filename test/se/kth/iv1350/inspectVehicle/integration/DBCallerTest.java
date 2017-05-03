package se.kth.iv1350.inspectVehicle.integration;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBCallerTest {
	DBCaller db;
	String regNumberTrue = "ABC123";
	Database database;
	
	@Before
	public void setUp() {
		db = new DBCaller();
		database = new Database();
	}
	
	@After
	public void tearDown() {
		db = null;
//		database = null;
	}
	
	
	@Test
	public void testRegNumberValidTRUE() {
		boolean expected = true;
		boolean result = db.regNumberValid(regNumberTrue);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testRegNumberValidOTHERTRUE() {
		String regNumber = "XYZ789";
		boolean expected = true;
		boolean result = db.regNumberValid(regNumber);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testRegNumberValidFALSE() {
		String regNumber = "ZZZ999";
		boolean expected = false;
		boolean result = db.regNumberValid(regNumber);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testcreateSubInspectionArray() {
		SubInspection[] manual = { new SubInspection("Brakes", 100), new SubInspection("Tires", 200), new SubInspection("Emission", 300) };
		SubInspection[] automatic = db.createSubInspectionArray(regNumberTrue);
		String m = Arrays.toString(manual);
		String a = Arrays.toString(automatic);
		
		assertEquals(m, a);
	}
	
	@Test
	public void testSubmitResults() {		
		SubInspection[] sub = { new SubInspection("Brakes", 100), new SubInspection("Tires", 200), new SubInspection("Emission", 300) };
		db.submitResults(regNumberTrue, sub);
		assertEquals(true, database.databaseUpdated);
	}
}
