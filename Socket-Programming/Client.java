import java.io.*;
import java.net.*;
class Client
{
  public static void main(String args[])
  {
    try
    {
      Socket skt = new Socket("localhost",1234);
      BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
      System.out.print("Received message : ");
      System.out.println(in.readLine());
      in.close();
    }
    catch(Exception e)
    {
      System.out.println("Unsuccessful!!");
    }
  }
}
