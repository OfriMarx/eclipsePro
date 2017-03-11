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
public class Space_Panel extends JPanel{

	private Space_Player p1, p2;
	private Timer gameTimer;
	
	public Space_Panel(Space_Frame frame)
	{	
		setBackground(Color.BLACK);				//Sets background to black
		
		frame.addKeyListener(new KeyAction());	//Adds to frame the key listeners
		
		/*Creates two players*/
		p1 = new Space_Player(50, frame.getHeight()-130, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT, Color.BLUE);
		p2 = new Space_Player(50, 70, KeyEvent.VK_D, KeyEvent.VK_A, Color.red);
		
		gameTimer = new Timer(5, new TimerAction());//Defines the timer with a 5 milliseconds delay and an action 
		gameTimer.start();							//Starts the timer
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		/*Painting the players*/
		super.paintComponent(g);
		p1.paintPlayer(g);
		p2.paintPlayer(g);
	}
	
	/*A class for the key listener actions*/
	class KeyAction implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) { //When a key is pressed
			p1.pressed(e.getKeyCode());
			p2.pressed(e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {//When a key is released
			p1.released(e.getKeyCode());
			p2.released(e.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent e) {	//unused
			
		}
	}
	
	/*A class for the timer action*/
	class TimerAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			p1.move();
			p2.move();
			repaint(); //calls the paintComponent() method
		}
		
	}
}
