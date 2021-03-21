package edu.fiu.sysdesign.rover;

public class Engine implements Component {

	private int processingPower;
	
	public void setPower(int processingPower) {
		
	}

	@Override
	public String getComponentName() {
		return "Engine";
	}

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}
	
}
