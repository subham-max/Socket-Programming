//Input a number from the console in the client side.Send it to the server.
//Server doubles the number and send it back to the client and client prints the double number.

import java.io.*;
import java.net.*;

class CDouble2
{
	public static void main(String args[])
	{
		try
		{
			System.out.println("CLIENT STARTED");
			Socket socket=new Socket("localhost",1234);
			
			String n;
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("ENTER THE NUMBER:    ");
			n=br.readLine();
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			out.println(n);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s=in.readLine();
			System.out.println("THE RECEIVED DOUBLED NUMBER IS>>>>> "+s);
			in.close();
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("UNSUCCESSFUL");
		}
	}
}
		