import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_prime_factor
{
    static int num;
    static Socket s;
    static BufferedReader br ;
    static PrintWriter out;
    Client_prime_factor(int n)
    {
        num = n;
        s = null;
        br = null;
        out = null;
    }
    static void connect() throws Exception
    {
        System.out.println("C: Client is Starting");
        int port = 1231;
        String ip = "localhost";
        s = new Socket(ip,port);
        System.out.println("C: Client Started Operations");
    }
    static void input() throws IOException
    {
        System.out.println("C : Enter a number: ");
        br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
    }
    static void to_server() throws IOException {
        System.out.println("C : Sending user input number " + num + " to Server ");
        out = new PrintWriter(s.getOutputStream(),true);
        out.println(num);
        System.out.println("C: Number sent..\nC : Waiting for server response...");
    }
    static void from_server() throws IOException {
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String output = br.readLine();
        System.out.println("C : The Prime factors of "+ num + " are : "+ output);
    }
    public static void main(String[] args) throws Exception {

        connect();
        input();
        to_server();
        from_server();


        out.close();
        s.close();
    }
}
