import java.io.*;
import java.net.Socket;


 class factorial_Client {
    

public static void main(String args[]){

    try{
        Socket skt= new Socket("localhost", 1234);
        System.out.println("Connection established");
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number: ");
        int number =Integer.parseInt(input.readLine());
        PrintWriter out= new PrintWriter(skt.getOutputStream(),true);
        out.println(number);

        BufferedReader Serveroutput= new BufferedReader(new InputStreamReader(skt.getInputStream()));
        System.out.println(Serveroutput.readLine());
        
        skt.close();
    }
    catch(Exception e){
        System.out.println("Unsuccesful client");
    }

}
}