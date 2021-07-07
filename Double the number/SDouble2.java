//Input a number from the console in the client side.Send it to the server.
//Server doubles the number and send it back to the client and client prints the double number.

import java.io.*;
import java.net.*;

class SDouble2
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket server=new ServerSocket(1234);
			Socket socket=server.accept();
			System.out.println("CONNECTION ESTABLISHED");
			
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str=in.readLine();
			System.out.println("NUMBER RECEIVED >>>> "+str);
			int num=Integer.parseInt(str);
			int d=2*num;
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			out.println(d);
			in.close();
			out.close();
			server.close();
			socket.close();
		}
		catch(Exception e)
		{
			System.out.println("UNSUCCESSFUL");
		}
	}
}