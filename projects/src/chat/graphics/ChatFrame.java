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
                if(c.isConnected())
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
		int r=0,g=0,b=0;
		String line = "";
		String[] message = new String[s.split(".").length];
		
		System.out.println(s);
		System.out.println(s.split(".").length);
		
		for(int i=0; i<s.split(".").length; i++) {
			message[i] = s.split(".")[i];
		}
		
		System.out.println(message.length);
		
		if(message.length > 3)
		{
			b = Integer.parseInt(message[message.length-1]);
			g = Integer.parseInt(message[message.length-2]);
			r = Integer.parseInt(message[message.length-3]);
		}
		
		System.out.println(message.length);

		for(int i=0; i<message.length-3; i++) {
			System.out.println("test");
			line += message[i];
		}
		System.out.println("frame: " + line);
		
		panel.addLine(line, r, g, b);
	}
	
	public void disconnect() {
		panel.getTextField().setEnabled(false);
		addLine("You have been disconnected.0.0.0");
	}
}
