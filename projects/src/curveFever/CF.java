package curveFever;

import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CF extends JFrame{

	private static Scanner sc = new Scanner(System.in);
	
	CF()
	{	
		CF_Panel panel = new CF_Panel(this, sc.next(), sc.next(), sc.next(), sc.next());
		add(panel);
		
		setTitle("Curvez");						
		setResizable(false);					
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());				
		setLocationRelativeTo(null);
		setVisible(true);			
				
		validate();
	}
	
	public static void main(String[] args) {
		new CF();
	}

}
