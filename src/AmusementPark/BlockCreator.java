package AmusementPark;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class BlockCreator implements BlockADT{
	String character;
	int x,y;
	public BlockCreator(String character,int x,int y){
		this.character = character;
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(getImage(), x, y, null);
	}
	public Image getImage() {
		// TODO Auto-generated method stub
		ImageIcon ic = new ImageIcon(character);
		return ic.getImage();
	}
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,getImage().getWidth(null),getImage().getHeight(null));
	}
	public void redraw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(getImage(), x, y, null );
	}
}
