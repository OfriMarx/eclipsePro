package spaceShooter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

public class Player {

	private int x, y;
	private final int SIZE = 6;
	
	public Player(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void paintPlayer(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		Rectangle2D body = new Rectangle2D.Double(x, y, 10*SIZE, 10*SIZE);
		
		g2d.setColor(Color.BLUE);
		g2d.fill(body);
	}
}
