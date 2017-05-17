package se.kth.iv1350.inspectVehicle.integration;

/**
 * Indicates that an sought after entry was not found in the database, and by extension doesn't exist in the database.
 * The exception includes which entry was sought after. 
 *
 */
public class EntryNotFoundException extends Exception{
	
	/**
	 * Creates an instance of the class.
	 * @param message Message with information about the exception.
	 */
	public EntryNotFoundException(String message) {
		super(message);
	}

}
