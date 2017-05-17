package se.kth.iv1350.inspectVehicle.integration;

/**
 * Thrown when a wrong type of character, such as an digit, is found at an index that according to a set format should contain a letter, and vice versa. 
 * The exception includes information on what type of character was expected and what type of character was found at which index. 
 *
 */
public class CharacterException extends Exception {
	
	/**
	 * Creates an instance of the class.
	 * @param message Message with information about the exception.
	 */
	public CharacterException(String message) {
		super(message);
	}

}
