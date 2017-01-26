package battleShips;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame{
	
	public static LinkedList<String> list = new LinkedList<String>();
	private static LinkedList<JButton> buttonList = new LinkedList<JButton>();
	public static boolean PlayerTurn = true;
	
	Board()
	{
		setSize(600,600);
		setTitle("Tic Tac Toe");
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
			PlayerTurn = turn(0, PlayerTurn, b1, list);
			}
		});
		JButton b2 = new JButton();
		b2.setBounds(0, 174, 197, 200);
		b2.setBackground(Color.white);
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(1, PlayerTurn, b2, list);
			}
		});
		JButton b3 = new JButton();
		b3.setBounds(0, 374, 197, 200);
		b3.setBackground(Color.white);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(2, PlayerTurn, b3, list);
			}
		});
		JButton b4 = new JButton();
		b4.setBounds(197, 0, 200, 174);
		b4.setBackground(Color.white);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(3, PlayerTurn, b4, list);
			}
		});
		JButton b5 = new JButton();
		b5.setBounds(197, 174, 200, 200);
		b5.setBackground(Color.white);
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(4, PlayerTurn, b5, list);
			}
		});
		JButton b6 = new JButton();
		b6.setBounds(197, 374, 200, 200);
		b6.setBackground(Color.white);
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(5, PlayerTurn, b6, list);
			}
		});
		JButton b7 = new JButton();
		b7.setBounds(397, 0, 200, 174);
		b7.setBackground(Color.white);
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(6, PlayerTurn, b7, list);
			}
		});
		JButton b8 = new JButton();
		b8.setBounds(397, 174, 200, 200);
		b8.setBackground(Color.white);
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(7, PlayerTurn, b8, list);
			}
		});
		JButton b9 = new JButton();
		b9.setBounds(397, 374, 200, 200);
		b9.setBackground(Color.white);
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayerTurn = turn(8, PlayerTurn, b9, list);
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
		
		buttonList.add(b1);
		buttonList.add(b2);
		buttonList.add(b3);
		buttonList.add(b4);
		buttonList.add(b5);
		buttonList.add(b6);
		buttonList.add(b7);
		buttonList.add(b8);
		buttonList.add(b9);
	}
	
	public static void CheckBoard(LinkedList<String> board, LinkedList<JButton> list, String sign, boolean check)
	{
		if (board.get(0)== sign && board.get(1)== sign && board.get(2)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
		else if (board.get(3)== sign && board.get(4)== sign && board.get(5)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
		else if (board.get(6)== sign && board.get(7)== sign && board.get(8)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
		else if (board.get(0)== sign && board.get(3)== sign && board.get(6)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
		else if (board.get(1)== sign && board.get(4)== sign && board.get(7)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
		else if (board.get(2)== sign && board.get(5)== sign && board.get(8)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
		else if (board.get(0)== sign && board.get(4)== sign && board.get(8)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
		else if (board.get(2)== sign && board.get(4)== sign && board.get(6)== sign)
		{
			if(sign == "X")
				System.out.println("BLUE WINS!");
			else
				System.out.println("RED WINS!");
			ButtonShutDown(list);
		}
	}
	
	public static boolean turn(int BNumber, boolean pt, JButton b, LinkedList<String> l){
		if(pt)
		{
			b.setBackground(Color.blue);
			l.set(BNumber, "X");
			CheckBoard(l, buttonList, "X", pt);
		}
		else
		{
			b.setBackground(Color.red);
			l.set(BNumber, "O");
			CheckBoard(l, buttonList, "O", pt);
		}
		
		b.setEnabled(false);
		
		return !pt;
	}
	
	public static void ButtonShutDown(LinkedList<JButton> list){
		Iterator<JButton> it = list.iterator();
		
		while(it.hasNext())
		{
			it.next().setEnabled(false);
		}
	}
}
