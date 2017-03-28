package curveFever;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CF_Panel extends JPanel{

	private CF frame;
	
	public CF_Panel(CF frame)
	{
		this.frame = frame;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawRect(3, 50, 33, 12);
	}
}
