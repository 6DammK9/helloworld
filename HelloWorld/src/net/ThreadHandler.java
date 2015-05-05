package net;
import java.net.*;
import java.io.*;
import java.lang.Thread;

public class ThreadHandler implements Runnable {
	private Socket clientSocket;

	public ThreadHandler(Socket soc) {
		clientSocket = soc;
	}

	public void run() {

		long nID = Thread.currentThread().getId() - 10;
		//System.out.println("worker " + nCurrentWorkerID + ": handling req...");
		try {
			PrintWriter out = new PrintWriter(
					clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.equals("visitor")) 
					out.println("You're the " + nID + " visitor today");
				else if (inputLine.equals("quit")) 
					break;
				else
					out.println("echo: " + inputLine);
				//System.out.println(inputLine);
			}
			in.close(); clientSocket.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
