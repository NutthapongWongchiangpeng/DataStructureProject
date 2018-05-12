package AmusementPark;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends Entity {
	
	GameFrame gf;
	int speed = 2;
	int velX = 0, velY = 0;
	int ii = 0;
	int key;
	
	//create player image url// 
	String character = "Image/Character/stop_up.png";
	
	//get player position//
	public Player(int x, int y) {
		super(x, y);
	}

	//update player position//
	public void update() {
		
		y += velY;
		
		if(y <= 0)
		{
			y = 0;
		}
		else if(y > 570)
		{
			y = 570;
		}
		
		x += velX;
		if(x <= 0)
		{
			x = 0;
		}
		else if(x > 770)
		{
			x = 770;
		}
	}
	
	//add player image//
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(character), x, y, null );
	}
	
	//get player image//
	public Image getPlayerImg(String directory) {
		ImageIcon ic = new ImageIcon(character);
		return ic.getImage();
	}
	
	//add event when key pressed//
	public void keyPressed(KeyEvent e) {
		
		key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			velY = -speed;
			velX = 0;
			character = checkUp(character);
		} else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			velY = speed;
			velX = 0;
			character = checkDown(character);
		} else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			velX = -speed;
			velY = 0;
			character = checkLeft(character);
		} else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			velX = speed;
			velY = 0;
			character = checkRight(character);
		}
	}
	
	//add event when key released//
	public void keyReleased(KeyEvent e) {
		
		key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			velY = 0;
			character  = "Image/Character/stop_up.png";
		} else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			velY = 0;
			character  = "Image/Character/stop_down.png";
		} else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			velX = 0;
			character  = "Image/Character/stop_left.png";
		} else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			velX = 0;
			character  = "Image/Character/stop_right.png";
		}
	}
	
	//get image's bound//
	public Rectangle getBoundss() {
		return new Rectangle(x,y,getPlayerImg(character).getWidth(null),getPlayerImg(character).getHeight(null));
	}
	
	//redraw player image//
	public void redraw(Graphics2D g2d) {
			g2d.drawImage(getPlayerImg(character), x, y, null );
	}
	
	//change image for animation in up key//
	public String checkUp(String directory){
		String characterStop = "Image/Character/stop_up.png";
		if(directory == "Image/Character/stop_up.png"){
			characterStop = "Image/Character/step_up_l.png";
		}else if(directory == "Char/step_up_l.png"){
			characterStop = "Image/Character/step_up_r.png";
		}else if(directory == "Char/step_up_r.png.jpg"){
			characterStop = "Image/Character/step_up_l.png.jpg";
		}else characterStop = "Image/Character/stop_up.png";
		return characterStop;
	}
	
	//change image for animation in down key//
	public String checkDown(String directory){
		String characterStop = "Image/Character/stop_down.png";
		if(directory == "Image/Character/stop_down.png"){
			characterStop = "Image/Character/step_down_l.png";
		}else if(directory == "Image/Character/step_down_l.png"){
			characterStop = "Image/Character/step_down_r.png";
		}else if(directory == "Image/Character/step_down_r.png.jpg"){
			characterStop = "Image/Character/step_down_l.png.jpg";
		}else characterStop = "Image/Character/stop_down.png";
		return characterStop;
	}
	
	//change image for animation in left key//
	public String checkLeft(String directory){
		String characterStop = "Image/Character/stop_left.png";
		if(directory == "Image/Character/stop_left.png"){
			characterStop = "Image/Character/step_left_l.png";
		}else if(directory == "Image/Character/step_left_l.png"){
			characterStop = "Image/Character/step_left_r.png";
		}else if(directory == "Image/Character/step_left_r.png.jpg"){
			characterStop = "Image/Character/step_left_l.png.jpg";
		}else characterStop = "Image/Character/stop_left.png";
		return characterStop;
	}
	
	//change image for animation in right key//
	public String checkRight(String directory){
		String characterStop = "Image/Character/stop_right.png";
		if(directory == "Image/Character/stop_right.png"){
			characterStop = "Image/Character/step_right_l.png";
		}else if(directory == "Image/Character/step_right_l.png"){
			characterStop = "Image/Character/step_right_r.png";
		}else if(directory == "Image/Character/step_right_r.png.jpg"){
			characterStop = "Image/Character/step_right_l.png.jpg";
		}else characterStop = "Image/Character/stop_right.png";
		return characterStop;
	}
	
}