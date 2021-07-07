

import java.io.*;
import java.net.*;

class Client
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
				int n=s.indexOf("These");
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

			