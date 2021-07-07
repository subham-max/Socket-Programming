import java.io.*;
import java.net.*;



public class Basic_Client {
    public static void main(String args[]){
    try{
        Socket skt = new Socket ("localhost", 1234);
        BufferedReader br= new BufferedReader(new InputStreamReader(skt.getInputStream()));
        System.out.println(br.readLine());
        skt.close();
    }
    catch(Exception e){
        System.out.println("Unsuccesful");
    }
}
}
