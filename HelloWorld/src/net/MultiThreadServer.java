package net;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

	//Thanks 4621
	
	public static void main(String[] args) throws IOException {
		// create server socket
		int nPort = 3021;
		ServerSocket svrSocket = new ServerSocket(nPort); // run the server;

		// keep listening on port 3021, serve for each req
		Socket clientSocket = null;
		while (true) {
			//System.out.println("Server is ready for new requst...");
			
			// block until TCP connection is established
			clientSocket = svrSocket.accept();

			//System.out.println("Server get a requst, assign to worker...");
			// handle the rest by thread worker
			ThreadHandler worker = new ThreadHandler(clientSocket);
			Thread t = new Thread(worker);
			t.start();
		}
	}

}
