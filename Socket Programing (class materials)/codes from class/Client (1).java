import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args)throws Exception{
		DatagramSocket dc = new DatagramSocket();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter something: ");
		String str = br.readLine();
		byte buffer[] = new byte[str.length()];
		buffer = str.getBytes();
		InetAddress server = InetAddress.getByName("user-PC");
		DatagramPacket pkt = new DatagramPacket(buffer, buffer.length, server, 6666);
		dc.send(pkt);
		dc.close();
	}
}
		