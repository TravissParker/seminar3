package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;
import se.kth.iv1350.inspectVehicle.view.Observer;


/**
 * The observed class in the implemented observer pattern. In charge of holding all observers of type <code>Observer</code> in an <code>ArrayList</code>. 
 * Manages the list with methods to register, unregister and notifying observers.
 *
 */
public class ResultObserver {
	
	private ArrayList<Observer> observers;
	
	/**
	 * Creates a new instance of the class and initilizes the <code>observers</code>
	 */
	public ResultObserver() {
		observers = new ArrayList<Observer>();
	}
	
	/**
	 * Adds a new observer to the list.
	 * @param newObserver The new observer that is added to the list.
	 */
	public void registerObserver(Observer newObserver) {
		observers.add(newObserver);
	}
	
	/**
	 * Removes an observer from the list. 
	 * @param oldObserver The observer removed from the list.
	 */
	public void unregisterObserver(Observer oldObserver) {
		int indexToRemove = observers.indexOf(oldObserver);
		observers.remove(indexToRemove);
	}
	
	/**
	 * Notifies all observers in the list. 
	 * @param result The data sent to the observers.
	 */
	public void notifyObserver(boolean result) {
		for(Observer o : observers) {
			o.updateStats(result);
		}
	}

}
