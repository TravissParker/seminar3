package se.kth.iv1350.inspectVehicle.integration;

/**
 * This class, and the connected classes DBEntry and DBInspection all contain some hard code to simulate a database. 
 * The  structure is Database<DBEntry<DBInspection. Read < as "contains".
 *
 */
public class Database {//Test[]
	private DBEntry[] entries = { new DBEntry("ABC123", 3), new DBEntry("XYZ789", 3) };
	
	boolean searchRegNumber(String regNumber) { //Test[R]
		boolean regNumberFound = false;
		for(int i = 0; i < entries.length; i++) {
			if(regNumber.equals(entries[i].getRegisterNumber())) {
					regNumberFound = true;
					break;
			}
		}
		return regNumberFound;	
	}
	
	int numberOfOpenInspections(int index) {
		return entries[index].getOpenInspections();
	}
	
	String getInspectionName(int entryIndex, int inspectionIndex) {
		String inspectionName = entries[entryIndex].getInspectionName(inspectionIndex);
		
		return inspectionName;
	}
	
	int getPrice(int entryIndex, int inspectionIndex) {
		int price = entries[entryIndex].getPrice(inspectionIndex);
		return price;
	}
	
	int getIndex(String regNumber) {//Tested[T]
		int index = -1;
		for(int i = 0; i < entries.length; i++) {
			if(regNumber.equals(entries[i].getRegisterNumber())) {
				index = i;
				break;
			}
		}
		return index;	
	}
	
	public void updateEntry(String regNumber, SubInspection[] subInsepction) {
		
	}
}
