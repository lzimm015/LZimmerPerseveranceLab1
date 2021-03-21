package edu.fiu.sysdesign.rover.sensor;

public class CollisionSensor implements Sensor {

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}

	@Override
	public String getComponentName() {
		return "CollisionSensor";
	}

	@Override
	public void receiveSignal() {
		
	}

}
