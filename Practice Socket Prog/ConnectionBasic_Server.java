import java.io.*;

import java.net.*;

 class ConnectionBasic_Server
{
   public static void main(String args[])
   {
       

       try
       {
           ServerSocket svr= new ServerSocket(1234);

           Socket skt =svr.accept();

           System.out.println("SUBHAM PAUL's 1st socket Program connected");

           skt.close();
      
			svr.close();
       }

       catch(Exception e)
       {
           System.out.println("Unsuccesful");
       }
   }
}