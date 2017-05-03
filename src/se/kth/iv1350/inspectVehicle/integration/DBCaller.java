package se.kth.iv1350.inspectVehicle.integration;

/**
 * In charge of communicating with the database. 
 *
 */
public class DBCaller {
	private Database database = new Database();
	
	/**
	 * Calls the database to search for the supplied register number. 
	 * @param regNumber the register number that the database wills search for.
	 * @return <code>true</code> if the register number exists, else <code>false</code>.
	 */
	public boolean regNumberValid(String regNumber) {//Test[T]
		boolean regNumberValidity = database.searchRegNumber(regNumber);		
		return regNumberValidity; 
	}
	
	/**
	 * The method creates an <code>SubInspection</code> array from primitive data copied from the database.
	 * @param regNumber Used to identify what sub inspections are to be copied.
	 * @return The <code>SubInspection</code> array.
	 */
	public SubInspection[] createSubInspectionArray(String regNumber) {//Test[T]
		int index = database.getIndex(regNumber);
		int arrayLength = database.numberOfOpenInspections(index);
		SubInspection[] subInspection = new SubInspection[arrayLength];
		
		for(int i = 0; i < subInspection.length; i++) {
			String 	typeOfInspection = database.getInspectionName(index, i);
			int		price = database.getPrice(index, i);
			subInspection[i] = new SubInspection(typeOfInspection, price);
		}		
		return subInspection;
	}	
	
	/**
	 * Submits the result of the inspection to the database.
	 * @param regNumber Identifies which subset of inspections that are to be updated.
	 * @param subInspection Contains the new information.
	 */
	public void submitResults(String regNumber, SubInspection[] subInspection) {//Test[T]
		database.updateEntry(regNumber, subInspection);
	}
}
