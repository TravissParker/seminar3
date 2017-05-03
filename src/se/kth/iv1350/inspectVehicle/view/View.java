package se.kth.iv1350.inspectVehicle.view;
        
import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.integration.CreditCardDTO;

/**
 * The view class is a placeholder for the entire view (the user interface). 
 *
 */
public class View {
	private Controller ctrl;
	private CreditCardDTO CCDTO;
	
	/**
	 * Creates a new instance of the View class.
	 * @param ctrl The Controller that is used to perform all system operations.
	 */
	public View(Controller ctrl) {
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
		String regNumber = "ABC123";
		System.out.println("[View>>] Inspector checks register number " + regNumber + " for open inspections.\n");
		ctrl.checkForInspection(regNumber);
		
		//Set what payment should be done
		System.out.println("\n[View>>] Customer uses card to pay for inspection.");
		System.out.println("[View>>] The receipt is printed.");
		boolean card = true;
		if(card) {
	//		3 - payInspectionCard
			CCDTO = new CreditCardDTO(1234, "1234 5678", "C. Money", "17/09", 333);
			ctrl.payInspectionCard(CCDTO);
		} else {
	//		4 - payInspectionCash - Not fully implemented. 
			int amountPaidCash = 1000;
			ctrl.payInspectionCash(amountPaidCash);
		}
		//5 - Fetch inspection
		//Hard coded to perform this 3 times (3 hard coded open inspections exist).
		System.out.println("\n[View>>] The inspector fetches the open inspections.\n");
		System.out.println("[View>>] First open inspection");
		ctrl.fetchNextInspection();
		ctrl.recordResult(true, "Brakes are in good condition.");

		System.out.println("[View>>] Second open inspection");
		ctrl.fetchNextInspection();
		ctrl.recordResult(false, "Pattern on left front tier is too shallow.");
		
		System.out.println("[View>>] Third open inspection");
		ctrl.fetchNextInspection();
		ctrl.recordResult(false, "Unacceptable emission levels measured.");
		
		ctrl.fetchNextInspection();
		
	}
	
	
}
