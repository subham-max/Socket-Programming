import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		FileInputStream fin = null;
		try {
			ServerSocket srvr = new ServerSocket(9999);
			Socket skt = srvr.accept();
			ObjectOutputStream oos = new ObjectOutputStream(skt.getOutputStream());
			fin = new FileInputStream(args[0]);
			byte[] buffer = new byte[fin.available()];
			fin.read(buffer);
			oos.writeObject(buffer);
			fin.close();
			oos.close();
			skt.close();
			srvr.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}