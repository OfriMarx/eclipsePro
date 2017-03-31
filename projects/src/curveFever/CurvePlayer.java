package curveFever;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class CurvePlayer {

	private final int PSIZE = 5;
	
	private ArrayList<Rectangle2D> points = new ArrayList<>();
	private double x, y;
	private Rectangle2D.Double point;
	private Color c;
	
	public CurvePlayer(double x, double y, Color color)
	{
		this.x = x;
		this.y = y;
		this.c = color;
		
		points.add(addPoint(x, y));
		
	}
	
	public Rectangle2D addPoint(double x, double y)
	{
		point = new Rectangle2D.Double(x, y, PSIZE, PSIZE);
		return point;
	}
	
	public void drawPlayer(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(c);
		for(Rectangle2D p: points)
		{
			g2d.fill(p);
		}
	}
	
	public void updatePlayer()
	{
		x += 0.5;
		points.add(addPoint(x, y));
	}
}
