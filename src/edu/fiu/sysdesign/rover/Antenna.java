package edu.fiu.sysdesign.rover;

public class Antenna implements Component {

	public void receiveSignal() {
		
	}

	@Override
	public String getComponentName() {
		return "Antenna";
	}

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}
	
}
