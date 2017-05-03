package se.kth.iv1350.inspectVehicle.model;

/**
 * The class represents a receipt. It gathers needed data from a supplied <code>PaymentHandler</code> object. 
 *
 */
public class Receipt {//Test[X]
	private int amountDue;
	private int amountPaid;
	private int	change = 0;
	
	/**
	 * Creates an instance representing a receipt.
	 * @param payment The <code>PaymentHandler</code> object, created for the current inspection, containing all needed information.
	 */
	public Receipt(PaymentHandler payment) {
		this.amountDue = payment.getAmountDue();
		this.amountPaid = payment.getAmountPaid();
		this.change = payment.getChange();	
	}
	
	//Simpler implementation of constructor used for testing purposes.
	public Receipt(int amountDue, int amountPaid, int change) {
		this.amountDue = amountDue;
		this.amountPaid = amountPaid;
		this.change = change;	
	}
	//Never used
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
