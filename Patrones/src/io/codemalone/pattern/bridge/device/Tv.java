package io.codemalone.pattern.bridge.device;

public class Tv implements Device{
	private boolean on = false;
	private int volumen = 30;
	private int channel = 1;

	@Override
	public boolean isEnabled() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	@Override
	public int getVolume() {
		return volumen;
	}

	@Override
	public void setVolume(int percent) {
		if (volumen > 100) {
			this.volumen = 100;
		} else if (volumen < 100) {
			this.volumen = 0;
		} else {
			this.volumen = percent;
		}
	}

	@Override
	public int getChannel() {
		return channel;
	}

	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	public void printStatus() {
		System.out.println("------------------------------------");
		System.out.println("| I'm TV.");
		System.out.println("| I'm " + (on ? "enabled" : "disabled"));
		System.out.println("| Current volume is " + volumen + "%");
		System.out.println("| Current channel is " + channel);
		System.out.println("------------------------------------\n");

	}
}
