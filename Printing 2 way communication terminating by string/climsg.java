import java.io.*;

import java.net.*;

class climsg

{
  
	public static void main(String args[]) throws IOException

	{
		try

		{

			String ws="",wc="",t="bye";
			Socket skt = new Socket("localhost",1234);
			System.out.println("Client has Connection");

			PrintWriter outp = new PrintWriter(skt.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));

			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			
			while(true)
      
			{
        
				System.out.print("Received String : ");

				ws = in.readLine();
				System.out.println(ws);

				if(ws.equalsIgnoreCase(t) == true)
				
          break;

			
				System.out.print("Enter a String : ");

				wc = br2.readLine();

			
				System.out.println("Sending String : " + wc);

				outp.println(wc);
			
				if(wc.equalsIgnoreCase(t) == true)
					break;

			}

			outp.close();

			in.close();
		}
 
		catch(Exception e)
    
		{
			System.out.println("Unsuccessful!!");
    
		}
	}

}
