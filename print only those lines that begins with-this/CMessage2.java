//Create a Socket programming in Java to send different messages from the Server to the Client.
//The Client will accept all the strings from the Server and print only
//those lines that begins with "This"

import java.io.*;
import java.net.*;

class CMessage2
{
	public static void main(String args[])
	{
		try
		{
			System.out.println("CLIENT STARTED");
			Socket socket=new Socket("localhost",1234);
			
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s=in.readLine();
			while(s!=null)
			{
				int n=s.indexOf("This");
				if(n>-1)
					System.out.println(s);
				s=in.readLine();
			}
			in.close();
		}
		catch(Exception e)
		{
			System.out.println("UNSUCCESSFUL");
		}
	}
}

			