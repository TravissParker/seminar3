package se.kth.iv1350.inspectVehicle.controller;

import se.kth.iv1350.garage.Garage;
import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.integration.FormatException;
import se.kth.iv1350.inspectVehicle.integration.NoInspectionException;
import se.kth.iv1350.inspectVehicle.integration.RegNumberNotFoundException;
import se.kth.iv1350.inspectVehicle.model.Cost;
import se.kth.iv1350.inspectVehicle.model.InspectionManager;
import se.kth.iv1350.inspectVehicle.model.Payment;
import se.kth.iv1350.inspectVehicle.model.ResultObserver;
import se.kth.iv1350.inspectVehicle.view.Observer;

/**
 * The only Controller class of the program, all calls to model passes through this instance. 
 *
 */
public class Controller {//Test[]
	private Garage garage = new Garage();
	private InspectionManager inspectionManager = new InspectionManager();
	private ResultObserver resultObserver = new ResultObserver();
	private Payment payment;
	
	/**
	 * Register a observer to the <code>ResultObserver</code> class.
	 * @param isv A class that implements the <code>Observer</code> interface.
	 */
	public void registerObserver(Observer isv) {
		resultObserver.registerObserver(isv);
	}
	
	/**
	 * Initiates a new inspection, with a new customer.
	 */
	public void startNewInspection() {
		garage.nextCustomer();				
	}
	
	/**
	 * Changes the sate of the door to closed. 
	 */
	public void closeDoor() {
		garage.closeDoor();			
	}
	
	/**
	 * Check if the current vehicle has any open inspections. Only vehicles with open inspection may be inspected. 
	 * If inspections exists the cost will be printed to the standard output, else an error message will be printed
	 * to the standard output.
	 * @param regNumber Identifies the current vehicle and has (potentially) open inspections connected to itself. 
	 * @throws NoInspectionException 
	 */
	public void checkForInspection(String regNumber) throws RegNumberNotFoundException, FormatException, NoInspectionException {//Test[T]
		inspectionManager.isRegNumberValid(regNumber);
	}
	
	/**
	 * Performs payment for inspection with credit card and updates the payment status.
	 * @param CCDTO Data container with all data needed to create a <code>Creditcard</code> Object.
	 */
	public void payInspectionCard(CreditCardDTO CCDTO) {//Test[T]
		payment = new Payment(CCDTO);
		boolean approved = payment.performPayment(getInspectionCost());
		setInspectionPaid(approved);		
	}
	
	/**
	 * Performs payment for inspection with cash and updates the payment status.
	 * @param amountPaid The amount paid by the customer.
	 */
	public void payInspectionCash(int amountPaid) {//Test[T]
		payment = new Payment(amountPaid);
		boolean approved = payment.performPayment(getInspectionCost());
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
	 * @return The string that is printed in View.
	 */
	public String fetchNextInspection() {//Test[T]
		return inspectionManager.fetchNextInspection();
	}
		
	/**
	 * Records the sub inspection result to the current inspection, and passes the sub inspection result to the <code>ResultObserver</code>
	 * @param result The result of the inspection.
	 * @param remark User generated comment. 
	 */
	public void recordResult(boolean result, String remark) {//Test[]
		inspectionManager.recordResult(result, remark);
		resultObserver.notifyObserver(result);
	}
}
