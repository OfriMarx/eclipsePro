package curveFever;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CF_Panel extends JPanel{
	
	public CF_Panel(CF frame)
	{
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Point p = new Point(77,77, Color.red);
		p.paintP(g);
	}
}
