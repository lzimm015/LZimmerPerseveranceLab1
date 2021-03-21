package edu.fiu.sysdesign.rover;

public class Camera implements Component {

	@Override
	public String getComponentName() {
		return "Camera";
	}

	@Override
	public boolean selfCheck() {
		System.out.printf("%s - Check OK%n", getComponentName());
		return true;
	}

}
