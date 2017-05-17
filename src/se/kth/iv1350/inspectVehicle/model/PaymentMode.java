package se.kth.iv1350.inspectVehicle.model;

/**
 * Gives capability to perform a payment to each class that implements the interface.
 *
 */
public interface PaymentMode {

	boolean pay(Cost amountToPay);

}
