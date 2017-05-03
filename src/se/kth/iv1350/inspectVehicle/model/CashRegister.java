package se.kth.iv1350.inspectVehicle.model;

/**
 * Represents the cash register. It receives it data through a <code>CashPayment</code> object.
 *
 */
public class CashRegister {//Test[X]
	private int balance = 0;
	
	void updateBalance(Cost cost) {//Test[T]
		this.balance += cost.getCost();
	}
	
	int getBalance() {
		return this.balance;
	}
}
