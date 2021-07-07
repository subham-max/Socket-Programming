import java.io.*;

import java.net.*;


class clic

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
      
			FileWriter fw = new FileWriter(ofile);
      
			BufferedReader brs = new BufferedReader(new InputStreamReader(skt.getInputStream()));

			System.out.println("The content copied is :");

      			String iline = brs.readLine();
      
			while(iline!=null)
      
			{
        
				System.out.println(iline);
        
				fw.write(iline + "\n");
        
				iline = brs.readLine();
      
			}
      
			fw.close();

			brs.close();
    
		}
		catch(Exception e)

		{
			System.out.println("Unsuccessful!!");

		}
	}

}
