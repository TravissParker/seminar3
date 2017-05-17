package se.kth.iv1350.inspectVehicle.model;

/**
 * Holds the necessary references to perform a cash payment. 
 *
 */
public class UseCash implements PaymentMode {
	private int amountPaid;
	private CashRegister cashRegister;


	/**
//	 * Creates an instance of <code>UseCash</code> and gets reference for <code>cashRegister</code>.
	 * @param amountPaid
	 */
	public UseCash(int amountPaid) {
		this.amountPaid = amountPaid;
		cashRegister = CashRegister.getCashRegister();
	}

	/* (non-Javadoc)
	 * @see se.kth.iv1350.inspectVehicle.model.PaymentMode#pay(se.kth.iv1350.inspectVehicle.model.Cost)
	 */
	@Override
	public boolean pay(Cost amountToPay) {
		cashRegister.updateBalance(amountToPay);
		return true;
		
	}
	
	

}
