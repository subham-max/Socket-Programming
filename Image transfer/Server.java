import java.net.*;
import java.io.*;
class Server
{
	public static void main(String[] args)
	{
			
		try
			{
				System.out.println("Server Started");
				ServerSocket srvr= new ServerSocket(1234);
				Socket skt= srvr.accept();
				System.out.println("Client-Server connection established\n");
				
				System.out.print("Enter the input file name / path (including extension), to be copied from: ");
				BufferedReader brconsole= new BufferedReader(new InputStreamReader(System.in));
				String ifile= brconsole.readLine();
				FileInputStream fis= new FileInputStream(ifile);
					
				BufferedOutputStream bossocket= new BufferedOutputStream(skt.getOutputStream());
			
				int i= 0;
				while(true)
				{
					i= fis.read();
					if(i==-1)
						break;
					bossocket.write((char)i);
				}
				
				bossocket.close();
				fis.close();
				skt.close();		
				srvr.close();
			}
			catch(Exception e)
			{
				System.out.println("ERROR: "+e.getMessage());
			}
	}
}
