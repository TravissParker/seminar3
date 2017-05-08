package se.kth.iv1350.inspectVehicle.model;

class CashRegister {//Test[X]
	private int balance = 0;
	
	void updateBalance(Cost cost) {//Test[T]
		this.balance += cost.getCost();
	}
	
	int getBalance() {
		return this.balance;
	}
}
