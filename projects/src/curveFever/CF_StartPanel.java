package curveFever;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CF_StartPanel extends JPanel{

	private JButton selectedButton = null;
	
	public CF_StartPanel(CF frame)
	{
		setBackground(Color.black);
		setLayout(new GridLayout(3, 3));
		JPanel panel = this;
		
		JLabel p1 = new JLabel("p1", JLabel.CENTER);
		p1.setForeground(Color.red);
		p1.setFont(new Font("a", Font.BOLD, 35));
		JLabel p2 = new JLabel("p2", JLabel.CENTER);
		p2.setForeground(Color.blue);
		p2.setFont(new Font("a", Font.BOLD, 35));
		JLabel blank = new JLabel();
		
		JButton p1l = new JButton(); 
		p1l.setForeground(Color.red);
		p1l.setFont(new Font("a", Font.BOLD, 30));
		p1l.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedButton != p1l)
				{
					if(selectedButton != null)
						selectedButton.setBackground(Color.black);
					
					selectedButton = p1l;
					p1l.setBackground(Color.RED);
				}
				else
				{
					selectedButton = null;
					p1l.setBackground(Color.BLACK);
				}
				getTopLevelAncestor().requestFocus();
			}
		});
		
		JButton p1r = new JButton(); 
		p1r.setForeground(Color.red);
		p1r.setFont(new Font("a", Font.BOLD, 30));
		p1r.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedButton != p1r)
				{
					if(selectedButton != null)
						selectedButton.setBackground(Color.black);
					
					selectedButton = p1r;
					p1r.setBackground(Color.red);
				}
				else
				{
					selectedButton = null;
					p1r.setBackground(Color.BLACK);
				}
				getTopLevelAncestor().requestFocus();
			}
		});
		
		JButton p2l = new JButton(); 
		p2l.setForeground(Color.blue);
		p2l.setFont(new Font("a", Font.BOLD, 30));
		p2l.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedButton != p2l)
				{
					if(selectedButton != null)
						selectedButton.setBackground(Color.black);
					
					selectedButton = p2l;
					p2l.setBackground(Color.blue);
				}
				else
				{
					selectedButton = null;
					p2l.setBackground(Color.BLACK);
				}
				getTopLevelAncestor().requestFocus();
			}
		});
		
		JButton p2r = new JButton();
		p2r.setForeground(Color.blue);
		p2r.setFont(new Font("a", Font.BOLD, 30));
		p2r.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedButton != p2r)
				{
					if(selectedButton != null)
						selectedButton.setBackground(Color.black);
					
					selectedButton = p2r;
					p2r.setBackground(Color.blue);
				}
				else
				{
					selectedButton = null;
					p2r.setBackground(Color.BLACK);
				}
				getTopLevelAncestor().requestFocus();
			}
		});
		
		JButton start = new JButton("start");
		start.setBackground(Color.yellow);
		start.setFont(new Font("a", Font.BOLD, 30));
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				frame.add(new CF_Panel(frame, p1l.getText(), p1r.getText(), p2l.getText(), p2r.getText()));
				frame.validate();
			}
		});
		
		
		add(p1);
		add(p1l);
		add(p1r);
		add(p2);
		add(p2l);
		add(p2r);
		add(blank);
		add(start);
		frame.addKeyListener(new KeyAction());
	}

	class KeyAction implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent e) {
			if(selectedButton != null)
			{
				selectedButton.setText(KeyEvent.getKeyText(e.getKeyCode()));
				selectedButton.setBackground(Color.black);
				selectedButton = null;
			}
				
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
		
	}
}
