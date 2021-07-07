import java.net.*;
import java.io.*;
class Client
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Client Started\n");
			Socket skt= new Socket("localhost",1234);
			
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
			skt.close();
		}
		catch(Exception e)
		{
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
