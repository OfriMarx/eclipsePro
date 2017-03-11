package spaceShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Space_Player {

	private final int SIZE = 6;
	
	private Space_Frame frame;
	private int x, y, right, left;
	private int[] xarr, yarr;
	private char direction = ' ';
	private Color color;
	private Rectangle body;
	private Polygon head;
	
	public Space_Player(int x, int y, int right, int left, Color c, Space_Frame frame)
	{
		this.x = x;
		this.y = y;
		this.color = c;
		this.right = right;
		this.left = left;
		this.frame = frame;
	}
	
	public void paintPlayer(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		
		if(y > frame.getHeight()/2) //If the player is underneath the middle of the frame
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
