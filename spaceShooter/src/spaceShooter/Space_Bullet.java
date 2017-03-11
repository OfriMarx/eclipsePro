package spaceShooter;

import java.awt.Color;
import java.awt.Graphics;

public class Space_Bullet {

	private int x, y;
	
	Space_Bullet(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void paintBullet(Graphics g)
	{	
		g.setColor(Color.GREEN); //Sets the color to green
		g.fillOval(x, y, 10, 10);
	}
	
}
