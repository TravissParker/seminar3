package se.kth.iv1350.inspectVehicle.view;

/**
 * Keeps track of the number of passed, failed, and total inspections.
 */
public class InspectionStatsView implements Observer{
	
	private int passedInspections = 0;
	private int failedInspections = 0;
	private int totalInspections = 0;

	/* (non-Javadoc)
	 * @see se.kth.iv1350.inspectVehicle.view.Observer#updateStats(boolean)
	 */
	@Override
	public void updateStats(boolean result) {
		if(result) {
			passedInspections++;
		} else if(!result) {
			failedInspections++;
		}		
		totalInspections++;		
		
		displayStats();
	}
	
	private void displayStats() {
		StringBuilder sb = new StringBuilder();
		sb.append("#############################");
		sb.append("\nInspections performed: ");
		sb.append(totalInspections);
		
		sb.append("\nInpsections passed: ");
		sb.append(passedInspections);
		sb.append("\nInspections failed: ");
		sb.append(failedInspections);
		sb.append("\n#############################\n\n");
		
		System.out.println(sb);
	}

}
