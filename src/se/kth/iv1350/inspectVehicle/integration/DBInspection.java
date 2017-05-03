package se.kth.iv1350.inspectVehicle.integration;

@SuppressWarnings(value = "unused")
public class DBInspection {//Test[]//There are just getters here, no testing needed.
	private String	inspectionName;
	private String	inspectionRemark;
	private boolean	result;
	private int		inpsectionPrice;
	
	public DBInspection(String name, int price){
		inspectionName = name;
		inpsectionPrice = price;
	}
	
	void setResult(boolean result) {
		this.result = result;
	}
	
	void setRemark(String remark) { 
		this.inspectionRemark = remark;
	}
	
	String getName() {
		return this.inspectionName;
	}
	
	int getPrice() { 
		return this.inpsectionPrice;
	}
	
}
