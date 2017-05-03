package se.kth.iv1350.inspectVehicle.model;

import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.integration.Creditcard;
import se.kth.iv1350.inspectVehicle.integration.Printer;


/**
 * Represents either a cash or card payment.
 *
 */
public class PaymentHandler {//Test[O - Take another look at untested methods/inner class]
	CardPayment cardPayment;//Changed to package for testing
	CashPayment cashPayment;//Changed to package for testing
	private Cost amountToPay;
	private int amountPaid;
	private Receipt receipt;
	private Printer printer;
	
	public PaymentHandler() {
		//Needed for the static creation of a payment handler object in controller header.
	}
	
	/**
	 * Creates an instance representing a payment.
	 * @param amountPaid The amount paid by the customer.
	 * @param amountToPay The amount due by the customer.
	 */
	public PaymentHandler(int amountPaid, Cost amountToPay) {
		this.amountPaid = amountPaid;
		this.amountToPay = amountToPay;
	
	}
	
	private class CashPayment {
		private CashRegister cashRegister = new CashRegister();
		//Dummy implementation. The function always returns true.
		boolean performPayment() {//Test[T]
			cashRegister.updateBalance(amountToPay);
			return true;
		}
		
		CashRegister getCashRegister() {
			return this.cashRegister;
		}
	}
	
	private class CardPayment {
		private boolean paymentAuthorized;
		private Creditcard card;
		
		public CardPayment(CreditCardDTO CCDTO) {
			this.card = new Creditcard(CCDTO);
		}
		//Dummy implementation. The function always returns true. It is not set up to do any communication with any other class.
		boolean performPayment() {//Test[T]
			this.paymentAuthorized = true;
//			approved = PaymentAuthorization.authorizePayment(null, card.gettCVC());
			return this.paymentAuthorized;			
		}		
	}
	
	/**
	 * Sets up necessary data in order to perform a cash payment.
	 * @param amountPaid The amount paid by the customer
	 * @param amountToPay The amount due by the customer.
	 * @return The result of the payment.
	 */
	public boolean setUpCashPayment(int amountPaid, Cost amountToPay) {//Test[T]
		this.amountToPay = amountToPay;
		cashPayment = new CashPayment();
		makeReceipt();
		printReceipt();
		return cashPayment.performPayment();
	}
	
	/**
	 * Sets up necessary data in order to perform a card payment.
	 * @param CCDTO Data container with the necessary data in order to create a <code>CrediCard</code> object.
	 * @param amountToPay The amount due by the customer.
	 * @return The result of the payment.
	 */
	public boolean setUpCardPayment(CreditCardDTO CCDTO, Cost amountToPay) {//Test[T] 
		this.amountToPay = amountToPay;
		this.amountPaid = amountToPay.getCost();
		cardPayment = new CardPayment(CCDTO);
		makeReceipt();
		printReceipt();
		return cardPayment.performPayment();
	}
	
	private void printReceipt(){//Test[R]
		printer = new Printer();
		printer.printReceipt(this.receipt.toString());
	}
	
	private void makeReceipt() {//Test[R]
		receipt = new Receipt(this);
	}
	
	int getAmountDue(){
		return this.amountToPay.getCost();
	}
	
	int getAmountPaid() {
		return this.amountPaid;
	}	
	
	int getChange() {
		return amountPaid - amountToPay.getCost();
	}
}
