import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args){
		String str = ""; int c = 0; 
		try{
			Socket skt = new Socket("user-PC", 9999);
			InputStream fin = new FileInputStream(args[0]);
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			while(true){
				c = fin.read();
				if(c==-1){
					out.println(str);
					break;
				}
				else if(c!='\n')
					str = str + (char)c;
				else if(c=='\n'){
					out.println(str);
					str = "";
				}
			}
			out.close();
			fin.close();
			skt.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}			