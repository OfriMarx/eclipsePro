package spaceShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Space_Player {

	private final int SIZE = 6;
	
	private int x, y, right, left;
	private char direction = ' ';
	private Color color;
	
	public Space_Player(int x, int y, int right, int left, Color c)
	{
		this.x = x;
		this.y = y;
		this.color = c;
		this.right = right;
		this.left = left;
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
		if(key == right)//If right arrow is pressed
			direction = 'r';
		if(key == left)	//If left arrow is pressed
			direction = 'l';
	}
	
	public void released(int key)
	{
		if(key == right || key == left)
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
