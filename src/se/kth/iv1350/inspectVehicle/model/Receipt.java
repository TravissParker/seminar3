package se.kth.iv1350.inspectVehicle.model;

@SuppressWarnings("unused")
class Receipt {//Test[X]
	private int amountDue;
	
	Receipt(Cost amountPaid) {
		this.amountDue = amountPaid.getCost();;
	}
	

	private void setAmountDue(int amountDue) {
		this.amountDue = amountDue;
	}

	public String toString() {//Test[T]
		String s = "Customer Receipt:" + "\nAmount due: " + amountDue;
		return s;
	}
	
	
}
