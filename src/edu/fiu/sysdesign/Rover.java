package edu.fiu.sysdesign;

import java.util.ArrayList;
import java.util.List;

import edu.fiu.sysdesign.rover.Antenna;
import edu.fiu.sysdesign.rover.Camera;
import edu.fiu.sysdesign.rover.Engine;
import edu.fiu.sysdesign.rover.PowerSource;
import edu.fiu.sysdesign.rover.Wheel;
import edu.fiu.sysdesign.rover.sensor.CollisionSensor;
import edu.fiu.sysdesign.rover.sensor.InfraredSensor;
import edu.fiu.sysdesign.rover.sensor.LightSensor;
import edu.fiu.sysdesign.util.Direction;

public class Rover {
	
	private List<Wheel> wheels = new ArrayList<Wheel>();
	private List<Antenna> antennas = new ArrayList<Antenna>();
	private PowerSource powerSource = new PowerSource();
	private Engine engine = new Engine();
	private Camera camera = new Camera();
	private CollisionSensor collisionSensor = new CollisionSensor();
	private LightSensor lightSensor = new LightSensor();
	private InfraredSensor infraredSensor = new InfraredSensor();
		
	public Rover() {
		for (int i = 0; i < 6; i++) {
			wheels.add(new Wheel());
		}	
		for (int i = 0; i < 3; i++) {
			antennas.add(new Antenna());
		}		
	}

	public void moveDirection(Direction direction) {
		
	}
	
	public boolean safeToMoveInDirection(Direction direction) {
		return true;
	}
	
	public void recordData() {
		
	}
	
	public void interpretRemoteCommand() {
		
	}
	
	public boolean runSelfCheckAllComponents() {
		List<Boolean> allChecksPassed = new ArrayList<Boolean>();
		
		allChecksPassed.add(powerSource.selfCheck());
		allChecksPassed.add(engine.selfCheck());
		allChecksPassed.add(camera.selfCheck());
		allChecksPassed.add(collisionSensor.selfCheck());
		allChecksPassed.add(lightSensor.selfCheck());
		allChecksPassed.add(infraredSensor.selfCheck());
		for (Wheel wheel : wheels) {
			allChecksPassed.add(wheel.selfCheck());
		}
		for (Antenna antenna : antennas) {
			allChecksPassed.add(antenna.selfCheck());
		}
		
		return !allChecksPassed.contains(Boolean.FALSE);
	}
	
}
