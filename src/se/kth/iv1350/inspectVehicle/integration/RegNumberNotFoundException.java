package se.kth.iv1350.inspectVehicle.integration;

/**
 * Indicates that the sought after register number was not found, and by extension doesn't exist.
 * Is thrown when EntryNotFoundException is caught. 
 *
 */
public class RegNumberNotFoundException extends Exception {
	
	/**
	 * Creates an instance of the class.
	 * @param message Message with information about the exception.
	 * @param cause The causing exception.
	 */
	public RegNumberNotFoundException(String message, Exception cause) {
		super(message, cause);
	}

}
