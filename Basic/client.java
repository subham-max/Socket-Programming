import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class client
{
    public static void main(String[] args) throws IOException {
        int port = 1231;
        String ip = "localhost";
        Socket s = new Socket(ip,port);

        String st = "Master Timo";
        System.out.println("Sending %s to Server : " + st);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.print(st);
        out.close();
        s.close();
    }
}
