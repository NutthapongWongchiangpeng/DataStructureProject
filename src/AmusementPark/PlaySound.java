package AmusementPark;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlaySound {
	
	public static final PlaySound sound = new PlaySound("pk.wav");
	public static final PlaySound sound1 = new PlaySound("click.wav");
	public static final PlaySound sound2 = new PlaySound("cancel.wav");
	public static final PlaySound sound3 = new PlaySound("enter.wav");
	public static final PlaySound sound4 = new PlaySound("block.wav");
	public static final PlaySound sound5 = new PlaySound("timeout.wav");
	
	private AudioClip clip;
	
	public PlaySound(String filename){
		try{
			clip = Applet.newAudioClip(PlaySound.class.getResource(filename));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void play(){
		try{
			new Thread(){
				public void run(){
					clip.play();
				}
			}.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stop(){
		try{
			new Thread(){
				public void run(){
					clip.stop();
				}
			}.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void loop(){
		try{
			new Thread(){
				public void run(){
					clip.loop();
				}
			}.start();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}