package AmusementPark;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;

public class ObjCreator implements ObjADT {

	Player p;
	GameFrame gf;
	int fun,x,y,cost,tmpCost;
	Calendar time;
	int tl;
	String character;
	String name;
	int c = 0,b = 0;
	
	public ObjCreator(String character,int x,int y, int tl,int fun,String name,int cost,Calendar time){
		this.character = character;
		this.x = x;
		this.y = y;
		this.tl = tl;
		this.fun = fun;
		this.name = name;
		this.cost = cost;
		this.time = time;
		this.tmpCost = cost;
		this.gf = GameFrame.mainInstance;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(getImage(), x, y, null);
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		ImageIcon ic = new ImageIcon(character);
		return ic.getImage();
	}
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	public int getCost(){
		return this.cost;
	}
	public String getTime(){
		SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
		return sf.format(this.time.getTime());
	}
	public void setTime(Calendar time){
		this.time = time;
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,getImage().getWidth(null),getImage().getHeight(null));
	}

	@Override
	public int hind() {
		// TODO Auto-generated method stub
		if(c == 0){
			b = gf.tm - tl;
			c=1;
		return b;
		}
		else return gf.tm;
	}

	@Override
	public int fun() {
		// TODO Auto-generated method stub
		int t = gf.f + fun;
		return t;
	}

	@Override
	public void redraw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(getImage(), x, y, null );
	}
	
	public int getTmpCost(){
		return this.tmpCost;
	}
}
