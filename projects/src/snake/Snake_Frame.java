package snake;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Snake_Frame extends JFrame{

	public Snake_Frame()
	{
		setTitle("Snake");						
		setResizable(false);					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(605,600);					
		setLocationRelativeTo(null);
		setVisible(true);			
		
		Snake_Panel panel = new Snake_Panel(this);
		this.add(panel);	
		
		validate();
	}
	
	public static void main(String[] args) {
		new Snake_Frame();
	}

}
