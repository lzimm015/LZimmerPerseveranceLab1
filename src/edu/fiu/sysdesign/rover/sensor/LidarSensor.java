package edu.fiu.sysdesign.rover.sensor;

public class LidarSensor implements Sensor {

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}

	@Override
	public String getComponentName() {
		return "LidarSensor";
	}

	@Override
	public void receiveSignal() {
		
	} 

}
