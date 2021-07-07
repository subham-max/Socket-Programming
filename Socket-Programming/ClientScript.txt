import java.net.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class ClientScript {
    public static void main(String args[]) throws IOException{

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        //Client Socket
        Socket socket = null;

        //For taking client inputs
        BufferedReader client_in = null;

        //For sending the client messeges to server
        DataOutputStream client_out = null;

        String ip = null;
        int port;

        System.out.println("Enter server IP");
        ip = stdin.readLine();

        //Both server and client port numbers should be the same for a successful connection
        System.out.println("Enter your communication port");
        port = Integer.parseInt(stdin.readLine());

        System.out.println("Establishing connection...");

        try{
            TimeUnit.SECONDS.sleep(2);
            socket = new Socket(ip, port);
            client_in = new BufferedReader(new InputStreamReader(System.in));
            client_out = new DataOutputStream(socket.getOutputStream());
        }
        catch(InterruptedException interrupt){
            System.out.println("Connection process interrupted...");
        }
        catch(UnknownHostException nohost){
            System.out.println("Couldn\'t locate mentioned host...");
        }

        System.out.println("Connection Established...");
        String mssg = "";

        while(!mssg.equalsIgnoreCase("disconnect")){
            mssg = client_in.readLine();
            client_out.writeUTF(mssg);
        }

        System.out.println("Disconnected from the server...");
        socket.close();
        client_in.close();
    }
}
