package se.kth.iv1350.inspectVehicle.integration;

/**
 * This class contains plenty of hard code and is purely meant to be mock-data that can be used by the program.
 *
 */
public class DBEntry {//Test[]
	private String	registerNumber;
	private int		openInspections;
	
	private DBInspection[] inspection = { new DBInspection("Brakes", 100), new DBInspection("Tires", 200), new DBInspection("Emission", 300) };

	
	public DBEntry(String registerNumber, int openInspections) {
		this.registerNumber = registerNumber;
		this.openInspections = openInspections;
	}
	
//	void inspectionMaker(){//Test[]
//		DBInspection[] inspection = { new DBInspection("Brakes", 100), new DBInspection("Tires", 200), new DBInspection("Emission", 300) };
//	}
	
	String getRegisterNumber() {//Test[R]
		return this.registerNumber;
	}
	
	int getOpenInspections() {
		return this.openInspections;
	}
	
	String getInspectionName(int index) {
		return this.inspection[index].getName();
	}
	
	int getPrice(int index) {
		return inspection[index].getPrice();
	}
	
}
