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

	private ChatPanel chatPanel;
	private ChatSignLogin loginPanel;
	private Color colors[] = {Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.PINK, Color.ORANGE, Color.GRAY};
	private int colorIndex = -1;
	final private int numOfColors = 7;
	public HashMap<String, Color> colorMap = new HashMap<>();
	private Client c;
	private boolean admin = false;
	
	public ChatFrame() {		
		setTitle("Title?");
		Dimension d = new Dimension(800, 600);
		setSize(d);
		setLocationRelativeTo(null);
		colorMap.put("Server", Color.BLACK);
		colorMap.put("Admin", Color.BLACK);
		
		addWindowListener(new WindowAdapter(){ 
			
			@Override
            public void windowClosing(WindowEvent e) {
                dispose();
                if(c != null && c.isConnected())
                	c.disconnect("");
            }  
        });  
		
		loginPanel = new ChatSignLogin(this);
		add(loginPanel);
		
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
		
		chatPanel.addLine(message, nameToColor(name), name.equals("Admin"));
	}
	
	public void connect(String name, String address, int port, boolean admin) {
		this.admin = admin;
		c = new Client(address, port, name, this);
		chatPanel = new ChatPanel(this, c);
		remove(loginPanel);
		add(chatPanel);
		c.connect();
		
		validate();
	}
	
	public void disconnect(String message) {
		chatPanel.getTextField().setEnabled(false);
		addLine("Server: " + message);
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
	
	public boolean isAdmin() {
		return admin;
	}

	public static void main(String[] args) {
		new ChatFrame();
	}
}
