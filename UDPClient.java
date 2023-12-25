import java.io.*;
import java.net.*;
public class UDPClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket clienSocket = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getByName("localhost");

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        String sentence = "hello";
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 1894);
        clienSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clienSocket.receive(receivePacket);
        String output = new String(receivePacket.getData());

        System.out.println("Current Date and Time: " + output);
    }
}
