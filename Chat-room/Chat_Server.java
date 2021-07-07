import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat_Server
{
    static Socket soc ;
    static ServerSocket ss;
    static String str;
    Chat_Server()
    {
        soc = null;
        ss = null;
        str = " ";
    }
    static void connect()
    {
        System.out.println("S: Connecting to the Client Chatroom");
        try {
            ss = new ServerSocket(9999);
            soc = ss.accept();
            System.out.println("S: Connection Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void server_input() throws IOException
    {
        System.out.print("S :  ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }
    static void s_chat()
    {
        try {
            do {
                server_listens();
                server_input();
                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                out.println(str);
            }while(!(str.equals("Quit")));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void server_listens()throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String output = br.readLine();
        System.out.println("C : "+ output);
    }
    public static void main(String[] args)
    {
        connect();
        s_chat();
    }
}
