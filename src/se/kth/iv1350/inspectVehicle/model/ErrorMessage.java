package se.kth.iv1350.inspectVehicle.model;

class ErrorMessage {//Test[X]
	private String message;
	

	ErrorMessage(String message) {//Test[T]
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
