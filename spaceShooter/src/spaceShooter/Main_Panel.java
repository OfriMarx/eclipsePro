package spaceShooter;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main_Panel extends JPanel{

	private Player p1;
	
	public Main_Panel(Main_Frame frame)
	{
		setBackground(Color.BLACK);
		
		p1 = new Player(50, frame.getHeight()-130);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		p1.paintPlayer(g);
	}
	
}
