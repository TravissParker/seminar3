package se.kth.iv1350.inspectVehicle.view;

/**
 * Declares the updateStats method used by implementing classes to keep track of number of inspections.
 *
 */
public interface Observer {
	
	void updateStats(boolean result);

}
