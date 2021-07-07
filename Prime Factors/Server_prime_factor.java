import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_prime_factor
{
    static int num;
    static Socket s;
    static BufferedReader br ;
    static ServerSocket ss;
    static String st ;

    Server_prime_factor(int n)
    {
        num = n;
        ss = null;
        br = null;
        s = null;
        st =  " ";
    }

    static  void connect() throws IOException {
        int port = 1231;
        System.out.println("S: Server is Starting");
        ss = new ServerSocket(port);
        System.out.println("S: Server is Waiting for Client connection ....");
        s = ss.accept();
        System.out.println("S : Client Connected");

    }
    static void client_input_processing() throws IOException {
        System.out.println("S: Receiving Number....");
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        num = Integer.parseInt(br.readLine()) ;
        System.out.println("S: Number received....");
    }
    static void prime_factors()
    {
        st = "";
        int i;
        while (num%2==0)
        {
            st += 2 + " ";
            num /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (i = 3; i <= Math.sqrt(num); i+= 2)
        {
            while (num%i == 0)
            {
                st += i + " ";
                num /= i;
            }
        }
        if (num > 2) {
            st += num + " ";
        }
    }
    static void server_sends() throws IOException {
        System.out.println("S: Sending user input number " + num +"'s prime factors " + st + " to Client ");
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        out.println(st);
        out.close();
    }
    public static void main(String[] args) throws IOException {

        connect();
        client_input_processing();
        prime_factors();
        server_sends();


        br.close();
        s.close();
        ss.close();

    }
}