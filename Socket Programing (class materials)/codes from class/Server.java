import java.io.*;

import java.net.*;

class Server

{

	public static void main(String args[])
  
	{
    
		String msg = "Testing...";
    
		try
    
		{
      
			ServerSocket srvr = new ServerSocket(1234);
      
			Socket skt = srvr.accept();
      
			System.out.println("Server has connected");
      				     PrintWriter out = new PrintWriter(skt.getOutputStream(),true);

			System.out.print("Sending String : " + msg + "\n");
			out.print(msg);
      
			out.close();
      
			skt.close();
      
			srvr.close();
    
		}
    
		catch(Exception e)
    
		{	
      
			System.out.println("Unsuccessful!!");
    
		}
  
	
}
}