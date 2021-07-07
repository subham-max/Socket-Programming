import java.net.*;
import java.io.*;

class CRadius2
{
	public static void main(String argv[])throws Exception
	{
		
		Socket socket= new Socket("localhost",1234);
		String rad="5";
		System.out.println("SENDING RADIUS OF CIRCLE..." + rad);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		out.println(rad);
	
		System.out.println("RECEIVING AREA OF CIRCLE..");
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String area=in.readLine();
		System.out.println("AREA= " + area);
		out.close();
		in.close();
	}
}
