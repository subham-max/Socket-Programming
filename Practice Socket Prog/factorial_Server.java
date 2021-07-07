import java.net.*;
import java.io.*;



 class factorial_Server {
    
    public static void main(String args[]){

        try{
            ServerSocket server= new ServerSocket(1234);
            Socket skt= server.accept();
            System.out.println("Connection Established");
            BufferedReader Clientinput= new BufferedReader(new InputStreamReader(skt.getInputStream()));
            int number= Integer.parseInt(Clientinput.readLine());
            PrintWriter out= new PrintWriter(skt.getOutputStream(),true);
            out.println("Factorial of the number is:" +factorial(number));
            server.close();
            skt.close();
        }
        catch(Exception e){
            System.out.println("Unsuccesful server");
        }
    }

    public static int factorial(int number){
        int i,fact=1;     
        for(i=1;i<=number;i++){    
            fact=fact*i;    
        }   
        return fact; 
    }
}
