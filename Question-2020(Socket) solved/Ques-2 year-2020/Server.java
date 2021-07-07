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

			

            FileReader fr =new FileReader(ifile);

            LineNumberReader lr = new LineNumberReader(fr);
            int LineNumberCount=0;
            while(lr.readLine()!=null){
                LineNumberCount++;
            }
            out.println(LineNumberCount);

            BufferedReader brf = new BufferedReader(new FileReader(ifile));
            String oline = brf.readLine();
            
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
