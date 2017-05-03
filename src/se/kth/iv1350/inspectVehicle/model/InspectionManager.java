package se.kth.iv1350.inspectVehicle.model;

import se.kth.iv1350.inspectVehicle.integration.DBCaller;
import se.kth.iv1350.inspectVehicle.integration.Printer;
import se.kth.iv1350.inspectVehicle.integration.SubInspection;

/**
 * Connects the database caller with the creation of the actual inspection object. Also handles relay of information back to controller, view. 
 *
 */
public class InspectionManager {//Test[X]
	private Inspection currentInspection;
	private SubInspection[] subInspection;
	private DBCaller dbCaller 	= new DBCaller();
	private ErrorMessage errorMsg;
	private Printer printer;
	
	/**
	 * Checks if the register number supplied exists in the database. The outcome of this method determine the state of the InspectionManager objects, cost and errorMsg, and prints to the standard output unit the result of
	 * the relevant information.
	 * @param regNumber The register number belonging to the current vehicle. Inspections are connected to the register number.
	 */
	public boolean isRegNumberValid(String regNumber) {//Test[T]
		boolean regNumberValid = dbCaller.regNumberValid(regNumber);
		if(regNumberValid) {
			createInspection(regNumber);
			printCost();
//			System.out.println(this.currentInspection.getCostObj());
			return regNumberValid;
		} else {
			setErrorMsg();
			printErrorMsg();
//			System.out.println(this.errorMsg);
			return regNumberValid;
		}
	}
	
	void createInspection(String regNumber) {//Test[T]
		subInspection = dbCaller.createSubInspectionArray(regNumber);
		currentInspection = new Inspection(regNumber, subInspection);
	}
	
	private void printCost() {
		System.out.println(this.currentInspection.getCostObj());
	}
	
	private void setErrorMsg() {
		errorMsg = new ErrorMessage("Register number could not be found, please try again.");
	}
	
	private void printErrorMsg() {
		System.out.println(this.errorMsg);
	}
			
	Inspection getCurrentInspection() {//Test[T]
		return this.currentInspection;
	}
	//This is only used for testing.
	String getErrorMsg() {//Test[T]
		return this.errorMsg.toString();
	}
	
	/**
	 * Gets the <code>Cost</code>-object, the cost of the inspection, to the caller.
	 * @return The <code>Cost</code>-object
	 */
	public Cost getCostObj() {//Test[T]
		return this.currentInspection.getCostObj();
	}
	
	/**
	 * Sets the state of payment to paid or unpaid (<code>true</code> or <code>false</code>).
	 * @param state The new state of the payment.
	 */
	public void setInspectionPaid(boolean state) {//Test[T] 
		this.currentInspection.setInspectionPaid(state);
	}
	
	/**
	 * Gets the state of the payment.
	 * @return The state of the payment.
	 */
	public boolean getInspectionPaid() {//Test[T]
		return this.currentInspection.getInspectionPaid();
	}
		
	public void fetchNextInspection(){
		if(finalInspectionPerformed()) {
			System.out.println("No more inspections available for this vehicle.\n");
			updateDatabase();
			printInspectionResult();
		} else {
			currentInspection.displayNextInspection();
		}
	}
	
	/**
	 * Records the result of an inspection as specified by the user. 
	 * @param result The result of the inspection, pass or fail (<code>true</code> or <code>false</code>).
	 * @param remark User generated comment.
	 */
	public void recordResult(boolean result, String remark) {//Test[]
		currentInspection.recordResult(result, remark);
	}
	
	private boolean finalInspectionPerformed(){
		return currentInspection.getIndex() == currentInspection.getNumberOfInspections();
	}
	
	private void updateDatabase() {//Test[T]
		dbCaller.submitResults(currentInspection.getRegNumber(), currentInspection.getSubInspections());		
	}

	private void printInspectionResult(){//Test[]
		printer = new Printer();
		printer.printResult(currentInspection.toString());
	}
}

