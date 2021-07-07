import java.io.*;

import java.net.*;

class serf

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

			FileInputStream fin = new FileInputStream(ifile);
			BufferedOutputStream bi = new BufferedOutputStream(skt.getOutputStream());
			while(true)
			{
				i = fin.read();
			
        if(i == -1)
					break;
				bi.write((char)i);

			}
			bi.close();
			fin.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e)
		{
			System.out.println("Unsuccessful!!");

		}
	}

}
