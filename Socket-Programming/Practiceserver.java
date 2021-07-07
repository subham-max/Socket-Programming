import java.net.*;
import java.io.*;

public class Practiceserver {
	public static void main(String[] args) throws IndexOutOfBoundsException {
		ServerSocket ss = new Serversocket(4999);
		Socket s = ss.accept();

		System.out.println("client connected");
	}

}