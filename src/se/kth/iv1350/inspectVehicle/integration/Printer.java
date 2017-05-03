package se.kth.iv1350.inspectVehicle.integration;

/**
 * Used to print receipt and inspection result. 
 */
public class Printer {//Test[X]
	
	/**
	 * Prints the receipt to the standard output unit. 
	 * @param receipt The <code>Receipt</code> object. 
	 */
	public void printReceipt(String receipt) {//Test[T]
		System.out.println(formater(receipt));
	}
	
	/**
	 * Prints the result of the inspection to the standard output unit.
	 * @param result A <code>String</code> representing the result of the inspeciton.
	 */
	public void printResult(String result) {//Test[T]
		System.out.println(formater(result));
	}
	
	private String formater(String result) {
		StringBuilder sb = new StringBuilder(result);
		String appendix = "\n================================================\n";
		sb.insert(0, appendix);
		sb.append(appendix);
		
		return sb.toString();
	}
}
