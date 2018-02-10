package chat.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import chat.graphics.ChatFrame;

public class Client {

	public static Scanner sc = new Scanner(System.in);

	private Socket socket;
	private DataOutputStream output;
	private BufferedReader input;
	private String address;
	private int port;
	private boolean connected = false;
	private String name;
	private ChatFrame frame;

	public Client(String address, int port, String name) {
		this.address = address;
		this.port = port;
		this.name = name;
		frame = new ChatFrame(this);
	}

	public void connect() {
		try {
			socket = new Socket(address, port);
			System.out.println("client " + name + ": Connection is made");

			output = new DataOutputStream(socket.getOutputStream());
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			output.writeBytes(" " + name + "\n"); //sending name of client
		} catch(Exception e) {
			System.out.println("client " + name + ": could not connect");
			e.printStackTrace();
		}

		connected = true;

		Runnable clientInput = new Runnable() {

			@Override
			public void run() {
				try {
					String message;
					while(connected && input.read() >= 0) {
						message = input.readLine();
						if(message != null && !message.trim().isEmpty())
							frame.addLine(message);
					}
				} catch (Exception e) {
					System.out.println("client " + name + ": Error in receiving messages"); 
					e.printStackTrace();
				}

				if(connected)
					disconnect();
			}

		};

		Thread t = new Thread(clientInput);
		t.start();
	}

	public void write(String message) {
		if(socket != null && output != null) {
			try {
				output.writeBytes(" " + name + ": " + message + "\n");
				output.flush();
			} catch (Exception e) {
				System.out.println("client " + name + ": Could not write");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("client " + name + ": socket or output is not intialized, could not write");
		}
	}

	public void disconnect() {
		try {
			connected = false;
			socket.shutdownOutput();

			input.close();
			output.close();
			socket.close();
			
			frame.disconnect();

			System.out.println("client " + name + ": Disconnected");
		} catch (IOException e) {
			System.out.println("client " + name + ": could not disconnect");
			e.printStackTrace();
		}
	}

	public boolean isConnected() {
		return connected;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		System.out.print("Enter port: ");
		int port = sc.nextInt();
		
		System.out.println(address + " " + port + " " + name);
		
		//Client c = new Client(address, port, name);
		//c.connect();
	}

}
