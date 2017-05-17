package se.kth.iv1350.inspectVehicle.integration;

/**
 * This class, and the connected classes DBEntry and DBInspection all contain some hard code to simulate a database. 
 * The  structure is Database<DBEntry<DBInspection. Read < as "contains".
 *
 */
public class Database {//Test[]
	private DBEntry[] entries = { new DBEntry("ABC123", 3), new DBEntry("XYZ789", 0) };
	public static boolean databaseUpdated = false;
	
	boolean searchRegNumber(String regNumber) throws EntryNotFoundException { //Test[R]
		boolean regNumberFound = false;
	
			regNumberFound = traversDatabase(regNumber);
			
			if(!regNumberFound){
				throw new EntryNotFoundException("The specified entry [" + regNumber + "] was not found in the database.");
			}

		return regNumberFound;	
	}
	
	private boolean traversDatabase(String regNumber) {
		boolean regNumberFound = false;
		for(DBEntry entry : entries) {
			if(regNumber.equals(entry.getRegisterNumber())) {
				regNumberFound =  true;
				break;
			}
		}
		return regNumberFound; 
	}
	
	
	int numberOfOpenInspections(int index) throws NoInspectionException  {
		int openInspections = entries[index].getOpenInspections();
		
		if(openInspections < 1) {
			throw new NoInspectionException("");
		}
		return openInspections;
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
		databaseUpdated = true;
	}
}
