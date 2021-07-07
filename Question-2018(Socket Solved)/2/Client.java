//Write a Java program to send the content of a text file present at the server end to the client end through socket.
 //The client will receive all the lines from the sent file and will create a new file at its own end.
  //The client will also print the longest line only in the console.
 //The names of the text files will be taken as a command line argument at the respective ends.
 
 import java.io.*;

import java.net.*;


class Client

{
  
	public static void main(String args[]) throws IOException
  
	{
        String longestline = new String();

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

      			String iline = brs.readLine();
      
			while(iline!=null)
      
			{

                if(longestline.length() < iline.length()){
                    longestline=iline;
                }
        
				iline = brs.readLine();
      
			}
            System.out.println("Longest Line in the file is:  "+ longestline);
      
			fw.close();

			brs.close();
    
		}
		catch(Exception e)

		{
			System.out.println("Unsuccessful!!");

		}
	}

}
