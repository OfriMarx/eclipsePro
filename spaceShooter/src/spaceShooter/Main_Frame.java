package spaceShooter;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main_Frame extends JFrame{

	Main_Frame()
	{
		setTitle("spaze");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);

		Main_Panel main_panel = new Main_Panel(this);
		add(main_panel);
		
		validate();
	}
	
	public static void main(String[] args) {
		new Main_Frame();

	}

}
