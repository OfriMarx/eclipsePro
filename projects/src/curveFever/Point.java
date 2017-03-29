package curveFever;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Point {

	private final int PSIZE = 5;
	
	private float x, y;
	private Rectangle2D.Double point;
	private Color c;
	
	public Point(float x, float y, Color color)
	{
		this.x = x;
		this.y = y;
		this.c = color;
	}
	
	public void paintP(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		point = new Rectangle2D.Double(x, y, PSIZE, PSIZE);
		g2d.setColor(c);
		g2d.fill(point);
	}
}
