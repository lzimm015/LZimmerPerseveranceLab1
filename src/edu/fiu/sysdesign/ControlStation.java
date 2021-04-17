package edu.fiu.sysdesign;

import edu.fiu.sysdesign.util.Direction;

public class ControlStation {

	private Rover rover;
	
	
	
	public ControlStation() {
		this.rover = new Rover();
		rover.setControlStation(this);
	}

	public void systemsCheck() {		
		System.out.println("Control Station reports we are starting a rover systems check!");
		boolean selfCheck = rover.runSelfCheckAllComponents();		
		if (selfCheck) {
			System.out.println("Control Station reports that all Rover components passed a systems check!!! Good job!!!");
		} else {
			System.out.println("WARNING: Control Station reports that some Rover components reported failures!!! Houston, we have a problem!!!");			
		}
	}
	
	public void activateRover() {
		System.out.println("1 activating rover");
		rover.activate();
	}
	
	public void sendCommandToMove(Direction direction) {
		System.out.printf("2 starting to move in direction %s\n", direction);
		rover.moveDirection(direction);
	}
	
	public void notifyRoverArrivalToDestination() {
		System.out.println("2.6 Rover notified it arrived, ending sequence");
	}
	
	/**
	 * Implementing the basic flow of the sequence diagram
	 */
	public static void main(String[] args) {
		ControlStation controlStation = new ControlStation();
		controlStation.activateRover();
		controlStation.sendCommandToMove(Direction.NORTH);
	}

}
