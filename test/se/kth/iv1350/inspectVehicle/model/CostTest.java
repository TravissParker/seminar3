package se.kth.iv1350.inspectVehicle.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CostTest {
	private Cost cost;

	@Test
	public void testCost_INT() {//toString is tested here.
		cost = new Cost(19);
		String expected = "Total cost: " + cost.getCost();
		String result = cost.toString();
		
		assertEquals(expected, result);
	}
	@Test
	public void testCost_COST() {
		Cost costCopy = new Cost(111);
		cost = new Cost(costCopy);		
		String expected = "Total cost: " + cost.getCost();
		String result = cost.toString();
		
		assertEquals(expected, result);
	}

}
