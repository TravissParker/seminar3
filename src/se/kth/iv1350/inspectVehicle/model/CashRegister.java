package se.kth.iv1350.inspectVehicle.model;

class CashRegister {//Test[X]
	
	private static final CashRegister CASH_REGISTER = new CashRegister();
	private int balance = 0;
	
	private CashRegister() { }
	
	/**
	 * @return The only possible instance of <code>CashRegister</code>.
	 */
	public static CashRegister getCashRegister() {
		return CASH_REGISTER;
	}
	
	void updateBalance(Cost cost) {//Test[T]
		balance += cost.getCost();
	}
	
	int getBalance() {
		return balance;
	}
}
