import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		FileOutputStream fout = null;
		try
		{
		Socket skt = new Socket("localhost", 9999);
		fout = new FileOutputStream(args[0]);
		ObjectInputStream oos = new ObjectInputStream(skt.getInputStream());
		byte[] buffer;
		buffer = (byte[])oos.readObject();
		fout.write(buffer);
		fout.close();
		}
		catch (Exception e) {
		System.out.println("Error!");
	}
}
}