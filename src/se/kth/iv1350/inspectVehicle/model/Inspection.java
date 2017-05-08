package se.kth.iv1350.inspectVehicle.model;

import se.kth.iv1350.inspectVehicle.integration.SubInspection;

 class Inspection {//Test[X]
	private String regNumber;
	private SubInspection[] subInspection;
	private Cost inspectionCost;
	private boolean inspectionPaid = false;
	private int index = 0;
	
	 Inspection(String regNumber, SubInspection[] subInspection) {
		this.regNumber = regNumber;
		this.subInspection = subInspection;
		int amount = summarizePrices();
		inspectionCost = new Cost(amount);
	}
	
	private int summarizePrices() {//Test[T]
		int sum = 0;
		for(int i = 0; i  < subInspection.length; i++) {
			sum += subInspection[i].getPrice();
		}
		return sum;
	}
	
	Cost getCostObj() {//Test[T]
		Cost costObject = new Cost(this.inspectionCost);
		return costObject;
	}
	void setInspectionPaid(boolean state) {//Test[T]
		this.inspectionPaid = state;
	}
	
	boolean getInspectionPaid() {//Test[T]
		return this.inspectionPaid;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {//Test[T]
		String s = "Inspection result for register number: " + this.regNumber + "\n\n";
		for(SubInspection sub : this.subInspection) {
			s = s + sub.toString() + "\n\n";
		}
		return s;
	}
	
	void displayNextInspection() {//Test[T]	
		System.out.println(subInspection[index].toString() + "\n");
	}
	
	void recordResult(boolean result, String remark) {
		subInspection[index++].recordResults(result, remark);	
	}
	
	int getIndex() {
		return this.index;
	}
	
	int getNumberOfInspections() {
		return this.subInspection.length;
	}
	
	String getRegNumber() {
		return this.regNumber;
	}
	
	SubInspection[] getSubInspections() {
		return this.subInspection;
	}
}
