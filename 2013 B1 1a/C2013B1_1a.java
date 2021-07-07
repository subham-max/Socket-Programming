//Write a socket program which will send a text file from the server to the client 
//when the client sends the message Send me to the server.

import java.io.*;
import java.net.*;
class C2013B1_1a
{
	public static void main(String args[])throws IOException
	{
		try
		{
			System.out.println("CLIENT STARTED");
			Socket socket=new Socket("localhost",1234);
			
			int i;
			for(i=1;i>0;i++)
			{	
				String msg,rmsg;
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				System.out.print("ENTER YOUR MESSAGE, CLIENT.........");
				msg=br.readLine();
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				out.println(msg);
			
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				rmsg=in.readLine();
	
				if(rmsg.equalsIgnoreCase("New Message")==true)
					continue;
				else
				{
					System.out.println("The content of the file is :");
					while(rmsg!=null)
					{
						System.out.println(rmsg);
						rmsg=in.readLine();
					}
					i=-1;
				}
			}
			//in.close();
		}
		catch(Exception e)
		{
			System.out.println("UNSUCCESSFUL");
		}
	}
}
			
			
			