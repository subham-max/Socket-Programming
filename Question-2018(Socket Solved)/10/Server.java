import java.net.*;
import java.io.*;



 class Server {
    
    public static void main(String args[]){

        try{
            ServerSocket server= new ServerSocket(1234);
            Socket skt= server.accept();
            System.out.println("Connection Established");
            BufferedReader Clientinput= new BufferedReader(new InputStreamReader(skt.getInputStream()));
            int array[]= new int[5];
            for(int i=0;i<5;i++){
                 array[i]= Integer.parseInt(Clientinput.readLine());
            }
            
            PrintWriter out= new PrintWriter(skt.getOutputStream(),true);
            Server ob= new Server();
            ob.Sort(array);
            for(int i=0;i<5;i++){
            out.println(array[i]);
            }

            server.close();
            skt.close();
        }
        catch(Exception e){
            System.out.println("Unsuccesful server");
        }
    }

    void Sort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    

    
}
