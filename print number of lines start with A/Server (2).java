import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] args){
		try{
			ServerSocket srvr = new ServerSocket(9999);
			Socket skt = srvr.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			FileOutputStream fout = new FileOutputStream(args[0]);
			String str = "";
			while(true){
				str = in.readLine();
				if(str==null)
					break;
				if(str.startsWith("A ")){
					str = str + '\n' +'\n';
					for(int i = 0; i<str.length(); ++i){
						fout.write(str.charAt(i));
					}
				}
			}
			fout.close();
			in.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}