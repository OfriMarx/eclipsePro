package spaceShooter;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Space_Frame extends JFrame{

	Space_Frame()
	{
		setTitle("spaze");								//Sets the title of frame
		setResizable(true);								//Makes the frame unresizable
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Sets the close operation to terminate the program
		setExtendedState(JFrame.MAXIMIZED_BOTH);		//Sets the frame's size to max
		setVisible(true);								//Makes the frame visible

		Space_Panel main_panel = new Space_Panel(this);	//Creates a panel
		add(main_panel);								//Adds the panel to frame
		
		validate();										//validate
	}
	
	public static void main(String[] args) {
		new Space_Frame();								//Creates new frame
	}

}
