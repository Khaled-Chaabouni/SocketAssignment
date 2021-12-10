import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Server {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = serverSocket.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        ////////////////////////////////////////////////////
        String str=inServer.readLine();
        List<Character> vowels= Arrays.asList('o','i','y','e','a','u');
        String output="";
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(!(vowels.contains(Character.toLowerCase(c)))){
                output+=c;
            }
        }
        outServer.println(output);
        ////////////////////////////////////////////////////

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
        serverSocket.close();
    }
}
