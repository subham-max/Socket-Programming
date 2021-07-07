import java.io.*;

import java.net.*;

class sermsg

{
	public static void main(String args[]) throws IOException
	{
		try
		{
			String ws="",wc="",t="bye";
			ServerSocket srvr = new ServerSocket(1234);

			Socket skt = srvr.accept();

			System.out.println("Server has connected");
			PrintWriter out = new PrintWriter(skt.getOutputStream(),true);

			BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.print("Enter a String : ");
				ws = br1.readLine();
				System.out.println("Sending String : " + ws);
				out.println(ws);
				if(ws.equalsIgnoreCase(t) == true)

					break;

				System.out.print("Received String : ");
				wc = br.readLine();
				System.out.println(wc);

				if(wc.equalsIgnoreCase(t) == true)

					break;
			}
			br.close();
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
