package chat.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

import chat.network.Client;

@SuppressWarnings("serial")
public class ChatPanel extends JPanel{
	
	private ArrayList<String> lines = new ArrayList<>();
	private int startLine = 0;
	private JScrollBar scrollBar;
	
	public ChatPanel(Client c) {
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		
		JTextField tField = new JTextField(100);
		tField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addLine(c.getName() + ": " + tField.getText());
				c.write(tField.getText());
				tField.setText("");
			}
		});
		tField.setPreferredSize(new Dimension(0, 30));
		tField.setFont(new Font("a", Font.PLAIN, 20));
		
		scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 0, 0, 0);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				startLine = e.getValue();
				repaint();
			}
		});
		
		add(tField, BorderLayout.SOUTH);
		add(scrollBar, BorderLayout.EAST);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x=5, y=20;
		Font f = new Font("a", Font.PLAIN, 20);
		g.setFont(f);
		g.setColor(Color.GREEN);
		
		for(int i=startLine; i<lines.size(); i++) {
			g.drawString(lines.get(i), x, y);
			y+=20;
		}
	}
	
	public void addLine(String s) {
		lines.add(s);
		
		int h = getHeight();
		if(lines.size() > h/20-2 && startLine < lines.size() - h/20+2) {
			startLine = lines.size() - h/20+2;
			scrollBar.setValues(startLine, 5, 0, startLine+5);
		}
		
		repaint();
	}
}
