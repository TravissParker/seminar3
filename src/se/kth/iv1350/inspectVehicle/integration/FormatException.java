package se.kth.iv1350.inspectVehicle.integration;

/**
 * Indicates that the supplied register nunmber does not follow the expected format. 
 * Thrown when a CharacterException is caught. 
 *
 */
public class FormatException extends Exception{
	
	/**
	 * Creates an instance of the class.
	 * @param message Message with information about the exception.
	 * @param cause The causing exception.
	 */
	public FormatException(String message, Exception cause) {
		super(message, cause);
	}

}
