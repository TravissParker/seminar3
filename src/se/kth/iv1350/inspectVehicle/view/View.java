package se.kth.iv1350.inspectVehicle.view;
        
import java.io.IOException;
import java.util.Scanner;

import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.integration.FormatException;
import se.kth.iv1350.inspectVehicle.integration.NoInspectionException;
import se.kth.iv1350.inspectVehicle.integration.RegNumberNotFoundException;
import se.kth.iv1350.inspectVehicle.util.LogHandler;

/**
 * The view class is a placeholder for the entire view (the user interface). 
 *
 */
public class View {
	private Controller ctrl;
	private CreditCardDTO CCDTO;
	private ExceptionMessageHandler emh = new ExceptionMessageHandler();
	private LogHandler logHandler =  new LogHandler();
	private InspectionStatsView isv = new InspectionStatsView();
	
	/**
	 * Creates a new instance of the View class.
	 * @param ctrl The Controller that is used to perform all system operations.
	 */
	public View(Controller ctrl) throws IOException {
		this.ctrl = ctrl;
		
	}
	
	/**
	 * Using hard-coded operations to simulate user generate input to all system operations.
	 */
	public void sampleExecution() {
//		1 - startNewInspection
		System.out.println("[View>>] Inspector starts new inspection.\n");
		ctrl.startNewInspection();
		System.out.println("[View>>] Inspector closes the door.\n");
		ctrl.closeDoor();
		
//		2 - checkForInspection with InspectionManager
//		Correct number with inspections
		String regNumber = "ABC123";
		
//		Invokes WrongFormatException
//		String regNumber = "AAAA11";
		
//		Invokes RegNumberNotFoundException
//		String regNumber = "ZVC903";
		
//		Invokes NoInspectionException
//		String regNumber = "XYZ789";
		
		System.out.println("[View>>] Inspector checks register number " + regNumber + " for open inspections.\n");
		try{
			try {
				ctrl.checkForInspection(regNumber);
				
				//Send the InspectionStatsView reference towards the observer
				ctrl.registerObserver(isv);
			
				//Set what payment should be done
				Scanner input = new Scanner(System.in);
				System.out.println("\nHow would you like to pay for the inspection?\nCard: 1\nCash: 2");
				boolean whileLoop = true;
				while(whileLoop) {
					switch(input.nextInt()) {
					case 1:
						whileLoop = false;
						System.out.println("\n[View>>] Customer uses card to pay for inspection.");
						System.out.println("[View>>] The receipt is printed.");
				//		3 - payInspectionCard
						CCDTO = new CreditCardDTO(1234, "1234 5678", "C. Money", "17/09", 333);
						ctrl.payInspectionCard(CCDTO);
						break;
					case 2:
				//		4 - payInspectionCash 
						whileLoop = false;
						System.out.println("\n[View>>] Customer uses cash to pay for inspection.");
						System.out.println("[View>>] The receipt is printed.");
						int amountPaidCash = 1000;
						ctrl.payInspectionCash(amountPaidCash);
						break;
					
					default:
						System.out.println("Input '1' or '2' ");
					}
				}
				input.close();
				
				//5 - Fetch inspection 
				System.out.println("\n[View>>] The inspector fetches the open inspections.\n");
				System.out.println("[View>>] First open inspection");
				System.out.println(ctrl.fetchNextInspection());
				ctrl.recordResult(true, "Brakes are in good condition.");
		
				System.out.println("[View>>] Second open inspection");
				System.out.println(ctrl.fetchNextInspection());
				ctrl.recordResult(false, "Pattern on left front tier is too shallow.");
				
				System.out.println("[View>>] Third open inspection");
				System.out.println(ctrl.fetchNextInspection());
				ctrl.recordResult(false, "Unacceptable emission levels measured.");
				
				System.out.println(ctrl.fetchNextInspection());
				
			} catch(NoInspectionException e) {
				exceptionHandler("There was no open inspection found for this register number.", e);
				
			} catch(RegNumberNotFoundException e) {			
			exceptionHandler("The register number does not exist.", e);
				
			} catch(FormatException e) {
				exceptionHandler("The register number did not follow the right format.", e);
				
			}
			
		} catch (Exception e){
			exceptionHandler("AN EXCEPTION WAS THROWN", e);			
		}
		
	}
	
	private void exceptionHandler(String message, Exception e) {
		logHandler.logException(e);
		emh.showExceptionMessage(message);
		
	}
	
	
}
