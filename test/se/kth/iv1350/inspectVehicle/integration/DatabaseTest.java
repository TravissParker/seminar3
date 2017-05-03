package se.kth.iv1350.inspectVehicle.integration;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseTest {
	static Database database;
	
	@BeforeClass
	public static void setUpClass() {
		database = new Database();
	}
	
	@AfterClass
	public static void tearDownClass() {
		database = null;
	}

	@Test
	public void testGetIndexSucceed() {
		String  regNumber = "XYZ789";
		int expected = 1;
		int result = database.getIndex(regNumber);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetIndexFail() {
		String  regNumber = "ABB123";
		int expected = -1;
		int result = database.getIndex(regNumber);
		
		assertEquals(expected, result);
	}

}
