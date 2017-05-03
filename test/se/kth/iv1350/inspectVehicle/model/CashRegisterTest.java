package se.kth.iv1350.inspectVehicle.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CashRegisterTest {
	private CashRegister cr =  new CashRegister();
	private Cost cost = new Cost(100);
	
	@Test
	public void testUpdateBalance() {
		int before = cr.getBalance();
		cr.updateBalance(cost);
		assertEquals(0, before);
		assertEquals(100, cr.getBalance());		
	}


}
