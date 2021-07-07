import java.io.*;

import java.net.*;

class clif

{
	public static void main(String args[]) throws IOException
	{
		try
		{
			int i = 0;
			Socket skt = new Socket("localhost",1234);
			System.out.println("Client has Connection");

			System.out.print("Enter output file name : ");
			
BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			String ofile = br1.readLine();

			FileOutputStream fout = new FileOutputStream(ofile); 
			BufferedInputStream bo = new BufferedInputStream(skt.getInputStream());

			System.out.println("The content copied is :");
			while(true)

			{
				i = bo.read();
				if(i == -1)

					break;
				System.out.print((char)i);

				fout.write((char)i);
			}
			bo.close();
			fout.close();
		}
		catch(Exception e)
		{
			System.out.println("Unsuccessful!!");
		}
	}
}
