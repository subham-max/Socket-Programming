import java.net.*;
import java.io.*;

class Echo_Server{

    public static void main(String args[]){

try{


        ServerSocket svr= new ServerSocket(1234);
        Socket skt= svr.accept();
        System.out.println("Connection established");

        BufferedReader Clientinput= new BufferedReader(new InputStreamReader(skt.getInputStream()));
        //PrintWriter out= new PrintWriter(skt.getOutputStream(),true);
        System.out.println("Server Echo's Clients String:"+ Clientinput.readLine());

        
        svr.close();
        skt.close();

    
}
catch(Exception e)
{
    System.out.println("Unsuccesful from server");
}

    }
}