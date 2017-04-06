package curveFever;

import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CF_StartFrame extends JFrame{

	public CF_StartFrame()
	{
		setTitle("Curvez");						
		setResizable(false);					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());				
		setLocationRelativeTo(null);
		setVisible(true);			
	}
}
