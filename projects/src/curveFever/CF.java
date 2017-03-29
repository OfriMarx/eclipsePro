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
				
		CF_Panel panel = new CF_Panel(this);
		add(panel);
	}
	
	public static void main(String[] args) {
		new CF();
	}

}
