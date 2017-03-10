package spaceShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Player {

	private final int SIZE = 6;
	
	private int x, y;
	private char direction = ' ';
	private Color color;
	
	public Player(int x, int y, Color c)
	{
		this.x = x;
		this.y = y;
		this.color = c;
	}
	
	public void paintPlayer(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		Rectangle2D body = new Rectangle2D.Double(x, y, 10*SIZE, 10*SIZE);
		
		g2d.setColor(color);
		g2d.fill(body);
	}
	
	public void pressed(int key)
	{
		switch(key)
		{
		case KeyEvent.VK_LEFT:
			direction = 'l';
			break;
		case KeyEvent.VK_RIGHT:
			direction = 'r';
			break;
		}
	}
	
	public void released()
	{
		direction = ' ';
	}
	
	public void move()
	{
		switch(direction)
		{
		case 'l':
			x -= 2;
			break;
		case 'r':
			x += 2;
			break;
		}
	}
}
