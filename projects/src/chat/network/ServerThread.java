package chat.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread{

	private Server server;
	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream output;
	private BufferedReader input;
	private boolean connected = false;
	private int id;
	private String name, color;
	
	public ServerThread(Server server, ServerSocket serverSocket, int id, String color) {
		this.serverSocket = serverSocket;
		this.server = server;
		this.id = id;
		this.color = color;
	}
	
	public void disconnect() {
		try {
			connected = false;
			
			socket.shutdownOutput();
			input.close();
			output.close();
			socket.close();
			
			server.sendAllExcept(name + " has disconnected", id);
			
			System.out.println("ServerThread " + id + ": Disconnected");
		} catch (IOException e) {
			System.out.println("ServerThread " + id + ": could not disconnect");
			e.printStackTrace();
		}
	}
	
	public void write(String message) {
		if(socket != null && output != null) {
			try {
				output.writeBytes(" " + message + "." + color + "\n");
				output.flush();
			} catch (Exception e) {
				System.out.println("ServerThread " + id + ": Could not write");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("ServerThread " + id + ": socket or output is not intialized, could not write");
		}
	}
	
	public void start() {
		Runnable threadAction = new Runnable() {
			
			@Override
			public void run() {
				try {
					socket = serverSocket.accept();
					System.out.println("ServerThread " + id + ": Connection is made");
					
					server.newConnection();
					
					output = new DataOutputStream(socket.getOutputStream());
					input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					connected = true;
				} catch(Exception e) {
					System.out.println("ServerThread " + id + ": Could not establish a connection");
					e.printStackTrace();
				}
				
				if(connected) {
					try {
						String message;
						while(connected && input.read() >= 0) {
							message = input.readLine();
							if(message != null)
							{
								if(name == null)
								{
									name = message;
									server.sendAll(name + " has connected");
								}
								else
									server.sendAllExcept(message, id);
							}
						}
					} catch (Exception e) {
						System.out.println("ServerThread " + id + ": Error in receiving messages"); 
						e.printStackTrace();
					}
					
					if(connected)
						disconnect();
				}
			}
		};
		
		Thread t = new Thread(threadAction);
		t.start();
	}

	public boolean isConnected() {
		return connected;
	}
}
