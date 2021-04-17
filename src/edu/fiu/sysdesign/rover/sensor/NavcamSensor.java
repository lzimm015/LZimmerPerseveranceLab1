package edu.fiu.sysdesign.rover.sensor;

public class NavcamSensor implements Sensor {

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}

	@Override
	public String getComponentName() {
		return "NavcamSensor";
	}

	@Override
	public void receiveSignal() {
		
	}

}
