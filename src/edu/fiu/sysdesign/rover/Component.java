package edu.fiu.sysdesign.rover;

import edu.fiu.sysdesign.SelfCheckCapable;

public interface Component extends SelfCheckCapable {

	public boolean selfCheck();
	
}
