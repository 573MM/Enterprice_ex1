package another;
import java.io.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] args) throws Exception {
        int num1;
        int num2;
        ServerSocket welcomeSocket = new ServerSocket(1776);
        while (true) {
            System.out.println("Waiting for client connection at port number 1667");
            Socket connectionSocket = welcomeSocket.accept();
            //BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            num1 = inFromClient.readInt();
            num2 = inFromClient.readInt();
            int sum = num1 + num2;
            outToClient.writeInt(sum);
        }
    }
}
