import java.io.*;
import java.util.*;
import java.net.*;
class sop
{
  public static void main(String args[])throws IOException
  {
    try
    {
      String wop = "",rop = "",op11 = "",op22 = "",op = "";
      double op1,op2,r=0.0;
      int c=0,l,i,flag = 0;
      char x;
      ServerSocket srvr = new ServerSocket(1234);
      Socket skt = srvr.accept();
      System.out.println("Server has connected");
      PrintWriter out = new PrintWriter(skt.getOutputStream(),true);
      BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
      wop = br.readLine();
      wop = wop + " ";
      StringTokenizer st = new StringTokenizer(wop);
      while(st.hasMoreTokens() == true)
      {
        c = c + 1;
        op = st.nextToken();
      }
      if((op != "+" && op != "-" && op != "*" && op != "/") || c>3)
      {
        out.println("The expression is invalid");
        System.out.println("The expression is invalid");
      }
      else
      {
        StringTokenizer str = new StringTokenizer(wop);
        while(str.hasMoreTokens())
        {
          op11 = str.nextToken();
          op22 = str.nextToken();
          op =  str.nextToken();
        }
        wop = wop.trim();
        l = op11.length();
        for(i=0;i<l;i++)
        {
          x = op11.charAt(i); 
          if(Character.isLetter(x) == true)
            flag = 1;
        }
        l = op22.length();
        for(i=0;i<l;i++)
        {
          x = op22.charAt(i); 
          if(Character.isLetter(x) == true)
            flag = 1;
        }
        if(flag == 1)
        {
          out.println("The expression is invalid");
          System.out.println("The expression is invalid");
        }
        else
        {  
          op1 = Double.parseDouble(op11);
          op2 = Double.parseDouble(op22);    
          if(op == "+")
            r = op1 + op2;
          else
          if(op == "-")
            r = op1 - op2;
          else
          if(op == "*")
            r = op1 * op2;
          else
            r = op1 / op2;
        rop = "The expression is : " + op11 + " " + op + " " + op22 + " = " + Double.toString(r);
        System.out.println(rop);
        out.println(rop);
       }
      } 
      br.close();
      out.close();
      skt.close();
      srvr.close();
    }
    catch(Exception e)
    {
      System.out.println("Unsuccessful!!");
    }
  }
} 
