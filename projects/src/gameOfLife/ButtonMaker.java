package gameOfLife;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonMaker {

	private JButton b = new JButton();
	
	public ButtonMaker(String side, String name, Color color, JPanel p, ActionListener action)
	{
		b.setBackground(color);
		b.setText(name);
		b.addActionListener(action);
		p.add(b, side);
	}
	
	public JButton getB()
	{
		return b;
	}
}
