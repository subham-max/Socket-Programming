import java.io.*;

import java.net.*;

class client1

{
  
	public static void main(String args[])
  
	{
    
		String msg = "Today is Friday...";
    
		try
    
		{
      
			Socket skt = new Socket("localhost",1234);
      
		    	PrintWriter outp = new PrintWriter(skt.getOutputStream(),true);

			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.println("Sending String : " + msg);

			outp.println(msg);

			System.out.println(in.readLine());

			outp.close();
			in.close();

		}

		catch(Exception e)
    
		{
      
			System.out.println("Unsuccessful!!");
    
		}
	}
}
