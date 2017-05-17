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
	 * @throws RegNumberNotFoundException Indicates that the supplied register number was not found. 
	 * @throws FormatException Indicates that there was a inconsistency with the format of the register number. 
	 */
	public boolean regNumberValid(String regNumber)  throws RegNumberNotFoundException, FormatException{//Test[T]
		boolean regNumberValidity = false;
		try {
				checkFormat(regNumber);	
				regNumberValidity = database.searchRegNumber(regNumber);
				return regNumberValidity;
				
			} catch (CharacterException e) {
				throw new FormatException("Register number had wrong format.", e);
				
			} catch (EntryNotFoundException e) {
				throw new RegNumberNotFoundException("Register Number was not found.", e);
			}			
	}
	
	private void checkFormat(String regNumber) throws CharacterException {
		for(int i = 0; i < 3; i++) {
			if(!Character.isLetter(regNumber.charAt(i))){
				throw new CharacterException("The supplied register number contained unexpected characther(digit): [" 
											+ regNumber.charAt(i) + "] at index: [" + i + "]");
			}
		}
		for(int i = 3; i < 6; i++) {
			if(!Character.isDigit(regNumber.charAt(i))){
				throw new CharacterException("The supplied register number contained unexpected characther(letter): [" 
											+ regNumber.charAt(i) + "] at index: [" + i + "]");
			}
		}
	}
	
	/**
	 * The method creates an <code>SubInspection</code> array from primitive data copied from the database.
	 * @param regNumber Used to identify what sub inspections are to be copied.
	 * @return The <code>SubInspection</code> array.
	 * @throws NoInspectionException Indicates that there are no open inspections for the register number.
	 */
	public SubInspection[] createSubInspectionArray(String regNumber) throws NoInspectionException{//Test[T]
		int index = database.getIndex(regNumber);
		try {
			int arrayLength = database.numberOfOpenInspections(index);
			SubInspection[] subInspection = new SubInspection[arrayLength];
			
			for(int i = 0; i < subInspection.length; i++) {
				String 	typeOfInspection = database.getInspectionName(index, i);
				int		price = database.getPrice(index, i);
				subInspection[i] = new SubInspection(typeOfInspection, price);
			}
			return subInspection;
			
		} catch(NoInspectionException e) {
			throw new NoInspectionException("There are no open inspections for this register number.");
		}
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
