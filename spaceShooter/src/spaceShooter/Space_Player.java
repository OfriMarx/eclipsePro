package spaceShooter;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Space_Player {

	private final int SIZE = 6;
	
	private Space_Frame frame;
	private int x, y, right, left, fire, health;
	private int[] xarr, yarr;
	private char direction = ' ';
	private Color color;
	private Rectangle body, healthBar;
	private Polygon head;
	private Space_Bullet b1;
	private boolean active;
	private GradientPaint healthBarPaint;
	
	public Space_Player(int x, int y, int right, int left, int fire, Color c, Space_Panel panel, Space_Frame frame)
	{
		this.x = x;
		this.y = y;
		this.color = c;
		this.right = right;
		this.left = left;
		this.fire = fire;
		this.frame = frame;
		this.active = true;
		this.health = 2;
		
		if(y > frame.getHeight()/2)//If the player is underneath the middle of the frame
			b1 = new Space_Bullet(x, y, "up", SIZE, panel);
		else
			b1 = new Space_Bullet(x, y, "down", SIZE, panel);
	}
	
	public void paintPlayer(Graphics g)
	{
		
		System.out.println("shi");
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
		g2d.setColor(Color.GREEN.darker());
		g2d.fill(healthBar);
		
		if(b1.isActive() && active)
			b1.paintBullet(g);
		System.out.println("gi");
	}
	
	public void pressed(int key)
	{	
		if(key == right)//If right movement button is pressed
			direction = 'r';
		if(key == left)	//If left movement button is pressed
			direction = 'l';
		if(key == fire && !b1.isActive())
		{
			b1.setX(x);
			b1.setY(y);
			b1.activated();
		}
			
			
	}
	
	public void released(int key)
	{
		if(key == right || key == left)
			direction = ' ';
	}
	
	public void updatePlayer()
	{
		System.out.println("hi");
		
		switch(direction) //Changes the x according to the direction
		{
		case 'l':
			x -= 2;
			break;
		case 'r':
			x += 2;
			break;
		}
		
		if(b1.isActive())
			b1.bulletUpdate();
		
		System.out.println("bi");
	}
	
	public void damageHealth()
	{
		health -= 1;
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
}
