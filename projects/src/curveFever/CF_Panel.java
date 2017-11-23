package curveFever;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class CF_Panel extends JPanel{
	
	private Timer update = new Timer(5, new TimerAction());
	private ArrayList<CurvePlayer> playerList = new ArrayList<>();
	private CurvePlayer p1, p2, p3, p4;
	private CF frame;
	private int alive = 0;
	
	public CF_Panel(CF frame, String left1, String right1, String left2, String right2, String left3, String right3, String left4, String right4, int numOfPlayers)
	{
		setBackground(Color.BLACK);
		this.frame = frame;
		
		int frameHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int frameWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		//Randomizing starting points and angles
		int xStart = (int)(Math.random()*(frameWidth-2));
		int yStart = (int)(Math.random()*(frameHeight-2));
		int angle = (int)(Math.random()*360);
		
		p1 = new CurvePlayer(xStart, yStart, Color.red, right1, left1, angle);
		setBindings(p1, "p1");
		alive ++;
		playerList.add(p1);
		
		xStart = (int)(Math.random()*(frameWidth-2));
		yStart = (int)(Math.random()*(frameHeight-2));
		angle = (int)(Math.random()*360);
		
		p2 = new CurvePlayer(xStart, yStart, Color.blue, right2, left2, angle);
		setBindings(p2, "p2");
		alive ++;
		playerList.add(p2);
		
		xStart = (int)(Math.random()*(frameWidth-2));
		yStart = (int)(Math.random()*(frameHeight-2));
		angle = (int)(Math.random()*360);
		
		p3 = new CurvePlayer(xStart, yStart, Color.green, right3, left3, angle);
		setBindings(p3, "p3");
		alive ++;
		playerList.add(p3);
		
		xStart = (int)(Math.random()*(frameWidth-2));
		yStart = (int)(Math.random()*(frameHeight-2));
		angle = (int)(Math.random()*360);
		
		p4 = new CurvePlayer(xStart, yStart, Color.cyan, right4, left4, angle);
		setBindings(p4, "p4");
		alive ++;
		playerList.add(p4);
		
		if(numOfPlayers<4)
		{
			p4.active = false;
			alive--;
			playerList.remove(p4);
		}
		if(numOfPlayers<3)
		{
			p3.active = false;
			alive--;
			playerList.remove(p3);
		}
		if(numOfPlayers<2)
		{
			p2.active = false;
			alive--;
			playerList.remove(p2);
		}
		
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
		
		for(CurvePlayer p: playerList)
		{
			p.drawPlayer(g);
		}
		
		if(alive < 2)
		{
			if(p1.active)
			{
				ending(g, "P1 WINS!", Color.RED);
			}
			else if(p2.active)
			{
				ending(g, "P2 WINS!", Color.blue);
			}
			else if(p3.active)
			{
				ending(g, "P3 WINS!", Color.green);
			}
			else if(p4.active)
			{
				ending(g, "P4 WINS!", Color.cyan);
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
	
	public void ending(Graphics g, String str, Color c)
	{
		Font stringFont = new Font("a", Font.BOLD, 35);
		int sx = frame.getWidth() / 2 - g.getFontMetrics(stringFont).stringWidth(str) / 2;
		int sy = frame.getHeight()/2;
		g.setColor(c);
		g.setFont(stringFont);
		g.drawString(str, sx, sy);
		update.stop();
	}
	
	private class TimerAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			for(CurvePlayer p: playerList)
			{
				if(p.active)
				{
					p.updatePlayer();
					
					double px = p.getHead().getX(), py =  p.getHead().getY();
					Rectangle2D ph = p.getHead();
					
					if((px > frame.getWidth() || py > frame.getHeight() || py < 0 || px < 0))
					{
						p.active = false;
						alive--;
					}
					
					for(CurvePlayer p2: playerList)
					{
						if(playerList.indexOf(p) == playerList.indexOf(p2))
						{
							
						}
					}
				}
			}
			
			
			Rectangle2D p1h = p1.getHead(), p2h = p2.getHead(), p3h = p3.getHead(), p4h = p4.getHead();
		
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
				if(i < p3.getPoints().size()-10 && p3h.intersects(p3.getPoints().get(i)) && p3.active)
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
				if(i < p4.getPoints().size()-10 && p4h.intersects(p4.getPoints().get(i)) && p4.active)
				{
					alive--;
					p4.active = false;
				}	
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
