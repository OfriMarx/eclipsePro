package chat.graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class ChatLogin extends JPanel{

	public ChatLogin() {
		Font f = new Font("a", Font.PLAIN, 25);
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		
		JLabel nLabel = new JLabel("Name:");
		nLabel.setFont(f);
		sl.putConstraint(SpringLayout.EAST, nLabel, 20, SpringLayout.EAST, this);
		JLabel aLabel = new JLabel("Address:");
		aLabel.setFont(f);
		JLabel pLabel = new JLabel("Port:");
		pLabel.setFont(f);
		
		JLabel error = new JLabel("Please fill all details");
		error.setForeground(Color.RED);
		error.setVisible(false);
		
		JTextField nField = new JTextField(20);
		JTextField aField = new JTextField(20);
		JTextField pField = new JTextField(20);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nField.getText().isEmpty() || aField.getText().isEmpty() || pField.getText().isEmpty())
					error.setVisible(true);
				else {
					System.out.println("nice");
				}
			}
		});
		
		add(nLabel);
		add(nField);
		add(aLabel);
		add(aField);
		add(pLabel);
		add(pField);
		add(login);
		add(error);
	}
}
