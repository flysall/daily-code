package myself;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(30000);
		Socket socket = ss.accept();
		PrintStream ps = new PrintStream(socket.getOutputStream());
		ps.println("the first line of server");
		ps.println("the second line of server");
		socket.shutdownOutput();
		System.out.println(socket.isClosed());
		Scanner scan = new Scanner(socket.getInputStream());
		while(scan.hasNextLine()){
			System.out.println(scan.hasNextLine());
		}
		scan.close();
		socket.close();
	}
}
