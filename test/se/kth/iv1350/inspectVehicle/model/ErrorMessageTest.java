package se.kth.iv1350.inspectVehicle.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ErrorMessageTest {
	ErrorMessage error;
	
	@Test
	public void testAllMethods() {
		error = new ErrorMessage("Message");
		String result = error.getMessage();
		String expected = "Message";
		assertEquals(expected, result);
		result = error.toString();
		expected = "Error message: Message";
		assertEquals(expected, result);		
	}

}
