package se.kth.iv1350.inspectVehicle.model;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import se.kth.iv1350.inspectVehicle.integration.DBCaller;
import se.kth.iv1350.inspectVehicle.integration.Database;
import se.kth.iv1350.inspectVehicle.integration.Printer;
import se.kth.iv1350.inspectVehicle.integration.SubInspection;
@SuppressWarnings(value = "unused")
public class InspectionManagerTest {
	private InspectionManager IM;
	private String regNumberExistA = "ABC123";
	private String regNumberExistZ = "XYZ789";
	private String regNumberNotExist = "ZZZ000";
	
	@Before
	public void setUp() {
		IM = new InspectionManager();
	}
	
	@After
	public void tearDown() {
		IM = null;
	}
	
	@Test
	public void testIsRegNumberValidSuccessA() {
		IM.isRegNumberValid(regNumberExistA);
		int expectedCost = 600;
		int actualCost = IM.getCurrentInspection().getCostObj().getCost();
		assertEquals(expectedCost, actualCost);
	}
	
	@Test
	public void testIsRegNumberValidSuccessZ() {
		IM.isRegNumberValid(regNumberExistZ);
		int expectedCost = 600;
		int actualCost = IM.getCurrentInspection().getCostObj().getCost();
		assertEquals(expectedCost, actualCost);
	}
	
	@Test
	public void testIsRegNumberValidFailed() {
		IM.isRegNumberValid(regNumberNotExist);
		String expectedMsg = "Error message: Register number could not be found, please try again.";
		String errorMsg = IM.getErrorMsg();
		assertEquals(expectedMsg, errorMsg);
	}
	
	@Test
	public void testCreateInspection() {
		assertNull("CurrentInspection is not null.", IM.getCurrentInspection());
		IM.createInspection(regNumberExistA);
		assertNotNull("CurrentInspection is Null.",IM.getCurrentInspection());
	}
	
	@Test
	public void testGetCostObj() {
		IM.createInspection(regNumberExistA);
		assertNotNull("getCostObj returned a null pointer.", IM.getCostObj());
	}
	
	@Test
	public void testSetGetInspectionPaid() {
		IM.createInspection(regNumberExistA);
		assertFalse(IM.getInspectionPaid());
		IM.setInspectionPaid(true);
		assertTrue(IM.getInspectionPaid());
	}
	
	@Test
	public void testUpdateDatabase() {
		SubInspection[] sub = { new SubInspection("Brakes", 100), new SubInspection("Tires", 200), new SubInspection("Emission", 300) };
		DBCaller db = new DBCaller();
		Database database = new Database();
		db.submitResults(regNumberExistA, sub);
		assertEquals(true, database.databaseUpdated);
	}
}
