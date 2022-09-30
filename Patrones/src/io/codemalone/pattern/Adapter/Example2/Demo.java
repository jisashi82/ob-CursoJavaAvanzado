package io.codemalone.pattern.Adapter.Example2;

/*
 * Adapter es un patrón de diseño estructural que permite la colaboración entre objetos con interfaces incompatibles.
 */
public class Demo {

	public static void main(String[] args) {
		
		AudioPlayer windowsPlayer = new AudioPlayer();
		
		windowsPlayer.play("mp3", "la_vaca.mp3");
		windowsPlayer.play("vlc", "guardianesGalaxyvol2.vlc");
		windowsPlayer.play("mp4", "alone.mp4");
		windowsPlayer.play("avi", "test.avi");

	}

}
