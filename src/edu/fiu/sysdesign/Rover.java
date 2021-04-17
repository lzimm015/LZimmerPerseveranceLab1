package edu.fiu.sysdesign;

import java.util.ArrayList;
import java.util.List;

import edu.fiu.sysdesign.rover.Antenna;
import edu.fiu.sysdesign.rover.Camera;
import edu.fiu.sysdesign.rover.Engine;
import edu.fiu.sysdesign.rover.PowerSource;
import edu.fiu.sysdesign.rover.Wheel;
import edu.fiu.sysdesign.rover.sensor.NavcamSensor;
import edu.fiu.sysdesign.rover.sensor.HazcamSensor;
import edu.fiu.sysdesign.rover.sensor.LidarSensor;
import edu.fiu.sysdesign.util.Direction;

public class Rover {
	
	private List<Wheel> wheels = new ArrayList<Wheel>();
	private List<Antenna> antennas = new ArrayList<Antenna>();
	private PowerSource powerSource = new PowerSource();
	private Engine engine = new Engine();
	private Camera camera = new Camera();
	private NavcamSensor navcamSensor = new NavcamSensor();
	private LidarSensor lidarSensor = new LidarSensor();
	private HazcamSensor hazcamSensor = new HazcamSensor();
	private ControlStation controlStation;
	
	private int arrivalCount = 0;
		
	public Rover() {
		for (int i = 0; i < 6; i++) {
			wheels.add(new Wheel());
		}	
		for (int i = 0; i < 3; i++) {
			antennas.add(new Antenna());
		}		
	}

	public void moveDirection(Direction direction) {
		System.out.println("2.1 checking sensors to see if its safe to move");
		if (safeToMoveInDirection(direction)) {
			System.out.println("2.2 movement is valid");
			for (Wheel wheel : wheels) {
				wheel.spin(direction);
			}
			engine.setPower(20);
		}
		System.out.println("2.5 keep checking if movement is valid");
		while (safeToMoveInDirection(direction)) {
			System.out.println("2.5.1 is it safe to move?");
			if (haveWeArrived()) {
				System.out.println("2.5.2 we have arrived!");
				controlStation.notifyRoverArrivalToDestination();
				break;
			} else {
				System.out.println("2.5.2 we have not arrived");
			}
		}
	}
	
	public boolean haveWeArrived() {
		arrivalCount++;
		if (arrivalCount < 3) {
			return false;
		} else {
			return true;
		}		
	}
	
	/**
	 * Check all sensors to see if it is safe to move
	 */
	public boolean safeToMoveInDirection(Direction direction) {
		navcamSensor.receiveSignal();
		lidarSensor.receiveSignal();
		hazcamSensor.receiveSignal();
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
		allChecksPassed.add(navcamSensor.selfCheck());
		allChecksPassed.add(lidarSensor.selfCheck());
		allChecksPassed.add(hazcamSensor.selfCheck());
		for (Wheel wheel : wheels) {
			allChecksPassed.add(wheel.selfCheck());
		}
		for (Antenna antenna : antennas) {
			allChecksPassed.add(antenna.selfCheck());
		}
		
		return !allChecksPassed.contains(Boolean.FALSE);
	}

	/**
	 * Returns true if ready
	 */
	public boolean activate() {
		System.out.println("1.1 authenticating Control Station");
		System.out.println("1.2 running full systems check");
		runSelfCheckAllComponents();
		return true;
	}

	public void setControlStation(ControlStation controlStation) {
		this.controlStation = controlStation;
	}
	
	
	
}
