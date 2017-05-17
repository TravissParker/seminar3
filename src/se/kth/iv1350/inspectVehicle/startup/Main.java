package se.kth.iv1350.inspectVehicle.startup;

import java.io.IOException;

import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.view.View;

/**
 * Contains the <code>main</code> method which performs initial startup of the application.
 *
 */
public class Main {

	/**
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {//Test[]		
		Controller ctrl = new Controller();
		try {
			View view = new View(ctrl);
			view.sampleExecution();
		} catch(IOException e) {
			System.out.println("An IOException was thrown: " + e.getMessage());
		}
	}
}