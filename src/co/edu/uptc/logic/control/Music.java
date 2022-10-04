package co.edu.uptc.logic.control;
/**
 * @version 1.0
 */
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
	
	private Clip audioClip;
	private AudioInputStream audioStream;
	
	public Music (String path) {
		
		File audioFile = new File(path);
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
		} catch (UnsupportedAudioFileException | IOException e ) {
			e.printStackTrace();
		}
		
		
		try {
			audioClip = AudioSystem.getClip();
			audioClip.open(audioStream);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void play () {
		new Thread (()->{
			audioClip.setFramePosition(0);
			audioClip.start();
		} ) {}.start();
	}
	
	public void loop () {
		new Thread( ()->{
			audioClip.setFramePosition(0);
			audioClip.loop(Clip.LOOP_CONTINUOUSLY);
		} ) {}.start();
	}
	
	public void stop() {
		audioClip.stop();
	}
	
	public String infoSong() {
		AudioFormat format  = audioStream.getFormat();
		var info = new DataLine.Info(Clip.class, format);
		return String.valueOf(info);
	}

}
