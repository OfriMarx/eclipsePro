package curveFever;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class CurvePlayer {

	private final int PSIZE = 5;
	
	public double xVelocity, yVelocity, angle;
	
	private ArrayList<Rectangle2D> points = new ArrayList<>();
	private double x, y;
	private Rectangle2D.Double point;
	private Color c;
	private String right, left;
	private char direction;
	
	public CurvePlayer(double x, double y, Color color, String right, String left)
	{
		this.x = x;
		this.y = y;
		this.c = color;
		this.xVelocity = 0.5;
		this.yVelocity = 0;
		this.angle = 0;
		this.right = right;
		this.left = left;
		this.direction = ' ';
		
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
		if(direction == 'r')
			angle += 0.01;
		else if(direction == 'l')
			angle -= 0.01;
		
		xVelocity = Math.cos(angle)/2;
		yVelocity = Math.sin(angle)/2;
		
		x += xVelocity;
		y += yVelocity;
		points.add(addPoint(x, y));
	}
	
	public String getRight() {
		return right.toUpperCase();
	}

	public String getLeft() {
		return left.toUpperCase();
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
}
