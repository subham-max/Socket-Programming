import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args)throws Exception{
		DatagramSocket ds = new DatagramSocket(6666);
		byte[] buffer = new byte[65536];
		DatagramPacket pkt = new DatagramPacket(buffer, buffer.length);
		ds.receive(pkt);
		String str = new String(pkt.getData(), 0, pkt.getLength());
		System.out.println(str);
		ds.close();
	}
}