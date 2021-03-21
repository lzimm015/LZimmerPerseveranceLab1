package edu.fiu.sysdesign.rover;

import edu.fiu.sysdesign.util.Direction;

public class Wheel implements Component {

	public void turnClockwise(int degrees) {

	}

	public void turnAntiClockwise(int degrees) {

	}

	public void spin(Direction direction) {

	}

	@Override
	public String getComponentName() {
		return "Wheel";
	}

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}

}