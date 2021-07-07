import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server
{
    public static void main(String[] args) throws Exception
    {
            int port = 1231;
            System.out.println("Server is Starting");
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server is Waiting for Client connection ....");
            Socket s = ss.accept();
            System.out.println("Client Connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        String st = ;
            System.out.println("Welcome to the Server Side " + br.readLine());
            br.close();
            s.close();
            ss.close();

    }
}
