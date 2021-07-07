import java.net.*;
import java.io.*;

class Echo_Client{

    public static void main(String args[]){

        try{
             Socket skt =new Socket("localhost",1234);
             BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Enter the String: ");
             String str= in.readLine();
             PrintWriter out= new PrintWriter(skt.getOutputStream(),true);
             out.println(str);

             skt.close();
        }
        catch(Exception e)
        {
            System.out.println("Unsuccesful from client");
        }
    }
}