package se.kth.iv1350.inspectVehicle.integration;

/**
 * A data container that contains all information needed to create a <code>Creditcard</code> object.
 *
 */
public class CreditCardDTO {
	private final int pin;
	private final String number;
	private final String holder;
	private final String expiryDate;
	private final int CVC;
	
	/**
	 * Creates a new instance from primitive data. Data is user generated input that is sent straight from view. 
	 * @param pin The card's pin code.
	 * @param number The card's card number.
	 * @param holder The card's holder.
	 * @param expiryDate The card's expiration date.
	 * @param CVC The card's CVC number.
	 */
	public CreditCardDTO(int pin, String number, String holder, String expiryDate, int CVC) {
		this.pin = pin;
		this.number = number;
		this.holder = holder;
		this.expiryDate = expiryDate;
		this.CVC = CVC;
	}
	
	int getPin() {
		return this.pin;
	}
	
	String getNumber() {
		return this.number;
	}
	
	String getHolder() {
		return this.holder;
	}
	
	String getExpiryDate() {
		return this.expiryDate;
	}
	
	int getCVC() {
		return this.CVC;
	}
}
