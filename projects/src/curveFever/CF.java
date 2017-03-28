package curveFever;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CF extends JFrame{

	CF()
	{
		setTitle("Curvez");						
		setResizable(false);					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);					
		setLocationRelativeTo(null);
		setVisible(true);			
				
		validate();
	}
	
	public static void main(String[] args) {
		new CF();

	}

}
