import java.io.*;
import java.net.Socket;


 class c {
    

public static void main(String args[]){

    try{
        Socket skt= new Socket("localhost", 1234);
        System.out.println("Connection established");
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        int array[]= new int[5];
        for(int i=0;i<5;i++)
        {
            System.out.println("Enter the " + i+1 +" value: ");
            array[i]=Integer.parseInt(input.readLine());
        }
        PrintWriter out= new PrintWriter(skt.getOutputStream(),true);

        for(int i=0;i<5;i++)
        {
            out.println(array[i]);
        }
        

        BufferedReader Serveroutput= new BufferedReader(new InputStreamReader(skt.getInputStream()));
        System.out.println(Serveroutput.readLine());
        
        skt.close();
    }
    catch(Exception e){
        System.out.println("Unsuccesful client");
    }

}
}
