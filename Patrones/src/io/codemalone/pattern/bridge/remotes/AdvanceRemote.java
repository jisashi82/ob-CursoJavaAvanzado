package io.codemalone.pattern.bridge.remotes;

import io.codemalone.pattern.bridge.device.Device;

public class AdvanceRemote extends BasicRemote{
	
	public AdvanceRemote(Device device) {
		super.device = device;
	}
	
	public void mute() {
		System.out.println("Remote: Mute");
		device.setVolume(0);
	}

}
