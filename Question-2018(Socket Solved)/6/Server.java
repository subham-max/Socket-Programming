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
				
				System.out.print("Enter the output file name / path (including extension), to be copied into: ");
			BufferedReader brconsole= new BufferedReader(new InputStreamReader(System.in));
			String ofile= brconsole.readLine();
		
			FileOutputStream fos= new FileOutputStream(ofile);
			BufferedInputStream bissocket= new BufferedInputStream(skt.getInputStream());
			int i;
				
			while(true)
			{
				i= bissocket.read();
				if (i==-1)
					break;
				fos.write((char)i);
			}
			System.out.println("\n'"+ofile+"' file created with copied contents");
			
			bissocket.close();
			fos.close();
			srvr.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}

