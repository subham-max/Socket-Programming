import java.io.*;
import java.net.*;
class cop
{
  public static void main(String args[])throws IOException
  {
    try
    {
      String wop="",rop="";
      Socket skt = new Socket("localhost",1234);
      System.out.println("Client has Connection");
      PrintWriter outp = new PrintWriter(skt.getOutputStream(),true);
      BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
      BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter an expression in postfix form : ");
      wop = br2.readLine();
      System.out.println("Sending Expression : " + wop);
      outp.println(wop);
      rop = in.readLine();
      System.out.println(rop);
      outp.close();
      in.close();
    }
    catch(Exception e)
    {
      System.out.println("Unsuccessful!!");
    }
  }
}
