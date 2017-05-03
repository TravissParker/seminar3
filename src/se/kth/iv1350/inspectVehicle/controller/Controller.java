package se.kth.iv1350.inspectVehicle.controller;

import se.kth.iv1350.garage.Garage;
import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.Cost;
import se.kth.iv1350.inspectVehicle.model.InspectionManager;
import se.kth.iv1350.inspectVehicle.model.PaymentHandler;

/**
 * The only Controller class of the program, all calls to model passes through this instance. 
 *
 */
public class Controller {//Test[]
	private Garage garage = new Garage();
	private InspectionManager inspectionManager = new InspectionManager();
	private PaymentHandler paymentHandler = new PaymentHandler();//Create it here for now instead of having cash and card each create it.
	
	/**
	 * Initiates a new inspection, with a new customer.
	 */
	public void startNewInspection() {//Test[M]	Unsure how to test this one.
		garage.nextCustomer();				
	}
	
	/**
	 * Changes the sate of the door to closed. 
	 */
	public void closeDoor() {//Test[M] Unsure how to test this one.
		garage.closeDoor();			
	}
	
	/**
	 * Check if the current vehicle has any open inspections. Only vehicles with open inspection may be inspected. 
	 * If inspections exists the cost will be printed to the standard output, else an error message will be printed
	 * to the standard output.
	 * @param regNumber Identifies the current vehicle and has (potentially) open inspections connected to itself. 
	 */
	public void checkForInspection(String regNumber) {//Test[T]
		inspectionManager.isRegNumberValid(regNumber);
	}
	
	/**
	 * Performs payment for inspection with credit card and updates the payment status.
	 * @param CCDTO Data container with all data needed to create a <code>Creditcard</code> Object.
	 */
	public void payInspectionCard(CreditCardDTO CCDTO) {//Test[T]
		boolean approved = paymentHandler.setUpCardPayment(CCDTO, getInspectionCost());
		setInspectionPaid(approved);		
	}
	
	/**
	 * Performs payment for inspection with cash and updates the payment status.
	 * @param amountPaid The amount paid by the customer.
	 */
	public void payInspectionCash(int amountPaid) {//Test[T]
		boolean approved = paymentHandler.setUpCashPayment(amountPaid, getInspectionCost());
		setInspectionPaid(approved);
	}
	
	private Cost getInspectionCost(){
		return inspectionManager.getCostObj();
	}
	
	private void setInspectionPaid(boolean approved) {
		inspectionManager.setInspectionPaid(approved);
	}

	//Used for testing payInspectionCard - should be removed. But how do we then test the pay things?
	boolean getPaymentStatus() {
		return this.inspectionManager.getInspectionPaid();
	}
	
	/**
	 * Fetch the next inspection.
	 */
	public void fetchNextInspection() {//Test[]
		inspectionManager.fetchNextInspection();
	}
		
	/**
	 * Records the sub inspection result to the current inspection.
	 * @param result The result of the inspection.
	 * @param remark User generated comment. 
	 */
	public void recordResult(boolean result, String remark) {//Test[]
		inspectionManager.recordResult(result, remark);
	}
}
