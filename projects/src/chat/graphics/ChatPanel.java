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
	
	private ArrayList<ChatLine> lines = new ArrayList<>();
	private int startLine = 0;
	private JTextField tField = new JTextField(100);
	private JScrollBar scrollBar;
	
	public ChatPanel(ChatFrame f, Client c) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		tField = new JTextField(100);
		tField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addLine(c.getName() + ": " + tField.getText(), f.nameToColor(c.getName()));
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
		
		for(int i=startLine; i<lines.size(); i++) {
			g.setColor(lines.get(i).color);
			g.drawString(lines.get(i).line, x, y);
			y+=20;
		}
	}
	
	public void addLine(String s, Color c) {
		lines.add(new ChatLine(s, c));
		
		int h = getHeight();
		if(lines.size() > h/20-2 && startLine < lines.size() - h/20+2) {
			startLine = lines.size() - h/20+2;
			scrollBar.setValues(startLine, 5, 0, startLine+5);
		}
		
		repaint();
	}

	public JTextField getTextField() {
		return tField;
	}
	
	private class ChatLine {
		
		private String line;
		private Color color;
		
		public ChatLine(String line, Color c) {
			this.line = line;
			this.color = c;
		}
	}
}
