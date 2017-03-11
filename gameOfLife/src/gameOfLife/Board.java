package gameOfLife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JFrame{
	
	private static ArrayList<JButton> cellGrid = new ArrayList<JButton>();
	private static JLabel gen = new JLabel();
	private static int check = 0;
	private static int SIZE;
	private static boolean isPrevious = true;
	
	private static Timer tm = new Timer(1000, new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			Life.setCells(Life.next_gen(Life.getCells()));
			cellsToBoard();
			setText();
		}
	});

	public Board()
	{
		SIZE = Life.SIZE;
		
		setResizable(false);
		setTitle("Game Of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel grid = new JPanel();
		grid.setPreferredSize(new Dimension(400,400));
		grid.setLayout(new GridLayout(SIZE,SIZE));
		
		fillCellGrid(SIZE*SIZE, grid);
		
		grid.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed A"), "aPressed");
		grid.getActionMap().put("aPressed", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				check = 1;
			}
		});
		
		grid.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "aReleased");
		grid.getActionMap().put("aReleased", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				check = 0;
			}
		});
		
		grid.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed S"), "sPressed");
		grid.getActionMap().put("sPressed", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				check = 2;
			}
		});
		
		grid.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "sReleased");
		grid.getActionMap().put("sReleased", new AbstractAction(){
			public void actionPerformed(ActionEvent e){
				check = 0;
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));
		
		new ButtonMaker(null ,"start", null, buttonPanel, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(tm.isRunning())
					tm.stop();
				else
					tm.start();
			}
		});
		
		new ButtonMaker(null, "previous", null, buttonPanel, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Life.getGenNum() > 1 && !isPrevious)
				{
					if(tm.isRunning())
						tm.stop();
					
					Life.setCells(Life.getPreviousGen());
					cellsToBoard();
					Life.setGenNum(Life.getGenNum()-1);
					setText();
					
					isPrevious = true;
				}
			}
		});
		
		new ButtonMaker(null, "next", null, buttonPanel, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Life.setCells(Life.next_gen(Life.getCells()));
				cellsToBoard();
				setText();
			}
		});
		
		new ButtonMaker(null, "clear", null, buttonPanel, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clearBoard();
				Life.setGenNum(1);
				setText();
				
				if(tm.isRunning())
					tm.stop();
			}
		});
		
		
		JPanel textPanel = new JPanel(); 
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));
		
		gen.setFont(new Font("Arial", Font.PLAIN, 20));
		textPanel.add(gen);
		
		add(grid, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		add(textPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}
	
	public static void cellsToBoard()
	{	
		for(int i=1; i<SIZE+1; i++)
		{
			for(int k=1; k<SIZE+1; k++)
			{	
				cellGrid.get((i-1)*SIZE + k-1).setBackground(Color.gray);
				if(Life.getCells()[i][k] == "1")
				{
					cellGrid.get((i-1)*SIZE + k-1).setBackground(Color.yellow);
				}
			}
		}
	}
	
	public static void boardToCells()
	{
		String[][] newCells = Life.getCells();
		
		for(int i=1; i<SIZE+1; i++)
		{
			for(int k=1; k<SIZE+1; k++)
			{	
				if(cellGrid.get((i-1)*SIZE + k-1).getBackground().equals(Color.yellow))
					newCells[i][k] = "1";
				else
					newCells[i][k] = "0";
			}
		}
		
		Life.setCells(newCells);
	}
	
	public static void clearBoard()
	{
		for(int i=1; i<SIZE+1; i++)
		{
			for(int k=1; k<SIZE+1; k++)
			{
				cellGrid.get((i-1)*SIZE + k-1).setBackground(Color.gray);
			}
		}
		boardToCells();
	}
	
	public static void setText()
	{
		gen.setText("generation: " + Life.getGenNum());
	}
	
	public static void fillCellGrid(int cellNum, JPanel p)
	{
		int i = 0;
		while(i < cellNum)
		{
			ButtonMaker b = new ButtonMaker(null, null, Color.gray, p, new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(((JComponent)e.getSource()).getBackground().equals(Color.yellow))
						((JComponent)e.getSource()).setBackground(Color.gray);
					else
						((JComponent)e.getSource()).setBackground(Color.yellow);
					boardToCells();
					}
				});
			
			cellGrid.add(b.getB());
			cellGrid.get(i).addMouseListener(new MouseMove());
			i++;
		}
		
	}
	
	public static void setIsPrevious(boolean state)
	{
		isPrevious = state;
	}
	
	static class MouseMove implements MouseListener{

		@Override
		public void mouseEntered(MouseEvent e) {
			switch(check)
			{
			case 1:
				((JComponent) e.getSource()).setBackground(Color.yellow);
				break;
			case 2:
				((JComponent) e.getSource()).setBackground(Color.gray);
				break;
			}
			
			boardToCells();
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}	
	}
}
