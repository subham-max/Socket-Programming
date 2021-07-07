import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Chat_Client
{
    static Socket soc;
    static  String str;
    static BufferedReader br;
    static PrintWriter out;
    Chat_Client()
    {
        soc = null;
        br = null;
        out = null;
        str = " ";

    }
    static void connect() throws IOException {
        System.out.println("C: Client is Starting");
        int port = 9999;
//        String ip = "192.168.1.102";
        String ip = "localhost";
        soc = new Socket(ip,port);
        System.out.println("C: Client ready to Chat");
    }
    static void client_input() throws IOException
    {
        System.out.print("C :  ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }
    static void client_listens() throws IOException {
        br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String output = br.readLine();
        System.out.println("S : "+ output);
    }
    static void c_chat()
    {
        try {
            do {
                client_input();
                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                out.println(str);
                client_listens();
            }while(!(str.equals("Quit")));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        try {
            connect();
            c_chat();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
