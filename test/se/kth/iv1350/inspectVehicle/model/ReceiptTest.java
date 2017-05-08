package se.kth.iv1350.inspectVehicle.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {
	private Receipt rec;
	private PaymentHandler payment;
	private Cost cost;
	
	@Before
	public void setUp() {
		cost  = new Cost(7);
		payment = new PaymentHandler(10, cost);
		rec = new Receipt(payment);
	}
	
	@Test
	public void testToString() {
		String expected = "Customer Receipt:" + "\nAmount due: " + 7 + "\nAmount paid: " + 10 + "\nChange: " + 3;
		String result = rec.toString();
		
		assertEquals("Strings are not identical.", expected, result);
	}

}
