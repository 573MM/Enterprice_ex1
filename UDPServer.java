import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UDPServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(1894);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        Date currentDate = new Date();
        while (true) {
            System.out.println("running...");
            DatagramPacket receivPacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivPacket);
            String sentence = new String(receivPacket.getData());
            System.out.println(sentence);
            InetAddress ipAddress = receivPacket.getAddress();
            int port = receivPacket.getPort();
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = formatter.format(currentDate);
            
            sendData = formattedDateTime.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, ipAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
