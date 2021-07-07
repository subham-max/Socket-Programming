//Write a Java program to send the content of a text file present at the server end to the client end through socket.
 //The client will receive all the lines from the sent file and will create a new file at its own end.
  //The client will also print the longest line only in the console.
 //The names of the text files will be taken as a command line argument at the respective ends.
 
 import java.io.*;

import java.net.*;

class Server
{

	public static void main(String args[])
	{
		try
		{
			int i = 0;
			ServerSocket srvr = new ServerSocket(1234);
			Socket skt = srvr.accept();

			System.out.println("Server has connected");
			System.out.print("Enter input file name : ");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String ifile = br.readLine();
			BufferedReader brfr = new BufferedReader(new FileReader(ifile));
			PrintWriter out = new PrintWriter(skt.getOutputStream(),true);

			String oline = brfr.readLine();
			while(oline!=null)

			{

				out.println(oline);
				out.flush();
				oline = brfr.readLine();
			}
			
out.close();
			brfr.close();

			skt.close();
			srvr.close();
		}
		catch(Exception e)
		{
			System.out.println("Unsuccessful!!");
		}
	}

}

