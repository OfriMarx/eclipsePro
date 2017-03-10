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
		
		Rectangle2D body = new Rectangle2D.Double(x, y, 10*SIZE, 10*SIZE);	//creates a square
		
		g2d.setColor(color);	//Sets the color
		g2d.fill(body);			//Draws the square
	}
	
	public void pressed(int key)
	{
		switch(key)
		{
		case KeyEvent.VK_LEFT:	//When the pressed key is left arrow
			direction = 'l';	//Sets the direction
			break;
		case KeyEvent.VK_RIGHT:	//When the pressed key is right arrow
			direction = 'r';	//Sets the direction
			break;
		}
	}
	
	public void released()
	{
		direction = ' ';
	}
	
	public void move()
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
	}
}
