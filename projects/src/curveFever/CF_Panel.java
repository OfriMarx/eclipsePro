package curveFever;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CF_Panel extends JPanel{
	
	private Timer update = new Timer(5, new TimerAction());
	private CurvePlayer p1, p2, p3, p4;
	private CF frame;
	private int alive = 0;
	
	public CF_Panel(CF frame, String left1, String right1, String left2, String right2, String left3, String right3, String left4, String right4)
	{
		setBackground(Color.BLACK);
		this.frame = frame;
		
		p1 = new CurvePlayer(15,60, Color.red, right1, left1, 0);
		setBindings(p1, "p1");
		alive ++;
		
		p2 = new CurvePlayer(15,120, Color.blue, right2, left2, 0);
		setBindings(p2, "p2");
		alive ++;
		
		p3 = new CurvePlayer(15,300, Color.green, right3, left3, 0);
		setBindings(p3, "p3");
		alive ++;
		
		p4 = new CurvePlayer(15,500, Color.cyan, right4, left4, 0);
		setBindings(p4, "p4");
		alive ++;
		
		this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "close");
		this.getActionMap().put("close", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(update.isRunning())
					update.stop();
				frame.dispose();
			}
		});
		
		this.addMouseListener(new MouseAction());
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		p1.drawPlayer(g);
		p2.drawPlayer(g);
		p3.drawPlayer(g);
		p4.drawPlayer(g);
		
		if(alive < 2)
		{
			Font stringFont = new Font("a", Font.BOLD, 35);
			String s = "P1 WINS!";
			int sx = frame.getWidth() / 2 - g.getFontMetrics(stringFont).stringWidth(s) / 2;
			int sy = frame.getHeight()/2;
			if(p1.active)
			{
				g.setColor(Color.RED);
				g.setFont(stringFont);
				g.drawString(s, sx, sy);
			}
			else if(p2.active)
			{
				s = "P2 WINS!";
				g.setColor(Color.blue);
				g.setFont(stringFont);
				g.drawString(s, sx, sy);
			}
			else if(p3.active)
			{
				s = "P3 WINS!";
				g.setColor(Color.green);
				g.setFont(stringFont);
				g.drawString(s, sx, sy);
			}
			else if(p4.active)
			{
				s = "P4 WINS!";
				g.setColor(Color.cyan);
				g.setFont(stringFont);
				g.drawString(s, sx, sy);
			}
		}
	}
	
	public void setBindings(CurvePlayer p, String name)
	{
		InputMap im = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = this.getActionMap();
		
		im.put(KeyStroke.getKeyStroke("pressed " + p.getRight()), name + "rightPressed");
		am.put(name + "rightPressed", new AbstractAction()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						p.setDirection('r');
					}
				}
		);
		
		im.put(KeyStroke.getKeyStroke("released " + p.getRight()), name + "rightReleased");
		am.put(name + "rightReleased", new AbstractAction()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(p.getDirection() == 'r')
							p.setDirection(' ');
					}
				}
		);
		
		im.put(KeyStroke.getKeyStroke("pressed " + p.getLeft()), name + "leftPressed");
		am.put(name + "leftPressed", new AbstractAction()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						p.setDirection('l');
					}
				}
		);
		
		im.put(KeyStroke.getKeyStroke("released " + p.getLeft()), name + "leftReleased");
		am.put(name + "leftReleased", new AbstractAction()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(p.getDirection() == 'l')
							p.setDirection(' ');
					}
				}
		);
	}
	
	private class TimerAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(p1.active)
				p1.updatePlayer();
			if(p2.active)
				p2.updatePlayer();
			if(p3.active)
				p3.updatePlayer();
			if(p4.active)
				p4.updatePlayer();
			
			double p1x = p1.getHead().getX(), p1y =  p1.getHead().getY();
			double p2x = p2.getHead().getX(), p2y =  p2.getHead().getY();
			double p3x = p3.getHead().getX(), p3y =  p3.getHead().getY();
			double p4x = p4.getHead().getX(), p4y =  p4.getHead().getY();
			Rectangle2D p1h = p1.getHead(), p2h = p2.getHead(), p3h = p3.getHead(), p4h = p4.getHead();
			
			if((p1x > frame.getWidth() || p1y > frame.getHeight() || p1y < 0 || p1x < 0) && p1.active)
			{
				p1.active = false;
				alive--;
			}
			if((p2x > frame.getWidth() || p2y > frame.getHeight() || p2y < 0 || p2x < 0) && p2.active)
			{
				p2.active = false;
				alive--;
			}
			if((p3x > frame.getWidth() || p3y > frame.getHeight() || p3y < 0 || p3x < 0) && p3.active)
			{
				p3.active = false;
				alive--;
			}
			if((p4x > frame.getWidth() || p4y > frame.getHeight() || p4y < 0 || p4x < 0) && p4.active)
			{
				p4.active = false;
				alive--;
			}
				
			
			for(int i=0; i<p1.getPoints().size(); i++)
			{
				if(p2h.intersects(p1.getPoints().get(i)) && p2.active)
				{
					p2.active = false;
					alive--;
				}
				if(p3h.intersects(p1.getPoints().get(i)) && p3.active)
				{
					p3.active = false;
					alive--;
				}
				if(p4h.intersects(p1.getPoints().get(i)) && p4.active)
				{
					p4.active = false;
					alive--;
				}
				if(i < p1.getPoints().size()-10 && p1h.intersects(p1.getPoints().get(i)) && p1.active)
				{
					p1.active = false;
					alive--;
				}
			}
			for(int i=0; i<p2.getPoints().size(); i++)
			{
				if(p1h.intersects(p2.getPoints().get(i)) && p1.active)
				{
					p1.active = false;
					alive--;
				}
				if(p3h.intersects(p2.getPoints().get(i)) && p3.active)
				{
					p3.active = false;
					alive--;
				}
				if(p4h.intersects(p2.getPoints().get(i)) && p4.active)
				{
					p4.active = false;
					alive--;
				}
				if(i < p2.getPoints().size()-10 && p2h.intersects(p2.getPoints().get(i)) && p2.active)
				{
					alive--;
					p2.active = false;
				}	
			}
			for(int i=0; i<p3.getPoints().size(); i++)
			{
				if(p2h.intersects(p3.getPoints().get(i)) && p2.active)
				{
					p2.active = false;
					alive--;
				}
				if(p1h.intersects(p3.getPoints().get(i)) && p1.active)
				{
					p1.active = false;
					alive--;
				}
				if(p4h.intersects(p3.getPoints().get(i)) && p4.active)
				{
					p4.active = false;
					alive--;
				}
				if(i < p3.getPoints().size()-10 && p1h.intersects(p3.getPoints().get(i)) && p3.active)
				{
					p3.active = false;
					alive--;
				}
			}
			for(int i=0; i<p4.getPoints().size(); i++)
			{
				if(p1h.intersects(p4.getPoints().get(i)) && p1.active)
				{
					p1.active = false;
					alive--;
				}
				if(p3h.intersects(p4.getPoints().get(i)) && p3.active)
				{
					p3.active = false;
					alive--;
				}
				if(p2h.intersects(p4.getPoints().get(i)) && p2.active)
				{
					p2.active = false;
					alive--;
				}
				if(i < p4.getPoints().size()-10 && p2h.intersects(p4.getPoints().get(i)) && p4.active)
				{
					alive--;
					p4.active = false;
				}	
			}
			
			
			if(alive < 2)
			{
				update.stop();
			}
			
			repaint();
		}
	}
	
	private class MouseAction implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(update.isRunning())
				update.stop();
			else
				update.start();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}
}
