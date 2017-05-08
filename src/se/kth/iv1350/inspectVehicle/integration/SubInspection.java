package se.kth.iv1350.inspectVehicle.integration;

/**
 * This class makes up a single open inspection. A vehicle can have several open inspections.
 *
 */
public class SubInspection {//Test[X]
	private String	typeofInspection;
	private int		price;
	private boolean	result;
	private String	remark = "NO REMARK";
	
	/**
	 * Creates an instance representing a specific inspection.
	 * @param typeofInspection The type/name of the inspection.
	 * @param price Price to pay for the inspection.
	 */
	public SubInspection(String typeofInspection, int price) {
		this.typeofInspection = typeofInspection;
		this.price = price;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {//Test[T]
		String s = "Inspection: " + typeofInspection + "\nInspection Result: " + result + "\nRemark: " + remark;
		return s;
	}

	
	/**
	 * Records the result of the inspection.
	 * @param result Either pass or fail (<code>true</code> or <code>false</code>).
	 * @param remark A comment (not mandatory) supplied by the user.
	 */
	public void recordResults(boolean result, String remark) {//Test[]
		setResult(result);
		setRemark(remark);
	}
		
	private void setResult(boolean result) {//Test[T]
		this.result = result;
	}

	@SuppressWarnings("unused")
	private boolean getResult() {//Test[T]
		return this.result;
	}
	
	private void setRemark(String remark) {//Test[T]
		this.remark = remark;
	}
	
	@SuppressWarnings("unused")
	private String getRemark() {//Test[T]
		return this.remark;
	}
	
	/**
	 * Declared public due to being located in different package than Inspection class.
	 * @return The price of the given inspection.
	 */
	public int getPrice() {//Test[T]
		return this.price;
	}
}
