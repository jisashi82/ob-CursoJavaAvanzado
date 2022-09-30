package io.codemalone.pattern.Adapter.Example2;

public class AudioPlayer implements MediaPlayer{
	
	private MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		
		// el audioplayer soporta reproducir MP3 music files
		if(audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing MP3 file. Name " + fileName);
		}
		// MediaAdapter provee soporte de reproduccion para otros formatos
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else {
			System.out.println("Formato Invalido " +audioType +" No soportado");
		}
		
	}

}
