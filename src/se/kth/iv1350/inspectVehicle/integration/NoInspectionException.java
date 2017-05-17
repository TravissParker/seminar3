package se.kth.iv1350.inspectVehicle.integration;

/**
 * Indicates that there are no open inspections to an existing register number. 
 *
 */
public class NoInspectionException extends Exception {
	
	/**
	 * Creates an instance of the class.
	 * @param message Message with information about the exception.
	 */
	public NoInspectionException(String message) {
		super(message);
	}
	
}
