package main;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	public static float VOLUME = 0.15f;
	
	//ATTRIBUTS
	
	private Clip music;
	private URL soundFile[] = new URL[30];
	
	//CONSTRUCTEURS
	
	public Sound() {
		soundFile[0] = getClass().getResource("/sounds/musique.wav");
		soundFile[1] = getClass().getResource("/sounds/bouton.wav");
	}
	
	
	//COMMANDES
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile[i]);
			music = AudioSystem.getClip();
			music.open(ais);
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void play() {
		music.start();
		setVolume(VOLUME);
	}
	
	public void loop() {
		music.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		music.stop();
	}
	
	public void setVolume(float volume) {
	    if (volume < 0f || volume > 1f)
	        throw new IllegalArgumentException("Volume not valid: " + volume);
	    FloatControl gainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);        
	    gainControl.setValue(20f * (float) Math.log10(volume));
	}

}
