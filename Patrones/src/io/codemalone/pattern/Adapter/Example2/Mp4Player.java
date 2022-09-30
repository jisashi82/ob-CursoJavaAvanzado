package io.codemalone.pattern.Adapter.Example2;

public class Mp4Player implements AdvanceMediaPlayer{

	@Override
	public void playVLC(String filename) {
		//do nothing
	}

	@Override
	public void playMP4(String filename) {
		System.out.println("Plying Mp4 file. Name: "+ filename);		
	}

}
