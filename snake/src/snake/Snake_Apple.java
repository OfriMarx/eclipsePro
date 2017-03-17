package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Snake_Apple {

	private int x, y, size;
	
	public Snake_Apple(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void paintApple(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(x, y, size, size);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,size,size);
	}
}
