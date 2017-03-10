package spaceShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Main_Panel extends JPanel{

	private Player p1, p2;
	private Timer gameTimer;
	
	public Main_Panel(Main_Frame frame)
	{	
		setBackground(Color.BLACK);
		
		frame.addKeyListener(new KeyAction());
		
		p1 = new Player(50, frame.getHeight()-130, Color.BLUE);
		p2 = new Player(50, 70, Color.red);
		
		gameTimer = new Timer(5, new TimerAction());
		gameTimer.start();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		p1.paintPlayer(g);
		p2.paintPlayer(g);
	}
	
	
	class KeyAction implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			p1.pressed(e.getKeyCode());
			p2.pressed(e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p1.released();
			p2.released();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			//unused
		}
	}
	
	class TimerAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			p1.move();
			p2.move();
			repaint();
		}
		
	}
}
