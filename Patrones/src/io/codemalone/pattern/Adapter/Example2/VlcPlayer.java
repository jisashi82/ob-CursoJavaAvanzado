package io.codemalone.pattern.Adapter.Example2;

public class VlcPlayer implements AdvanceMediaPlayer{

	@Override
	public void playVLC(String filename) {
		System.out.println("Playing vlc file. Name: "+ filename);
		
	}

	@Override
	public void playMP4(String filename) {
		// do nothing		
	}

}
