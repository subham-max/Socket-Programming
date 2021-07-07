//Write a socket program which will send a text file from the server to the client 
//when the client sends the message Send me to the server.

import java.io.*;
import java.net.*;
class S2013B1_1a
{
	public static void main(String args[])
	{
		try
		{
			ServerSocket server=new ServerSocket(1234);
			Socket socket=server.accept();
			System.out.println("CONNECTION ESTABLISHED");
			int i;
			for(i=1;i>0;i++)
			{
				String rmsg;
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				rmsg=in.readLine();
			
				if(rmsg.equalsIgnoreCase("SEND")==true)
				{
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
					i=-1;
				}
				else
				{
					PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
					out.println("NEW MESSAGE");
				}
			}
			//out.close();
			//brfr.close();
			socket.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("UNSUCCESSFUL");
		}
	}
}