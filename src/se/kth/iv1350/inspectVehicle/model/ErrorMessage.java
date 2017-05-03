package se.kth.iv1350.inspectVehicle.model;

/**
 * This class encapsulates the eventual error message generated if the supplied register number cannot be found in the database.
 */
public class ErrorMessage {//Test[X]
	private String message;
	
	/**
	 * Creates an instance of an error message.
	 * @param message The message that constitutes the error message.
	 */
	public ErrorMessage(String message) {//Test[T]
		this.message = message;
	}
	
	String getMessage() {//Test[T]
		return this.message;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {//Test[T]
		String s = "Error message: " + this.message;
		return s;
	}
}
