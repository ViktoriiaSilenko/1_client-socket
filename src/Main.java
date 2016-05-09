
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {

		System.out.println("client socket run");

		try (Socket socket = new Socket("127.0.0.1", 4040); 
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();) {

			// Socket socket = new Socket("localhost", 4040); or
			// Socket socket = new Socket("127.0.0.1", 4040); // client tcp socket

			
			
			PrintStream writer = new PrintStream(os, true);
			
			BufferedReader consoleReader = new BufferedReader(
					new InputStreamReader(System.in));
			
			BufferedReader socketReader = new BufferedReader(
					new InputStreamReader(is));
			
			//while (true) {
				String input = consoleReader.readLine();
				System.out.println("send to a server: " + input);
				
				writer.println(input); // send to server
				
				
				// os.write("Hello".getBytes()); // send data (bytes) to server
				// os.flush();
				
				/*if ("exit".equals(input)) {
					break;
				}*/
				
				String output = socketReader.readLine(); // receive from server
				System.out.println("receive from a server: " + output);
				
				
				
				
			//}

			

		} catch (IOException ex) {
			System.out.println(ex.getMessage() + " in " + "client socket main");

		}

	}

}
