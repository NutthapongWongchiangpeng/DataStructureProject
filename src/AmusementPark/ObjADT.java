package AmusementPark;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public interface ObjADT {
	  public void draw(Graphics2D g2d);
	  public Image getImage();
	  public Rectangle getBounds();
	  public int hind();
	  public int fun();
	  public void redraw(Graphics2D g2d);
}
