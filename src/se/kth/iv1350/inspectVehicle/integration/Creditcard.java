package se.kth.iv1350.inspectVehicle.integration;

/**
 * Represents a credit card.
 *
 */
@SuppressWarnings(value = "unused")
public class Creditcard {
	private int pin;
	private String number;
	private String holder;
	private String expiryDate;
	private int CVC;
	
 	/**
 	 * Creates a new instance. 
 	 * @param CCDTO Data container with all data needed to create a <code>Creditcard</code> Object.
 	 */
 	public Creditcard(CreditCardDTO CCDTO) {
 		 this.pin = CCDTO.getPin();
 		 this.number= CCDTO.getNumber();
 		 this.holder= CCDTO.getHolder();
 		 this.expiryDate = CCDTO.getExpiryDate();
 		 this.CVC = CCDTO.getCVC();
 	}
}
