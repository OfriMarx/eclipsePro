package chat.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JFrame;

import chat.network.Client;

@SuppressWarnings("serial")
public class ChatFrame extends JFrame{

	private ChatPanel panel;
	private Color colors[] = {Color.RED, Color.BLUE, Color.GREEN};
	private int colorIndex = -1;
	final private int numOfColors = 3;
	private HashMap<String, Color> colorMap = new HashMap<>();
	
	public ChatFrame(Client c) {
		setTitle("Title?");
		Dimension d = new Dimension(800, 600);
		setSize(d);
		setLocationRelativeTo(null);
		colorMap.put("Server", Color.BLACK);
		
		addWindowListener(new WindowAdapter(){ 
			
			@Override
            public void windowClosing(WindowEvent e) {
                dispose();
                if(c.isConnected())
                	c.disconnect();
            }  
        });  
		
		panel = new ChatPanel(this, c);
		add(panel);
		
		validate();
		
		setVisible(true);
		setAlwaysOnTop(true); 
		setAlwaysOnTop(false);
	}
	
	public void addLine(String message) {
		String name;
		if(message.split(":").length > 1)
			name = message.split(":")[0].trim();
		else
			name = message.split(" ")[0].trim();
		
		panel.addLine(message, nameToColor(name));
	}
	
	public void disconnect() {
		panel.getTextField().setEnabled(false);
		addLine("Server: You have been disconnected");
	}
	
	Color nameToColor(String name) {
		if(colorMap.containsKey(name)) {
			return colorMap.get(name);
		}
		else {
			colorIndex++;
			colorMap.put(name, colors[colorIndex%numOfColors]);
			return colors[colorIndex%numOfColors];
		}
	}
}
