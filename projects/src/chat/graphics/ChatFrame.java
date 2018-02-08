package chat.graphics;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import chat.network.Client;

@SuppressWarnings("serial")
public class ChatFrame extends JFrame{

	private ChatPanel panel;
	
	public ChatFrame(Client c) {
		setTitle("Title?");
		Dimension d = new Dimension(800, 600);
		setSize(d);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter(){ 
			
			@Override
            public void windowClosing(WindowEvent e) {
                dispose();
                c.disconnect();
            }  
        });  
		
		panel = new ChatPanel(c);
		add(panel);
		
		validate();
		
		setVisible(true);
		setAlwaysOnTop(true); 
		setAlwaysOnTop(false);
	}
	
	public void addLine(String s) {
		panel.addLine(s);
	}
}
