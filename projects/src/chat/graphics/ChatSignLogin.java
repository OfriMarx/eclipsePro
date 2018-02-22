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

import chat.mysql.SQL;

@SuppressWarnings("serial")
public class ChatSignLogin extends JPanel{

	private JLabel error;
	private SQL sql;
	
	public ChatSignLogin(ChatFrame frame) {
		Font f = new Font("a", Font.PLAIN, 25);
		SpringLayout sl = new SpringLayout();
		setLayout(sl);
		
		//creating labels
		JLabel nLabel = new JLabel("Name:");
		nLabel.setFont(f);
		JLabel aLabel = new JLabel("Address:");
		aLabel.setFont(f);
		JLabel pLabel = new JLabel("Password:");
		pLabel.setFont(f);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		
		//rearranging labels
		sl.putConstraint(SpringLayout.NORTH, nLabel, 50, SpringLayout.NORTH, this);
		sl.putConstraint(SpringLayout.EAST, nLabel, -50, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, pLabel, 75, SpringLayout.SOUTH, nLabel);
		sl.putConstraint(SpringLayout.EAST, pLabel, -50, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, aLabel, 75, SpringLayout.SOUTH, pLabel);
		sl.putConstraint(SpringLayout.EAST, aLabel, -50, SpringLayout.HORIZONTAL_CENTER, this);
		
		//creating text fields
		JTextField nField = new JTextField(20);
		JTextField aField = new JTextField(20);
		JTextField pField = new JTextField(20);
		
		//rearranging text fields
		sl.putConstraint(SpringLayout.WEST, nField, 5, SpringLayout.EAST, nLabel);
		sl.putConstraint(SpringLayout.NORTH, nField, 10, SpringLayout.NORTH, nLabel);
		sl.putConstraint(SpringLayout.WEST, pField, 5, SpringLayout.EAST, pLabel);
		sl.putConstraint(SpringLayout.NORTH, pField, 10, SpringLayout.NORTH, pLabel);
		sl.putConstraint(SpringLayout.WEST, aField, 5, SpringLayout.EAST, aLabel);
		sl.putConstraint(SpringLayout.NORTH, aField, 10, SpringLayout.NORTH, aLabel);
		
		//creating button
		JButton signup = new JButton("Sign up");
		signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nField.getText(), address = aField.getText().trim(), password = pField.getText().trim();
				
				if(validDetails(name, password, address)) {
					if(sql == null)
						sql = new SQL(address);
					
					if(name.equals("Admin") || name.equals("Server")) {
						error.setForeground(Color.RED);
						error.setText("Please choose a different name");
					}
					else if(sql.isTaken(name)) {
						error.setForeground(Color.RED);
						error.setText("Name taken");
					}
					else {
						sql.insertUser(name, password);
						error.setForeground(Color.GREEN);
						error.setText("sign up succeded");
					}
				}
			}
		});
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nField.getText(), address = aField.getText().trim(), password = pField.getText().trim();
				
				if(validDetails(name, password, address)) {
					if(sql == null)
						sql = new SQL(address);
					
					if(!sql.isTaken(name)) {
						error.setForeground(Color.RED);
						error.setText("name is incorrect");
					}
					else if(!sql.getPassword(name).equals(password)) {
						error.setForeground(Color.RED);
						error.setText("password is incorrect");
					}
					else
						frame.connect(name, address, 7444);
						
				}
			}
		});
		
		
		//rearranging button and error message
		sl.putConstraint(SpringLayout.EAST, signup, -30, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, signup, 75, SpringLayout.SOUTH, aLabel);
		sl.putConstraint(SpringLayout.WEST, login, 30, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, login, 75, SpringLayout.SOUTH, aLabel);
		sl.putConstraint(SpringLayout.HORIZONTAL_CENTER, error, 0, SpringLayout.HORIZONTAL_CENTER, this);
		sl.putConstraint(SpringLayout.NORTH, error, 15, SpringLayout.SOUTH, signup);
		
		add(nLabel);
		add(nField);
		add(aLabel);
		add(aField);
		add(pLabel);
		add(pField);
		add(signup);
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
	
	private boolean validDetails(String name, String password, String address) {
		if(name.isEmpty() || address.isEmpty() || password.isEmpty()) {
			error.setForeground(Color.RED);
			error.setText("Please fill all details");
			return false;
		}
		else if(!validAddress(address)) {
			error.setForeground(Color.RED);
			error.setText("address should be: number.number.numbre.number");
			return false;
		}
		
		return true;
	}
}
