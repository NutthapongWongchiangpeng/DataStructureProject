package AmusementPark;

import java.awt.event.*;

public class Key extends KeyAdapter {
	
	Player p;
	
	public Key(Player player) {
		p = player;
	}

	public void keyPressed(KeyEvent e){
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		p.keyReleased(e);
	}
}