package edu.fiu.sysdesign.rover;

public class PowerSource implements Component {

	private int batteryLeft;

	@Override
	public String getComponentName() {
		return "PowerSource";
	}

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}
	
}
