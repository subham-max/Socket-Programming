import java.net.*;
import java.util.Arrays;
import java.io.*;



public class Server {
    public static void main(String[] args) throws IOException {
        int arrFromClient[]=new int[10];
        int j=0;
        ServerSocket welcomeSocket = new ServerSocket(1234);
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            for(int i=0;i<10;i++) {
                arrFromClient[i] = inFromClient.readInt();
            }

             
                for(int i=0;i<arrFromClient.length;i++){  
                if(arrFromClient[i]%2==0){  
                    j++; 
                    }  
                } 
                outToClient.writeInt(j);


            Arrays.sort(arrFromClient);
            for (int i = 0; i < arrFromClient.length; i++) {
                outToClient.writeInt(arrFromClient[i]);
            }

            
                }  
            }  
        
    }


  

