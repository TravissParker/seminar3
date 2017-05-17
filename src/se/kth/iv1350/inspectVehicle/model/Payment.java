package se.kth.iv1350.inspectVehicle.model;

import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.integration.Creditcard;
import se.kth.iv1350.inspectVehicle.integration.Printer;

/**
 * Handles the payment abstraction. 
 *
 */
public class Payment {
	
	private PaymentMode paymentMode;
	private Receipt receipt;
	private Printer printer;
	
	/**
	 * Creates an instance of the class with <code>paymentMode</code> referencing an instance of <code>useCash</code>.
	 * @param amountPaid The amountPaid from the customer. 
	 */
	public Payment(int amountPaid) {
		useCash(amountPaid);
	}
	
	/**
	 * Creates an instance of the class with <code>paymentMode</code> referencing an instance of <code>useCard</code>.
	 * @param card The card information supplied by the user in the UI. 
	 */
	public Payment(CreditCardDTO card) {
		useCard(card);
	}
	
	/**
	 * Sets the <code>paymentMode</code> variable to refer to a new instance of <code>useCard</code>.
	 * @param card The card information supplied by the user in the UI. 
	 */
	public void useCard(CreditCardDTO card){
		paymentMode = new UseCard(card);		
	}
	
	/**
	 * Sets the <code>paymentMode</code> variable to refer to a new instance of <code>useCash</code>.
	 * @param amountPaid The amountPaid from the customer. 
	 */
	public void useCash(int amountPaid){
		paymentMode = new UseCash(amountPaid);		
	}
	
	/**
	 * Performs the payment and makes and prints the <code>recipet</code>
	 * @param amountToPay <code>Cost</code> object that holds the amount to pay.
	 * @return The outcome of the paymet operation, either <code>true</code> or <code>false</code>
	 */
	public boolean performPayment(Cost amountToPay) {
		boolean paymentApproved = paymentMode.pay(amountToPay);
		if(paymentApproved) {
			makeReceipt(amountToPay);
			printReceipt();
		}
		return paymentApproved;
	}
	
	private void makeReceipt(Cost amountToPay) {//Test[R]
		receipt = new Receipt(amountToPay);
	}
	
	private void printReceipt(){//Test[R]
		printer = new Printer();
		printer.printReceipt(this.receipt.toString());
	}
}
