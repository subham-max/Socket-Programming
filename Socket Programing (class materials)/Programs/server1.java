import java.io.*;

import java.net.*;


class server1

{

	public static void main(String args[])
	{
		String ack = "Server has received the message...";

		try
		{
			ServerSocket srvr = new ServerSocket(1234);
			Socket skt = srvr.accept();
			System.out.println("Server has connected");
			PrintWriter out = new PrintWriter(skt.getOutputStream(),true);

			BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));

			System.out.print("Received String : ");

			System.out.println(br.readLine());
			out.println(ack);
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
