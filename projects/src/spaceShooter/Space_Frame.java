package spaceShooter;

import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Space_Frame extends JFrame{

	Space_Frame()
	{
		setTitle("Spaz");								//Sets the title of frame
		setResizable(false);							//Makes the frame unresizable
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Sets the close operation to terminate the program
		setSize(Toolkit.getDefaultToolkit().getScreenSize());//Sets the frame's size to screen size
		setVisible(true);								//Makes the frame visible

		Space_Panel main_panel = new Space_Panel(this);	//Creates a panel
		add(main_panel);								//Adds the panel to frame
		
		validate();
	}
	
	public static void main(String[] args) {
		new Space_Frame();								//Creates new frame
	}

}
