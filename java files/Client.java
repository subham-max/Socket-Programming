import java.io.*;
import java.net.*;
import java.util.*;

class Client{
	public static void main(String args[])throws Exception{
		Socket s = new Socket("localhost", 8989);
		System.out.println("Connected to server!");
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		DataInputStream din = new DataInputStream(s.getInputStream());
		String sen = din.readUTF();
		StringTokenizer st = new StringTokenizer(sen);
		String res="";
		System.out.println();
		while(st.hasMoreTokens()){
			String tmp = st.nextToken();
			switch(tmp.charAt(0)){
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':	res += tmp+" ";
							System.out.println(tmp);
							break;
			}
		}
		System.out.println();
		dout.writeUTF(res);
		din.close();
		dout.close();
		s.close();
		System.out.println("Disconnected from server!");
	}
}