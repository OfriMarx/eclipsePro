package chat.graphics;

import java.awt.Color;
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

	public ChatLogin(ChatFrame frame) {
		Font f = new Font("a", Font.PLAIN, 25);
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		
		//creating labels
		JLabel nLabel = new JLabel("Name:");
		nLabel.setFont(f);
		JLabel aLabel = new JLabel("Address:");
		aLabel.setFont(f);
		JLabel pLabel = new JLabel("Port:");
		pLabel.setFont(f);
		
		JLabel error = new JLabel("");
		error.setForeground(Color.RED);
		
		//rearranging labels
		sl.putConstraint(SpringLayout.NORTH, nLabel, 50, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.EAST, nLabel, -50, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, aLabel, 75, SpringLayout.SOUTH, nLabel);
		sl.putConstraint(SpringLayout.EAST, aLabel, -50, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, pLabel, 75, SpringLayout.SOUTH, aLabel);
		sl.putConstraint(SpringLayout.EAST, pLabel, -50, SpringLayout.HORIZONTAL_CENTER, this);
		
		//creating text fields
		JTextField nField = new JTextField(20);
		JTextField aField = new JTextField(20);
		JTextField pField = new JTextField(20);
		
		//rearranging text fields
		sl.putConstraint(SpringLayout.WEST, nField, 5, SpringLayout.EAST, nLabel);
		sl.putConstraint(SpringLayout.NORTH, nField, 10, SpringLayout.NORTH, nLabel);
		sl.putConstraint(SpringLayout.WEST, aField, 5, SpringLayout.EAST, aLabel);
		sl.putConstraint(SpringLayout.NORTH, aField, 10, SpringLayout.NORTH, aLabel);
		sl.putConstraint(SpringLayout.WEST, pField, 5, SpringLayout.EAST, pLabel);
		sl.putConstraint(SpringLayout.NORTH, pField, 10, SpringLayout.NORTH, pLabel);
		
		//creating button
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nField.getText(), address = aField.getText().trim(), port = pField.getText().trim();
				
				if(name.isEmpty() || address.isEmpty() || port.isEmpty()) 
					error.setText("Please fill all details");
				else if(!isInteger(port)) 
					error.setText("Port should be a number");
				else if(!validAddress(address)) 
					error.setText("address should be: number.number.numbre.number");
				else if(name.equals("Admin") || name.equals("Server"))
					error.setText("Please choose a different name");
				else if(frame.colorMap.containsKey(name))
					error.setText("Name taken");
				else {
					frame.connect(nField.getText(), aField.getText().trim(), Integer.parseInt(pField.getText().trim()));
				}
			}
		});
		
		//rearranging button and error message
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, login, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, login, 75, SpringLayout.SOUTH, pLabel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, error, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, error, 15, SpringLayout.SOUTH, login);
		
		add(nLabel);
		add(nField);
		add(aLabel);
		add(aField);
		add(pLabel);
		add(pField);
		add(login);
		add(error);
	}
	
	private boolean isInteger(String s) {
		if(s.trim().isEmpty())
			return false;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		
		return true;
	}
	
	private boolean validAddress(String address) {
		String[] a = address.split("\\.");
		if(a.length != 4)
			return false;
		
		for(int i=0; i<a.length; i++) {
			if(!isInteger(a[i]))
				return false;
		}
		
		return true;
	}
}
