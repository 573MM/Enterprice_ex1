package another;
import java.io.*;
import java.net.*;
class TCPClient{
    public static void main(String[] args) throws Exception{
        //int num1 = 2;
        //int num2 = 5;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clienSocket = new Socket("localhost", 1776);

        int num1;
        int num2;
        
        DataOutputStream outToserver = new DataOutputStream(clienSocket.getOutputStream());
        DataInputStream  inFromServer = new DataInputStream(clienSocket.getInputStream());
        while (true) {
            System.out.print("enter number 1 (to end just press enter):");
            String input = inFromUser.readLine();
            if (isnotOK(input)){
                break;
            }
            num1 = Integer.parseInt(input);
            outToserver.writeInt(num1);

            System.out.print("enter number 2 (to end just press enter):");
            input = inFromUser.readLine();
            if (isnotOK(input)){
                break;
            }
            num2 = Integer.parseInt(input);
            outToserver.writeInt(num2);


            int sum = inFromServer.readInt();
            System.out.println("The result is : "+ sum);
            clienSocket.close();
            break;
        }
        
    }

    public static boolean isnotOK(String str){
        if(str.equals("")){
            return true;
        }else return false;
    }
}