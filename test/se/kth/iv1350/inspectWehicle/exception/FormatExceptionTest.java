package se.kth.iv1350.inspectWehicle.exception;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.inspectVehicle.integration.DBCaller;

@SuppressWarnings("unused")
public class FormatExceptionTest {
	DBCaller db;
	String formatOK = "ABC123";
	String formatDigitBu = "AAAA11";
	String formatLetterBu = "AA1111";
	
	@Before
	public void setUp() {
		db = new DBCaller();
		
	}
	
	@After
	public void tearDown() {
		db = null;
	}

//	@Test
//	public void testFormatException_PASS() {
//		db.regNumberValid(formatOK);
//		
//	}
//	
//	@Test
//	public void testFormatException_FAILLETTER() {
//		db.regNumberValid(formatLetterBu);
//		
//	}
//
//	@Test
//	public void testFormatException_FAILDIGIT() {
//		db.regNumberValid(formatDigitBu);
//		
//	}

}
