import java.net.*;

import java.io.*;

 class ConnectionBasic_Client {
    
public static void main(String args[])
{
    try{
        Socket skt= new Socket("Localhost", 1234);
        
        skt.close();

    }

    catch(Exception e)
    {
        System.out.println("Unsuccesful from client");
    }
}
    
}
