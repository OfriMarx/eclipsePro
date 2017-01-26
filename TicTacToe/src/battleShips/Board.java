package battleShips;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame{
	
	public static LinkedList<String> list = new LinkedList<String>();
	public static boolean PlayerTurn = true;
	
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
		
		// buttons
		JButton b1 = new JButton();
		b1.setBounds(0, 0, 197, 174);
		b1.setBackground(Color.white);
		b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if (PlayerTurn)
			{
				b1.setBackground(Color.blue);
				list.set(0, "X");
				CheckBoard(list, "X", p);
				
				
			}	
			else
			{
				b1.setBackground(Color.red);
				list.set(0, "O");
				CheckBoard(list, "O", p);
			}
				PlayerTurn = !PlayerTurn;
				b1.setEnabled(false);
			}
		});
		JButton b2 = new JButton();
		b2.setBounds(0, 174, 197, 200);
		b2.setBackground(Color.white);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b2.setBackground(Color.blue);
					list.set(1, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b2.setBackground(Color.red);
					list.set(1, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b2.setEnabled(false);
			}
		});
		JButton b3 = new JButton();
		b3.setBounds(0, 374, 197, 200);
		b3.setBackground(Color.white);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b3.setBackground(Color.blue);
					list.set(2, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b3.setBackground(Color.red);
					list.set(2, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b3.setEnabled(false);
			}
		});
		JButton b4 = new JButton();
		b4.setBounds(197, 0, 200, 174);
		b4.setBackground(Color.white);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b4.setBackground(Color.blue);
					list.set(3, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b4.setBackground(Color.red);
					list.set(3, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b4.setEnabled(false);
			}
		});
		JButton b5 = new JButton();
		b5.setBounds(197, 174, 200, 200);
		b5.setBackground(Color.white);
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b5.setBackground(Color.blue);
					list.set(4, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b5.setBackground(Color.red);
					list.set(4, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b5.setEnabled(false);
			}
		});
		JButton b6 = new JButton();
		b6.setBounds(197, 374, 200, 200);
		b6.setBackground(Color.white);
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b6.setBackground(Color.blue);
					list.set(5, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b6.setBackground(Color.red);
					list.set(5, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b6.setEnabled(false);
			}
		});
		JButton b7 = new JButton();
		b7.setBounds(397, 0, 200, 174);
		b7.setBackground(Color.white);
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b7.setBackground(Color.blue);
					list.set(6, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b7.setBackground(Color.red);
					list.set(6, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b7.setEnabled(false);
			}
		});
		JButton b8 = new JButton();
		b8.setBounds(397, 174, 200, 200);
		b8.setBackground(Color.white);
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b8.setBackground(Color.blue);
					list.set(7, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b8.setBackground(Color.red);
					list.set(7, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b8.setEnabled(false);
			}
		});
		JButton b9 = new JButton();
		b9.setBounds(397, 374, 200, 200);
		b9.setBackground(Color.white);
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (PlayerTurn)
				{
					b9.setBackground(Color.blue);
					list.set(8, "X");
					CheckBoard(list, "X", p);
					
				}	
				else
				{
					b9.setBackground(Color.red);
					list.set(8, "O");
					CheckBoard(list, "O", p);
				}
				PlayerTurn = !PlayerTurn;
				b9.setEnabled(false);
			}
		});
			
		p.add(b1);
		p.add(b3);
		p.add(b2);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		add(p);
						
		
		setVisible(true);
	}
	
	public static void CheckBoard(LinkedList<String> board, String sign, JPanel panel)
	{
		if (board.get(0)== sign && board.get(1)== sign && board.get(2)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
		else if (board.get(3)== sign && board.get(4)== sign && board.get(5)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
		else if (board.get(6)== sign && board.get(7)== sign && board.get(8)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
		else if (board.get(0)== sign && board.get(3)== sign && board.get(6)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
		else if (board.get(1)== sign && board.get(4)== sign && board.get(7)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
		else if (board.get(2)== sign && board.get(5)== sign && board.get(8)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
		else if (board.get(0)== sign && board.get(4)== sign && board.get(8)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
		else if (board.get(2)== sign && board.get(4)== sign && board.get(6)== sign)
		{
			panel.setEnabled(false);
			System.out.println(sign + " win");
		}
	}
}
