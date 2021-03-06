import java.io.*;
import java.net.*;

class Server{
	public static void main(String args[])throws Exception{
		ServerSocket ss = new ServerSocket(8989);
		System.out.println("Server Started!");
		Socket s = ss.accept();
		System.out.println("Client Connected");
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		DataInputStream din = new DataInputStream(s.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a sentence : ");
		String sen = br.readLine();
		dout.writeUTF(sen);
		String res = din.readUTF();
		FileWriter fr = new FileWriter("myOutput.txt");
		for(int i=0; i<res.length(); i++)
			fr.write(res.charAt(i));
		fr.close();
		System.out.println("File Created!");
		din.close();
		dout.close();
		br.close();
		s.close();
		System.out.println("Client Disconnected!");
		ss.close();
		System.out.println("Server shutdown!");
	}
}