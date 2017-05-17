package se.kth.iv1350.inspectVehicle.view;

/**
 * Formats exception messages and prints these to the standard output unit.
 *
 */
public class ExceptionMessageHandler {
	String standardMessage = "[ERROR>>>] An exception was thrown which disrupted the normal workflow, "
			+ "please restart the application. \n[SPECIFIED MESSAGE>>>] ";
	
	void showExceptionMessage(String message) {
		StringBuilder sb = new StringBuilder();
		sb.append(standardMessage);
		sb.append(message);
		System.out.println(sb);
	}
}
