import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


 class Client {
    

public static void main(String args[]) throws UnknownHostException, IOException{

    int arr[]=new int[10];
int arrFromServer[]=new int[10];
int j=0;
Scanner inFromUser= new Scanner(System.in);
try (Socket clientSocket = new Socket("localhost",1234)) {
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
    for(int i=0;i<10;i++)
        arr[i]=inFromUser.nextInt();

    for(int i=0;i<10;i++)
        outToServer.writeInt(arr[i]);

        j=inFromServer.readInt();
        System.out.println("The Even numbers in given array is:" + j);

    for(int i=0;i<10;i++)
        arrFromServer[i]=inFromServer.readInt();

    for (int i = 0; i < arrFromServer.length; i++) {
        System.out.println("From Server::"+arrFromServer[i]);
    }

}

}
 }