package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final int PORT = 3021;

	public static void main(String[] args) {

		try (
			ServerSocket svrSocket = new ServerSocket(PORT); 
			Socket clientSocket = svrSocket.accept();
			PrintWriter out = new PrintWriter(
					clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			){
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					out.println(inputLine);
					System.out.println(inputLine);
				}
		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + PORT +
					" or listening for a connection");
			System.out.println(e.getMessage());
		} 
		
	}
}

