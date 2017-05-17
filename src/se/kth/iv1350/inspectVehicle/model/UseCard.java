package se.kth.iv1350.inspectVehicle.model;

import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.integration.Creditcard;

/**
 * Holds the necessary references to perform a card payment. 
 *
 */
public class UseCard implements PaymentMode {
	
	private Creditcard card;
	
	/**
	 * Creates an instance of <code>UseCard</code>
	 * @param card The card information supplied by the user in the UI.
	 */
	public UseCard(CreditCardDTO card) {
		this.card = new Creditcard(card);
		
	}

	/* (non-Javadoc)
	 * @see se.kth.iv1350.inspectVehicle.model.PaymentMode#pay(se.kth.iv1350.inspectVehicle.model.Cost)
	 */
	@Override
	public boolean pay(Cost amountToPay) {
//		Send card to external payment system, which would return true or false.
		return true;
		
	}


}
