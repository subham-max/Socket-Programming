import java.net.*;
import java.io.*;



 class Server {
    
    public static void main(String args[]){

        try{
            ServerSocket server= new ServerSocket(1234);
            Socket skt= server.accept();
            System.out.println("Connection Established");
            BufferedReader Clientinput= new BufferedReader(new InputStreamReader(skt.getInputStream()));
            int array[]= new int[5];
            for(int i=0;i<5;i++){
                 array[i]= Integer.parseInt(Clientinput.readLine());
            }
            
            PrintWriter out= new PrintWriter(skt.getOutputStream(),true);
            out.println("The largest number is:" +largest(array));
            server.close();
            skt.close();
        }
        catch(Exception e){
            System.out.println("Unsuccesful server");
        }
    }

    static int largest(int array[])
    {
        int i;
     
        int max = array[0];
      
        for (i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
      
        return max;
    }
     
}
