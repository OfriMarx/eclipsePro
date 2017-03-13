package spaceShooter;

import java.awt.Color;
import java.awt.Graphics;

public class Space_Bullet {

	private int x, y, size;
	private String d;
	private boolean active;
	
	Space_Bullet(int x, int y, String direction, int size)
	{
		this.x = x + 5*size - 5;//Sets the x of bullet to the middle of the player
		this.d = direction;
		this.size = size;
		if(d == "up")//sets the y of bullet away from the player
			this.y = y - 7*size;//y - the size of the head
		else
			this.y = y + 7*size + 10*size;//y + the size of head + body
		active = false;
	}
	
	/*Paints the bullet*/
	public void paintBullet(Graphics g)
	{	
		g.setColor(Color.GREEN); //Sets the color to green
		g.drawOval(x, y, 10, 10);
	}
	
	/*Changes the position of the bullet*/
	public void bulletUpdate()
	{
		if(d == "up")
			y -= 2;
		else
			y += 2;
	}
	
	public void activated()
	{
		this.active = true;
	}
	
	public boolean isActive()
	{
		return active;
	}

	public void setX(int x) {
		this.x = x + 5*size - 5;
	}

	public void setY(int y) {
		if(d == "up")
			this.y = y - 7*size;
		else
			this.y = y + 7*size + 10*size;
	}
}
