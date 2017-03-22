package spaceShooter;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Space_Player {

	private final int SIZE = 6;
	
	private ArrayList<Space_Bullet> cartridge = new ArrayList<Space_Bullet>();
	private Space_Panel panel;
	private Space_Frame frame;
	private int x, y, right, left, fire, health, bulletNum;
	private int[] xarr, yarr;
	private char direction = ' ';
	private Color color;
	private Rectangle body, healthBar, bulletBar;
	private Polygon head;
	private boolean active, stuck, invincible;
	private String bd;
	private Timer decreaseBullet = new Timer(60, new TimerAction());
	
	public Space_Player(int x, int y, int right, int left, int fire, Color c, String bulletDirection, Space_Panel panel, Space_Frame frame)
	{
		this.x = x;
		this.y = y;
		this.color = c;
		this.right = right;
		this.left = left;
		this.fire = fire;
		this.panel = panel;
		this.frame = frame;
		this.active = true;
		this.stuck = false;
		this.invincible = false;
		this.health = 2;
		this.bd = bulletDirection;
		this.bulletNum = 0;
		
		decreaseBullet.start();
	}
	
	public void paintPlayer(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		
		if(y > frame.getHeight()/2)//If the player is underneath the middle of the frame
		{
			xarr = new int[]{x, x+2*SIZE, x+4*SIZE, x+6*SIZE, x+8*SIZE, x+10*SIZE}; 
			yarr = new int[]{y, y-8*SIZE, y-2*SIZE, y-2*SIZE, y-8*SIZE, y};
		}
		else
		{
			xarr = new int[]{x, x+2*SIZE, x+4*SIZE, x+6*SIZE, x+8*SIZE, x+10*SIZE}; 
			yarr = new int[]{y, y+8*SIZE, y+2*SIZE, y+2*SIZE, y+8*SIZE, y};
			
			for(int i=0; i<6; i++)
				yarr[i] += 10*SIZE;
		}
			
		head = new Polygon(xarr, yarr, 6);	//Creates a shape with two arrays that represents point values
		body = new Rectangle(x, y, 10*SIZE, 10*SIZE);//Creates a square
		
		g2d.setColor(color);	//Sets the color
		g2d.fill(body);			//Draws the square
		g2d.fill(head); 		//Draws the shape
		
		healthBar = new Rectangle(x-20, y, 10, 10*SIZE);
		g2d.setPaint(setHealthColor());
		g2d.fill(healthBar);
		
		bulletBar = new Rectangle(x-30, y, 10, 10*SIZE);
		g2d.setPaint(setBulletColor());
		g2d.fill(bulletBar);
		
		if(!cartridge.isEmpty())
		{
			for(int i=0; i<cartridge.size(); i++)
			{
				if(cartridge.get(i).isActive())
					cartridge.get(i).paintBullet(g);
				else
					cartridge.remove(i);
			}
		}
	}
	
	public void pressed(int key)
	{	
		if(key == right)//If right movement button is pressed
			direction = 'r';
		if(key == left)	//If left movement button is pressed
			direction = 'l';
		if(key == fire && !stuck)
		{
			cartridge.add(new Space_Bullet(x, y, bd, SIZE, panel));
			bulletNum += 30;
		}
			
			
	}
	
	public void released(int key)
	{
		if(key == right || key == left)
			direction = ' ';
	}
	
	public void updatePlayer()
	{
		switch(direction) //Changes the x according to the direction
		{
		case 'l':
			x -= 2;
			break;
		case 'r':
			x += 2;
			break;
		}

		if(!cartridge.isEmpty())
		{
			for(Space_Bullet b:cartridge)
				b.bulletUpdate();
		}
			
	}
	
	public void damageHealth()
	{
		health -= 1;
		if(health == 0)
		{
			panel.repaint();
			this.active = false;
			decreaseBullet.stop();
		}
	}
	
	public GradientPaint setHealthColor()
	{
		GradientPaint gp = null;
		if(health == 2)
			gp = new GradientPaint(x-20, y+5*SIZE, Color.GREEN.darker(), x-20, y+5*SIZE+1, Color.GREEN.darker());
		else if(health == 1)
			gp = new GradientPaint(x-20, y+5*SIZE, Color.GREEN.darker(), x-20, y+5*SIZE+1, Color.RED);
		else
			gp = new GradientPaint(x-20, y+5*SIZE, Color.RED, x-20, y+5*SIZE+1, Color.RED);
		return gp;
	}
	
	public GradientPaint setBulletColor()
	{
		GradientPaint gp = new GradientPaint(x-30, y+10*SIZE-1-(bulletNum*SIZE/10), panel.getBackground(), x-30, y+10*SIZE-(bulletNum*SIZE/10), Color.ORANGE);
		return gp;
	}
	
	public Rectangle getBounds()
	{
		return body.getBounds();
	}
	
	public void deactivate()
	{
		this.active = false;
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	public boolean isInvincible() {
		return invincible;
	}

	private class TimerAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(bulletNum > 0)
				bulletNum -= 3;
			if(bulletNum < 100)
				stuck = false;
			if(bulletNum >= 100 && !stuck)
			{
				bulletNum = 180;
				stuck = true;
			}
				
		}
		
	}
}
