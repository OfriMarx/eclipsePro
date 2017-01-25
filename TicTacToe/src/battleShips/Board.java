package battleShips;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame{
	
	Board()
	{
		setSize(600,600);
		setTitle("title");
		setResizable(false);
		
		// setting the frame in the middle of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int h = getSize().height;
		int w = getSize().width;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		setLocation(x,y);
		
		// terminating the program with the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		
		JButton b1 = new JButton();
		b1.setBounds(0, 0, 197, 174);
		b1.setBackground(Color.white);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b1.setBackground(Color.blue);
				b1.setEnabled(false);
			}
		});
		
		p.add(b1);
		add(p);
		
		setVisible(true);
	}
}
