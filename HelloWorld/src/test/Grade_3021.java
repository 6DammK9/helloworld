package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Grade_3021 {
	public static void main(String args[]) throws Exception{

		String hostName = "msr.cse.ust.hk";
		String id = "20113451";
		int portNumber = 3021;
		
		try(
				Socket echoSocket = new Socket(hostName, portNumber);
				DataOutputStream out =
						new DataOutputStream(echoSocket.getOutputStream());
				DataInputStream in = 
						new DataInputStream(echoSocket.getInputStream());												
		) {
			out.writeUTF(id);
			System.out.println(in.readUTF());
			
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to " + hostName);
			System.exit(1);
		}
	}
}
