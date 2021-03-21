package edu.fiu.sysdesign;

public class ControlStation {

	private Rover rover = new Rover();
	
	/**
	 * For now, the only command implemented is the self-check
	 */
	public void sendCommand() {
		System.out.println("Control Station reports we are starting a rover systems check!");
		boolean selfCheck = rover.runSelfCheckAllComponents();		
		if (selfCheck) {
			System.out.println("Control Station reports that all Rover components passed a systems check!!! Good job!!!");
		} else {
			System.out.println("WARNING: Control Station reports that some Rover components reported failures!!! Houston, we have a problem!!!");			
		}
	
	}
	
	public static void main(String[] args) {
		new ControlStation().sendCommand();
	}

}
