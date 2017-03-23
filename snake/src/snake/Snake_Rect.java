package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Snake_Rect {

	private boolean first, active;
	private int x, y, size;
	private char direction = 'r';
	private Snake_Rect preRect;
	
	public Snake_Rect(int x, int y, int size, Snake_Rect preRect)
	{
		this.x = x;
		this.y = y;
		this.size = size;
		this.first = false;
		this.active = true;
		
		if(preRect == null)
			first = true;
		else
			this.preRect = preRect;
	}
	
	public void paintRect(Graphics g)
	{
		if(first)
			g.setColor(Color.GREEN.darker().darker());
		else
			g.setColor(Color.GREEN);
		g.fillRect(x, y, size, size);
	}
	
	public void RectUpdate()
	{
		if(first)
		{
			switch(direction)
			{
			case 'r':
				x += size;
				break;
			case 'l':
				x -= size;
				break;
			case 'u':
				y -= size;
				break;
			case 'd':
				y += size;
				break;
			}
		}
		else
		{
			x = preRect.getX();
			y = preRect.getY();
		}
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x,y,size,size);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
