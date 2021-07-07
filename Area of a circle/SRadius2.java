import java.net.*;
import java.io.*;

class SRadius2
{
	public static void main(String argv[])throws Exception
	{
		ServerSocket server= new ServerSocket(1234);
		Socket socket=server.accept();
		System.out.println("Server has connected");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//System.out.println(in.readLine());
		String str=in.readLine();
		System.out.print("RECEIVED RADIUS.."+str);
		double r=Double.parseDouble(str);
		double area = 3.14*r*r;
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		out.println(area);
		//in.close();
		out.close();
		socket.close();
		server.close();
	}
}