package curveFever;

import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CF extends JFrame{

	CF()
	{	
		setTitle("Curvez");						
		setResizable(false);					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());				
		setLocationRelativeTo(null);
		setVisible(true);	
		
		CF_StartPanel startPanel = new CF_StartPanel(this);
		add(startPanel);
		validate();
	}
	
	public static void main(String[] args) {
		new CF();
		
	}

}
