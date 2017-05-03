package se.kth.iv1350.inspectVehicle.model;

/**
 * This class encapsulates the cost of the entire inspection.
 */
public class Cost {//Test[X] 
	private int amount;
	
	/**
	 * Creates a new instance based on an int value.
	 * @param amount The total cost of the inspection.
	 */
	public Cost(int amount) {//Test[T] 
		this.amount = amount;
	}
	
	 /**
	  * Creates a new instance based on another <code>Cost</cost> object.
	 * @param cosThe total cost of the inspection.
	 */
	public Cost(Cost cos){//Test[T] 
		this.amount = cos.getCost();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {//Test[T] 
		String s = "Total cost: " + this.amount;
		return s;
	}
	
	int getCost() {//Test[T] 
		return this.amount;
	}

}
