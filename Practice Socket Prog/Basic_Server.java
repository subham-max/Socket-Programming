import java.net.*;



import java.io.*;

class Basic_Server{

    public static void main(String args[]){
        try{
            ServerSocket svr= new ServerSocket(1234);
            Socket skt =svr.accept();
            System.out.println("Connection Established");

            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the string: ");
            String str= br.readLine();
            PrintWriter out= new PrintWriter(skt.getOutputStream(),true);
            out.println(str);

            skt.close();
            svr.close();
        }
        catch(Exception e){
            System.out.println("Unsuccessfull");
        }
    }
}