import java.net.*;
import java.io.*;

public class ServerScript {
    public static void main(String args[]) throws IOException{

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        //Server socket for establishing a server connection
        ServerSocket server_socket = null;

        //Client type socket for establishing connection with the server
        Socket client_socket;

        //For receiving messages from the client
        DataInputStream server_in = null;

        int port;

        System.out.println("Enter you connection port");
        port = Integer.parseInt(stdin.readLine());

        try{
            server_socket = new ServerSocket(port);
            System.out.println("Server Booted");
            System.out.println("Listening for Clients...");
            client_socket = server_socket.accept();
            server_in = new DataInputStream(client_socket.getInputStream());
        } 
        catch( IOException e){
            System.out.println("Could not establish connection using mentioned port number");
        }

        System.out.println("Connection Established with Client");


        String client_mssg = "";

        while(!client_mssg.equalsIgnoreCase("disconnect")){
            client_mssg = server_in.readUTF();
            System.out.println("Client : "+ client_mssg);
        }

        System.out.println("Client disconnected");
        server_socket.close();
        server_in.close();
    }
}
