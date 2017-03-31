package curveFever;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CF_Panel extends JPanel{
	
	private Timer update = new Timer(5, new TimerAction());
	private CurvePlayer p;
	
	public CF_Panel(CF frame)
	{
		setBackground(Color.BLACK);
		p = new CurvePlayer(77,77, Color.red);
		update.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		p.drawPlayer(g);
	}
	
	private class TimerAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			p.updatePlayer();
			repaint();
		}
	}
}
