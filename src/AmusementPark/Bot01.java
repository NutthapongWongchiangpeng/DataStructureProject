package AmusementPark;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Bot01 extends Entity {

	int speed = 1;
	int velX = 0, velY = 0;
	String character = "Image/allChar/char7/stop_up.png";
	int ii = 1;

	public Bot01(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void update() {

		walk();

		y += velY;

		if (y <= 130) {
			stop();
			ii = 4;
			walk();
		} else if (y >= 212) {
			stop();
			ii = 3;
			walk();
		}

		x += velX;
		if (x <= 388) {
			stop();
			ii = 1;
			walk();
		} else if (x >= 460) {
			stop();
			ii = 2;
			walk();
		}

	}

	private void walk() {
		// TODO Auto-generated method stub

		if (ii == 1) {
			velY = -speed;
			velX = 0;
			// ii = 2;
			character = checkUp(character);
		} else if (ii == 2) {
			velY = speed;
			velX = 0;
			// ii = 3;
			character = checkDown(character);
		} else if (ii == 3) {
			velX = -speed;
			velY = 0;
			// ii = 4;
			character = checkLeft(character);
		} else if (ii == 4) {
			velX = speed;
			velY = 0;
			// ii = 1;
			character = checkRight(character);
		}
	}

	public void stop() {
		// TODO Auto-generated method stub
		velX = 0;
		velY = 0;
	}

	// add player image//
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(character), x, y, null);
	}

	// get player image//
	public Image getPlayerImg(String directory) {
		ImageIcon ic = new ImageIcon(character);
		return ic.getImage();
	}

	// get image's bound//
	public Rectangle getBoundss() {
		return new Rectangle(x, y, getPlayerImg(character).getWidth(null),
				getPlayerImg(character).getHeight(null));
	}

	// redraw player image//
	public void redraw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(character), x, y, null);
	}

	// change image for animation in up key//
	public String checkUp(String directory) {
		String characterStop = "Image/allChar/char7/stop_up.png";
		if (directory == "Image/allChar/char7/stop_up.png") {
			characterStop = "Image/allChar/char7/step_up_l.png";
		} else if (directory == "Image/allChar/char7/step_up_l.png") {
			characterStop = "Image/allChar/char7/step_up_r.png";
		} else if (directory == "Image/allChar/char7/step_up_r.png.jpg") {
			characterStop = "Image/allChar/char7/step_up_l.png.jpg";
		} else
			characterStop = "Image/allChar/char7/stop_up.png";
		return characterStop;
	}

	// change image for animation in down key//
	public String checkDown(String directory) {
		String characterStop = "Image/allChar/char7/stop_down.png";
		if (directory == "Image/allChar/char7/stop_down.png") {
			characterStop = "Image/allChar/char7/step_down_l.png";
		} else if (directory == "Image/allChar/char7/step_down_l.png") {
			characterStop = "Image/allChar/char7/step_down_r.png";
		} else if (directory == "Image/allChar/char7/step_down_r.png.jpg") {
			characterStop = "Image/allChar/char7/step_down_l.png.jpg";
		} else
			characterStop = "Image/allChar/char7/stop_down.png";
		return characterStop;
	}

	// change image for animation in left key//
	public String checkLeft(String directory) {
		String characterStop = "Image/allChar/char7/stop_left.png";
		if (directory == "Image/allChar/char7/stop_left.png") {
			characterStop = "Image/allChar/char7/step_left_l.png";
		} else if (directory == "Image/allChar/char7/step_left_l.png") {
			characterStop = "Image/allChar/char7/step_left_r.png";
		} else if (directory == "Image/allChar/char7/step_left_r.png.jpg") {
			characterStop = "Image/allChar/char7/step_left_l.png.jpg";
		} else
			characterStop = "Image/allChar/char7/stop_left.png";
		return characterStop;
	}

	// change image for animation in right key//
	public String checkRight(String directory) {
		String characterStop = "Image/allChar/char7/stop_right.png";
		if (directory == "Image/allChar/char7/stop_right.png") {
			characterStop = "Image/allChar/char7/step_right_l.png";
		} else if (directory == "Image/allChar/char7/step_right_l.png") {
			characterStop = "Image/allChar/char7/step_right_r.png";
		} else if (directory == "Image/allChar/char7/step_right_r.png.jpg") {
			characterStop = "Image/allChar/char7/step_right_l.png.jpg";
		} else
			characterStop = "Image/allChar/char7/stop_right.png";
		return characterStop;
	}

}
