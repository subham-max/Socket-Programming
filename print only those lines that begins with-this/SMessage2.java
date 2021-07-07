//Create a Socket programming in Java to send different messages from the Server to the Client.
//The Client will accept all the strings from the Server and print only
//those lines that begins with "This

import java.io.*;
import java.net.*;

class SMessage2
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket server=new ServerSocket(1234);
			Socket socket=server.accept();
			System.out.println("CONNECTION ESTABLISHED");
			
			String str;
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("ENTER THE FILE NAME>>> ");
			str=br.readLine();
			BufferedReader brfr=new BufferedReader(new FileReader(str));
			
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			String str1=brfr.readLine();
			
			while(str1!=null)
			{
				out.println(str1);
				out.flush();
				str1=brfr.readLine();
			}
			out.close();
			brfr.close();
			socket.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("UNSUCCESSFUL");
		}
	}
}

			