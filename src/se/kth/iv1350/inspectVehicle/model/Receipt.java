package se.kth.iv1350.inspectVehicle.model;

@SuppressWarnings("unused")
class Receipt {//Test[X]
	private int amountDue;
	private int amountPaid;
	private int	change = 0;
	
	Receipt(PaymentHandler payment) {
		this.amountDue = payment.getAmountDue();
		this.amountPaid = payment.getAmountPaid();
		this.change = payment.getChange();
	}
	

	private void setAmountDue(int amountDue) {
		this.amountDue = amountDue;
	}
	
	private void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
	private void setChange(int change) {
		this.change = change;
	}

	public String toString() {//Test[T]
		String s = "Customer Receipt:" + "\nAmount due: " + amountDue + "\nAmount paid: " + amountPaid + "\nChange: " + change;
		return s;
	}
	
	
}
