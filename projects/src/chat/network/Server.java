package chat.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server{
	
	public static Scanner sc = new Scanner(System.in);
	
	private ServerSocket serverSocket = null;
	private ArrayList<ServerThread> threadList;
	
	public Server(int port) {
		threadList = new ArrayList<>();
		
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("server is running");
			newConnection();
		} catch (Exception e) {
			System.out.println("could not start server");
			e.printStackTrace();
		}
	}

	public void newConnection() {
		ServerThread st = new ServerThread(this, serverSocket, threadList.size());
		threadList.add(st);
		st.start();
	}
	
	public void closeServer() {
		try {
			for(ServerThread st: threadList)
			{
				if(st.isConnected())
					st.disconnect();
			}
				
			
			serverSocket.close();
			System.out.println("server stopped");
		} catch (IOException e) {
			System.out.println("could not stop server");
			e.printStackTrace();
		}
	}
	
	public void closeConnection(int index) {
		if(threadList.get(index).isConnected())
			threadList.get(index).disconnect();
	}
	
	public void send(String message ,int index) {
		threadList.get(index).write(message);
	}
	
	public void sendAll(String message) {
		for(ServerThread st: threadList) {
			if(st.isConnected())
				st.write(message);
		}
	}
	
	public void sendAllExcept(String message, int index) {
		for(int i=0; i<threadList.size(); i++) {
			if(index == i)
				continue;
			if(threadList.get(i).isConnected())
				threadList.get(i).write(message);
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter port (recommended 7444): ");
		int port = Client.sc.nextInt();
		
	    Server s = new Server(port);
	    
	    Client c = new Client("127.0.0.1", port, "Ofri");
	    c.connect();
	    
	    String input = "";
	    while(!input.equals("exit"))
	    	input = sc.nextLine();
	    
	    s.closeServer();
	}
}
