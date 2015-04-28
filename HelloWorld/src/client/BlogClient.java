package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import base.Post;

public class BlogClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;

	public static void main(String[] args){
		try (
			Socket clientSocket = new Socket(IP, PORT);
			PrintWriter out = new PrintWriter(
					clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							clientSocket.getInputStream()));
			BufferedReader stdIn =  new BufferedReader(
					new InputStreamReader(System.in));
		) {
			String userInput = getPost().toString();
			out.println(userInput);
			while ((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
				System.out.println("Client: " + in.readLine());
			}
			in.close(); stdIn.close();
			clientSocket.close();
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + IP);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + IP);
			System.exit(1);
		}
	}
	
	static Post getPost() {
		return new Post(new Date(), "TESTING");
	}
}
